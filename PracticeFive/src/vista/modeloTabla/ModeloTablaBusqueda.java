package vista.modeloTabla;

import controlador.dao.ObraDAO;
import controlador.ed.lista.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Compositor;
import modelo.Obra;

public class ModeloTablaBusqueda extends AbstractTableModel {

    private ListaEnlazada<Compositor> lista = new ListaEnlazada<>();

    @Override
    public int getRowCount() {
        return getLista().size();

    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Compositor s = null;
        try {
            s = getLista().get(i);
        } catch (Exception e) {
        }
        switch (i1) {
            case 0:
                return (i + 1);
            case 1:
                return (s != null) ? s.getNombre() : "No definido";
            case 2:
                return (s != null) ? s.getAlbunes() : "No definido";
            case 3:
                return (s != null) ? s.getGenero() : "No definido";
            case 4:
                // Obtener el nombre de la obra directamente desde el compositor
                return (s != null) ? new ObraDAO().obtener(s.getId_obra()) : "No definido";
            default:
                return null;
        }
    }

    private String obtenerNombreObra(Compositor compositor) {
        String nombreObra = "No definido";
        try {
            Integer idObra = compositor.getId_obra();
            if (idObra != null) {
                // Utiliza el ID de la obra para obtener el nombre directamente
                ObraDAO obraDAO = new ObraDAO();
                Obra obra = obraDAO.obtener(idObra.intValue()); // Convierte el Integer a int
                if (obra != null) {
                    nombreObra = obra.getNombre();
                }
            }
        } catch (Exception e) {
        }
        return nombreObra;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "NOMBRE";
            case 2:
                return "PROYECTOS";
            case 3:
                return "GENERO";
            case 4:
                return "OBRA";

            default:
                return null;
        }
    }

    public ListaEnlazada<Compositor> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<Compositor> lista) {
        this.lista = lista;
    }

}

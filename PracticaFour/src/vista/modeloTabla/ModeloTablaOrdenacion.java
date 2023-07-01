package vista.modeloTabla;

import static controlador.control.generarNumerosAleatorios;
import controlador.ed.lista.ListaEnlazada;
import java.util.Random;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaOrdenacion extends AbstractTableModel {

    private ListaEnlazada<Integer> lista = new ListaEnlazada<>();

    public ModeloTablaOrdenacion(int cantidadDatos) {
        generarNumerosAleatorios(lista, cantidadDatos);
    }

    @Override
    public int getRowCount() {
        return getLista().size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            return getLista().get(rowIndex);
        } catch (Exception e) {
            return "No definido";
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        try {
            int newValue = Integer.parseInt(aValue.toString());
            getLista().set(rowIndex, newValue);
        } catch (Exception e) {
            System.out.println("Error al modificar el valor: " + e.getMessage());
        }
    }

    @Override
    public String getColumnName(int column) {
        return "Datos Numéricos";
    }

    /**
     * @return the lista
     */
    public ListaEnlazada<Integer> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(ListaEnlazada<Integer> lista) {
        this.lista = lista;
    }

    public void actualizarDatos() {
        fireTableDataChanged(); // Notificar a la tabla que los datos han cambiado
    }

    public void cargarDatos(int cantidadDatos) {
        lista = new ListaEnlazada<>();
        generarNumerosAleatorios(lista, cantidadDatos);
        actualizarDatos();
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.utilidades;

import controlador.dao.AdaptadorDao;
import controlador.dao.ObraDAO;
import controlador.ed.lista.ListaEnlazada;
import javax.swing.JComboBox;
import modelo.Obra;

/**
 *
 * @author emilio
 */
public class UtilidadesVista {

    public static void cargarObra(JComboBox cbx, ObraDAO od) throws Exception {
        cbx.removeAllItems();
        ListaEnlazada<Obra> obras = od.listar();

        if (obras != null) {
            for (int i = 0; i < obras.size(); i++) {
                Obra obraEncontrada = obras.get(i);
                String nombreObraUpperCase = obraEncontrada.getNombre().toUpperCase();
                int idObra = obraEncontrada.getId();
                String item = nombreObraUpperCase;
                cbx.addItem(item);
            }
        }
    }

}

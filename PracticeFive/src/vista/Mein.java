/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vista;

import controlador.dao.CompositorDAO;
import controlador.dao.ObraDAO;
import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.NodoLista;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;
import java.io.IOException;
import modelo.Compositor;

/**
 *
 * @author Bravo
 */
public class Mein {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws VacioException, PosicionException, IOException {
        CompositorDAO cd = new CompositorDAO();
        ObraDAO od = new ObraDAO();
        
        od.getObra().setId(1);
        od.getObra().setNombre("MUSICAL");
        od.guardar();
        
        od.getObra().setId(2);
        od.getObra().setNombre("TEATRAL");
        od.guardar();
        
        od.getObra().setId(3);
        od.getObra().setNombre("LITERARIA");
        od.guardar();
        
        od.getObra().setId(4);
        od.getObra().setNombre("ESTUDIANTIL");
        od.guardar();


    }
}

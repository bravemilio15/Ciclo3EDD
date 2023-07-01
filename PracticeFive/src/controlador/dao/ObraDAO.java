/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.busqueda.BusquedaBinaria;
import controlador.busqueda.BusquedaLinealBinaria;
import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;
import controlador.ordenacion.MergeSort;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Comparator;
import modelo.Obra;
import modelo.Obra.ObraComparator;

/**
 *
 * @author emilio
 */
public class ObraDAO extends AdaptadorDao<Obra> {

    private Obra obra;

    public ObraDAO() {
        super(Obra.class);
    }

    public Obra getObra() {
        if (obra == null) {
            this.obra = new Obra();
        }
        return obra;
    }

    public void setObra(Obra obra) {
        this.obra = obra;
    }

    public void guardar() throws IOException {
        this.guardar(obra);

    }

    public void modificar(Integer pos) throws IOException {
        this.modificar(pos);
    }

    private Integer generarID() {
        return listar().size() + 1;

    }

    /**
     *
     * @param id
     * @return
     * @throws VacioException
     * @throws PosicionException
     */
   
    

    //caso 1 Me deuvle 1 valor y no Todos ARREGLAR
    public Obra buscarPorNombre(String dato) throws Exception {
        Obra resultado = null;
        ListaEnlazada<Obra> lista = listar();

        for (int i = 0; i < lista.size(); i++) {
            Obra aux = lista.get(i);
            if (aux.getNombre().equalsIgnoreCase(dato)) {
                resultado = aux;
                break;
            }
        }

        return resultado;
    }
}

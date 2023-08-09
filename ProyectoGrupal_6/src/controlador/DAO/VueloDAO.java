/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.DAO;

import controlador.ed.grafo.GrafoEtiquetadoD;
import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import modelo.Aeropuerto;
import modelo.Vuelo;

/**
 *
 * @author Bravo
 */
public class VueloDAO extends AdaptadorDao<Vuelo> {

    private Vuelo vuelo;
    private GrafoEtiquetadoD<Vuelo> grafo;
    private GrafoEtiquetadoD<Aeropuerto> graf;

    public VueloDAO() {
        super(Vuelo.class);
    }

    public Vuelo getVuelo() {
        if (this.vuelo == null) {
            this.vuelo = new Vuelo();
        }
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public GrafoEtiquetadoD<Aeropuerto> getGraf() {
        return graf;
    }

    public void setGraf(GrafoEtiquetadoD<Aeropuerto> graf) {
        this.graf = graf;
    }

    public GrafoEtiquetadoD<Vuelo> getGrafo() {
        return grafo;
    }

    public void setGrafo(GrafoEtiquetadoD<Vuelo> grafo) {
        this.grafo = grafo;
    }

    public void guardar() throws IOException {
        vuelo.setId(generateID());
        this.guardar(vuelo);
    }

    public void modificar(Integer pos) throws VacioException, PosicionException, IOException {
        this.modificar(vuelo, pos);
    }

    private Integer generateID() {
        return listar().size() + 1;
    }

    public ListaEnlazada<Vuelo> listaPorAeropuerto(String nombreAeropuerto) throws VacioException, PosicionException {
        ListaEnlazada<Vuelo> lista = new ListaEnlazada<>();
        ListaEnlazada<Vuelo> listado = listar();

        for (int i = 0; i < listado.size(); i++) {
            Vuelo aux = listado.get(i);

            if (aux.getOrigen().equals(nombreAeropuerto)) {
                lista.insertar(aux);
            }
        }

        return lista;
    }

    public static void main(String[] args) throws IOException {

        VueloDAO vd = new VueloDAO();
        AeropuertoDAO ad = new AeropuertoDAO();

        // JFK a LAX
        vd.getVuelo().setDuracion(6);
        vd.getVuelo().setOrigen("Aeropuerto JFK");
        vd.getVuelo().setDestino("Aeropuerto LAX");
        vd.guardar();

// LAX a Heathrow
        vd.getVuelo().setDuracion(11);
        vd.getVuelo().setOrigen("Aeropuerto LAX");
        vd.getVuelo().setDestino("Aeropuerto Heathrow");
        vd.guardar();

// Heathrow a Charles de Gaulle
        vd.getVuelo().setDuracion(1);
        vd.getVuelo().setOrigen("Aeropuerto Heathrow");
        vd.getVuelo().setDestino("Aeropuerto Charles de Gaulle");
        vd.guardar();

// Charles de Gaulle a Narita
        vd.getVuelo().setDuracion(12);
        vd.getVuelo().setOrigen("Aeropuerto Charles de Gaulle");
        vd.getVuelo().setDestino("Aeropuerto Narita");
        vd.guardar();

// Narita a Sydney
        vd.getVuelo().setDuracion(9);
        vd.getVuelo().setOrigen("Aeropuerto Narita");
        vd.getVuelo().setDestino("Aeropuerto Sydney");
        vd.guardar();

// Sydney a El Dorado
        vd.getVuelo().setDuracion(18);
        vd.getVuelo().setOrigen("Aeropuerto Sydney");
        vd.getVuelo().setDestino("Aeropuerto El Dorado");
        vd.guardar();

// El Dorado a Jorge Chávez
        vd.getVuelo().setDuracion(5);
        vd.getVuelo().setOrigen("Aeropuerto El Dorado");
        vd.getVuelo().setDestino("Aeropuerto Jorge Chávez");
        vd.guardar();

// Jorge Chávez a Benito Juárez
        vd.getVuelo().setDuracion(7);
        vd.getVuelo().setOrigen("Aeropuerto Jorge Chávez");
        vd.getVuelo().setDestino("Aeropuerto Benito Juárez");
        vd.guardar();

// Benito Juárez a Dubai
        vd.getVuelo().setDuracion(16);
        vd.getVuelo().setOrigen("Aeropuerto Benito Juárez");
        vd.getVuelo().setDestino("Aeropuerto Dubai");
        vd.guardar();

// Dubai a Changi
        vd.getVuelo().setDuracion(7);
        vd.getVuelo().setOrigen("Aeropuerto Dubai");
        vd.getVuelo().setDestino("Aeropuerto Changi");
        vd.guardar();
        
        

// Changi a Hong Kong
        vd.getVuelo().setDuracion(4);
        vd.getVuelo().setOrigen("Aeropuerto Changi");
        vd.getVuelo().setDestino("Aeropuerto Hong Kong");
        vd.guardar();

// Hong Kong a Incheon
        vd.getVuelo().setDuracion(3);
        vd.getVuelo().setOrigen("Aeropuerto Hong Kong");
        vd.getVuelo().setDestino("Aeropuerto Incheon");
        vd.guardar();

 //Incheon a Heathrow
        vd.getVuelo().setDuracion(11);
        vd.getVuelo().setOrigen("Aeropuerto Incheon");
        vd.getVuelo().setDestino("Aeropuerto Heathrow");
        vd.guardar();

 //Heathrow a Narita
        vd.getVuelo().setDuracion(11);
        vd.getVuelo().setOrigen("Aeropuerto Heathrow");
        vd.getVuelo().setDestino("Aeropuerto Narita");
        vd.guardar();

 //Narita a Sydney
        vd.getVuelo().setDuracion(9);
        vd.getVuelo().setOrigen("Aeropuerto Narita");
        vd.getVuelo().setDestino("Aeropuerto Sydney");
        vd.guardar();

 //Sydney a O'Hare
        vd.getVuelo().setDuracion(16);
        vd.getVuelo().setOrigen("Aeropuerto Sydney");
        vd.getVuelo().setDestino("Aeropuerto O'Hare");
        vd.guardar();

 //O'Hare a Pearson
        vd.getVuelo().setDuracion(1);
        vd.getVuelo().setOrigen("Aeropuerto O'Hare");
        vd.getVuelo().setDestino("Aeropuerto Pearson");
        vd.guardar();

 //Pearson a Guarulhos
        vd.getVuelo().setDuracion(10);
        vd.getVuelo().setOrigen("Aeropuerto Pearson");
        vd.getVuelo().setDestino("Aeropuerto Guarulhos");
        vd.guardar();

 //Guarulhos a Cancún
        vd.getVuelo().setDuracion(8);
        vd.getVuelo().setOrigen("Aeropuerto Guarulhos");
        vd.getVuelo().setDestino("Aeropuerto Cancún");
        vd.guardar();

 //Cancún a Hamad
        vd.getVuelo().setDuracion(18);
        vd.getVuelo().setOrigen("Aeropuerto Cancún");
        vd.getVuelo().setDestino("Aeropuerto Hamad");
        vd.guardar();

// Hamad a Kuala Lumpur
        vd.getVuelo().setDuracion(7);
        vd.getVuelo().setOrigen("Aeropuerto Hamad");
        vd.getVuelo().setDestino("Aeropuerto Kuala Lumpur");
        vd.guardar();

// Kuala Lumpur a Atenas
        vd.getVuelo().setDuracion(12);
        vd.getVuelo().setOrigen("Aeropuerto Kuala Lumpur");
        vd.getVuelo().setDestino("Aeropuerto Atenas");
        vd.guardar();

// Atenas a Schiphol
        vd.getVuelo().setDuracion(4);
        vd.getVuelo().setOrigen("Aeropuerto Atenas");
        vd.getVuelo().setDestino("Aeropuerto Schiphol");
        vd.guardar();

// Schiphol a Ministro Pistarini
        vd.getVuelo().setDuracion(12);
        vd.getVuelo().setOrigen("Aeropuerto Schiphol");
        vd.getVuelo().setDestino("Aeropuerto Ministro Pistarini");
        vd.guardar();

// Ministro Pistarini a Ezeiza
        vd.getVuelo().setDuracion(0);
        vd.getVuelo().setOrigen("Aeropuerto Ministro Pistarini");
        vd.getVuelo().setDestino("Aeropuerto Ezeiza");
        vd.guardar();

// Ezeiza a Kansai
        vd.getVuelo().setDuracion(18);
        vd.getVuelo().setOrigen("Aeropuerto Ezeiza");
        vd.getVuelo().setDestino("Aeropuerto Kansai");
        vd.guardar();

// Kansai a Jorge Wilstermann
        vd.getVuelo().setDuracion(19);
        vd.getVuelo().setOrigen("Aeropuerto Kansai");
        vd.getVuelo().setDestino("Aeropuerto Jorge Wilstermann");
        vd.guardar();

        // Jorge Wilstermann a Aeropuerto Internacional JFK
        vd.getVuelo().setDuracion(20);
        vd.getVuelo().setOrigen("Aeropuerto Jorge Wilstermann");
        vd.getVuelo().setDestino("Aeropuerto Internacional JFK");
        vd.guardar();

// Aeropuerto Internacional JFK a Aeropuerto Internacional LAX
        vd.getVuelo().setDuracion(5);
        vd.getVuelo().setOrigen("Aeropuerto Internacional JFK");
        vd.getVuelo().setDestino("Aeropuerto Internacional LAX");
        vd.guardar();

// Aeropuerto Internacional LAX a Aeropuerto Heathrow
        vd.getVuelo().setDuracion(9);
        vd.getVuelo().setOrigen("Aeropuerto Internacional LAX");
        vd.getVuelo().setDestino("Aeropuerto Heathrow");
        vd.guardar();

    }
}

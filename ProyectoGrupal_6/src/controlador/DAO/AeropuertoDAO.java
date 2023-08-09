/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.DAO;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;
import java.io.IOException;
import modelo.Aeropuerto;
import modelo.Aeropuerto;
import modelo.Vuelo;

/**
 *
 * @author Bravo
 */
public class AeropuertoDAO extends AdaptadorDao<Aeropuerto> {

    private Aeropuerto ae;

    public AeropuertoDAO() {
        super(Aeropuerto.class);
    }

    public Aeropuerto getAeropuerto() {
        if (this.ae == null) {
            this.ae = new Aeropuerto();
        }
        return ae;
    }

    public void setAeropuerto(Aeropuerto ae) {
        this.ae = ae;
    }

    public void guardar() throws IOException {
        ae.setId(generateID());
        this.guardar(ae);
    }

    public void modificar(Integer pos) throws VacioException, PosicionException, IOException {
        this.modificar(ae, pos);
    }

    private Integer generateID() {
        return listar().size() + 1;
    }

    public static void main(String[] args) throws IOException {
        AeropuertoDAO ad = new AeropuertoDAO();

        ad.getAeropuerto().setNombre("Aeropuerto JFK");
        ad.getAeropuerto().setCiudad("Nueva York");
        ad.guardar();

        ad.getAeropuerto().setNombre("Aeropuerto LAX");
        ad.getAeropuerto().setCiudad("Los Ángeles");
        ad.guardar();

        ad.getAeropuerto().setNombre("Aeropuerto Heathrow");
        ad.getAeropuerto().setCiudad("Londres");
        ad.guardar();

        ad.getAeropuerto().setNombre("Aeropuerto Charles de Gaulle");
        ad.getAeropuerto().setCiudad("París");
        ad.guardar();

        ad.getAeropuerto().setNombre("Aeropuerto Narita");
        ad.getAeropuerto().setCiudad("Tokio");
        ad.guardar();

        ad.getAeropuerto().setNombre("Aeropuerto Sydney");
        ad.getAeropuerto().setCiudad("Sídney");
        ad.guardar();

        ad.getAeropuerto().setNombre("Aeropuerto El Dorado");
        ad.getAeropuerto().setCiudad("Bogotá");
        ad.guardar();

        ad.getAeropuerto().setNombre("Aeropuerto Jorge Chávez");
        ad.getAeropuerto().setCiudad("Lima");
        ad.guardar();

        ad.getAeropuerto().setNombre("Aeropuerto Benito Juárez");
        ad.getAeropuerto().setCiudad("Ciudad de México");
        ad.guardar();

        ad.getAeropuerto().setNombre("Aeropuerto Dubai");
        ad.getAeropuerto().setCiudad("Dubái");
        ad.guardar();

        ad.getAeropuerto().setNombre("Aeropuerto Changi");
        ad.getAeropuerto().setCiudad("Singapur");
        ad.guardar();

        ad.getAeropuerto().setNombre("Aeropuerto Hong Kong");
        ad.getAeropuerto().setCiudad("Hong Kong");
        ad.guardar();

        ad.getAeropuerto().setNombre("Aeropuerto Incheon");
        ad.getAeropuerto().setCiudad("Seúl");
        ad.guardar();

        ad.getAeropuerto().setNombre("Aeropuerto Frankfurt");
        ad.getAeropuerto().setCiudad("Fráncfort");
        ad.guardar();

        ad.getAeropuerto().setNombre("Aeropuerto Atatürk");
        ad.getAeropuerto().setCiudad("Estambul");
        ad.guardar();

        ad.getAeropuerto().setNombre("Aeropuerto Adolfo Suárez Madrid-Barajas");
        ad.getAeropuerto().setCiudad("Madrid");
        ad.guardar();

        ad.getAeropuerto().setNombre("Aeropuerto Leonardo da Vinci-Fiumicino");
        ad.getAeropuerto().setCiudad("Roma");
        ad.guardar();

        ad.getAeropuerto().setNombre("Aeropuerto O'Hare");
        ad.getAeropuerto().setCiudad("Chicago");
        ad.guardar();

        ad.getAeropuerto().setNombre("Aeropuerto Pearson");
        ad.getAeropuerto().setCiudad("Toronto");
        ad.guardar();

        ad.getAeropuerto().setNombre("Aeropuerto Guarulhos");
        ad.getAeropuerto().setCiudad("São Paulo");
        ad.guardar();

        ad.getAeropuerto().setNombre("Aeropuerto Cancún");
        ad.getAeropuerto().setCiudad("Cancún");
        ad.guardar();

        ad.getAeropuerto().setNombre("Aeropuerto Hamad");
        ad.getAeropuerto().setCiudad("Doha");
        ad.guardar();

        ad.getAeropuerto().setNombre("Aeropuerto Kuala Lumpur");
        ad.getAeropuerto().setCiudad("Kuala Lumpur");
        ad.guardar();

        ad.getAeropuerto().setNombre("Aeropuerto Atenas");
        ad.getAeropuerto().setCiudad("Atenas");
        ad.guardar();

        ad.getAeropuerto().setNombre("Aeropuerto Sídney Kingsford Smith");
        ad.getAeropuerto().setCiudad("Sídney");
        ad.guardar();

        ad.getAeropuerto().setNombre("Aeropuerto Schiphol");
        ad.getAeropuerto().setCiudad("Ámsterdam");
        ad.guardar();

        ad.getAeropuerto().setNombre("Aeropuerto Ministro Pistarini");
        ad.getAeropuerto().setCiudad("Buenos Aires");
        ad.guardar();

        ad.getAeropuerto().setNombre("Aeropuerto Kansai");
        ad.getAeropuerto().setCiudad("Osaka");
        ad.guardar();

        ad.getAeropuerto().setNombre("Aeropuerto Jorge Wilstermann");
        ad.getAeropuerto().setCiudad("Cochabamba");
        ad.guardar();

        ad.getAeropuerto().setNombre("Aeropuerto Ezeiza");
        ad.getAeropuerto().setCiudad("Buenos Aires");
        ad.guardar();
    }

}

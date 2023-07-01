/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.ed.lista.ListaEnlazada;

/**
 *
 * @author Bravo
 */
public class control {

    public static void generarNumerosAleatorios(ListaEnlazada<Integer> lista, int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            int numero = (int) (Math.random() * 20_000) + 1; 
            lista.insertar(numero);
        }
    }

}

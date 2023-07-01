/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.ed.lista.exception;


public class VacioException extends Exception {

    public VacioException() {
        super("La lista se encuentra vacia");
    }

    public VacioException(String message) {
        super(message);
    }

}

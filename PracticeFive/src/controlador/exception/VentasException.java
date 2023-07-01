/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package controlador.exception;

public class VentasException extends Exception {

    public VentasException() {
    }

    public VentasException(String msg) {
        super("La posición del mes es invalida ");
    }
}

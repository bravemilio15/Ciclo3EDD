/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.ed.listaEnlazada.exception;

/**
 *
 * @author danny
 */
public class PosicionException extends Exception {

    /**
     * Creates a new instance of <code>PositionException</code> without detail
     * message.
     */
    public PosicionException() {
        super("Posicion no existente");
    }

    /**
     * Constructs an instance of <code>PositionException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public PosicionException(String msg) {
        super(msg);
    }
}

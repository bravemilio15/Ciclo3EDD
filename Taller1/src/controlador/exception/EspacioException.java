/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.exception;

/**
 *
 * @author danny
 */
public class EspacioException extends Exception{

    public EspacioException() {
        super("Esta Lleno o es Invalido");
    }

    public EspacioException(String message) {
        super(message);
    }
    
}

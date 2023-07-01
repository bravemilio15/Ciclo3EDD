/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.ed.lista.exception;

public class PosicionException extends Exception{

    public PosicionException(String message) {
        super(message);
    }

    public PosicionException() {
        super("La posicion no es valida");
    }
    
    
}

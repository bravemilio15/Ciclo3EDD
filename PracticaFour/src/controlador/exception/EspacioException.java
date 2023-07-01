/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package controlador.exception;

public class EspacioException extends Exception{

    public EspacioException() {
        super();
    }

    public EspacioException(String msg) {
        super("No hay espacio suficiente para almacenar mas sucursales");
    }
}

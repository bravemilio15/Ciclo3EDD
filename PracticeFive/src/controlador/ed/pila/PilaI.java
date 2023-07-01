/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.ed.pila;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;
import controlador.ed.pila.exception.TopeException;


public class PilaI<E> extends ListaEnlazada<E> {
    private Integer cima;

    public PilaI(Integer cima) {
        this.cima = cima;
    }

    public Boolean isFull(){
        return (size() >= cima);
        
    }
    
    public void push(E info) throws TopeException{
        if (!isFull()){
            insertarInicio(info);
        }else
            throw new TopeException();
    }
    
    public E pop() throws VacioException, PosicionException{
        E dato = null;
        if(!isEmpty()){
            throw new VacioException("Pila vacia");
        }else{
            return this.delete(0);
        }
    }
    
    public Integer getCima(){
        return cima;
    }

}

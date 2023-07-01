/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.ed.lista;

/**
 *
 * @author sfav
 */
public class NodoLista <E>{
    
    private E informacion; //Dato generico
    private NodoLista siguiente;

    public NodoLista() {
        //comienzan vacios
        informacion= null;
        siguiente = null;
    }

    public NodoLista(E informacion, NodoLista siguiente) {
        this.informacion = informacion;
        this.siguiente = siguiente;
    }

    public E getInformacion() {
        return informacion;
    }

    public void setInformacion(E informacion) {
        this.informacion = informacion;
    }

    public NodoLista getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLista siguiente) {
        this.siguiente = siguiente;
    }   
}

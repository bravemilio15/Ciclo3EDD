/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;
import java.io.IOException;

public interface InterfazDao<T> {
    /**
     * Metodo que permite realizar el guardado
     * @param obj Objeto del modelo
     */
    public void guardar(T obj) throws IOException;
    
    /**
     * Permite modificar los datos en u repositorio de datos
     * @param obj Objeto a modificar
     * @param pos posicion del arreglo
     */
    public void modificar(T obj, Integer pos) throws IOException,VacioException,PosicionException;
    public ListaEnlazada<T> listar();
    public T obtener(Integer id)throws VacioException, PosicionException;
    
    
    
}

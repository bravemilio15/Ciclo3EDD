/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import controlador.ed.lista.ListaEnlazada;
import controlador.ed.lista.exception.PosicionException;
import controlador.ed.lista.exception.VacioException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

public class AdaptadorDao<T> implements InterfazDao<T> {

    Conexion conexion;
    private Class clazz;
    private String url;
    public static Integer ASCENDENTE = 0;
    public static Integer DESCENDENTE = 1;

    public AdaptadorDao(Class clazz) {
        this.conexion = new Conexion();
        this.clazz = clazz;
        this.url = Conexion.URL + clazz.getSimpleName().toLowerCase() + ".json";
    }

    @Override
    public void guardar(T obj) throws IOException {
        ListaEnlazada<T> lista = listar();
        lista.insertar(obj);
        conexion.getXStream().alias(lista.getClass().getName(), ListaEnlazada.class);
        conexion.getXStream().toXML(lista, new FileWriter(url));
    }

    @Override
    public void modificar(T obj, Integer pos) throws IOException, VacioException, PosicionException {
        ListaEnlazada<T> lista = listar();
        lista.update(pos, obj);
        conexion.getXStream().alias(lista.getClass().getName(), ListaEnlazada.class);
        conexion.getXStream().toXML(lista, new FileWriter(url));
    }

    @Override
    public ListaEnlazada<T> listar() {
        ListaEnlazada<T> lista = new ListaEnlazada<>();
        try {
            lista = (ListaEnlazada<T>) conexion.getXStream().fromXML(new File(url));
        } catch (Exception e) {
            System.out.println(e);
        }
        return lista;
    }

    @Override
    public T obtener(Integer id) {
        T obj = null;
        ListaEnlazada<T> lista = listar();
        for (int i = 0; i < lista.size(); i++) {
            try {
                T dato = lista.get(i);
                if(id.intValue() == ((Integer)getValueField(dato)).intValue()){
                    obj = dato;
                    break;
                }
 
            } catch (Exception e) {
                System.out.println("Error en metodo" + e);
            }
        }

        return obj;
    }

    private Object getValueField(T dato) throws Exception {
        Method metodo = null;
        for (Method aux : this.clazz.getDeclaredMethods()) {

            if (aux.getName().toLowerCase().equalsIgnoreCase("getId")) {
                metodo = aux;
            }
        }

        if (metodo == null) {
            for (Method aux : this.clazz.getSuperclass().getDeclaredMethods()) {

                if (aux.getName().toLowerCase().equalsIgnoreCase("getId")) {
                    metodo = aux;
                }
            }
        }

        return metodo.invoke(dato);
    }

}

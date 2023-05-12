/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.util;

import modelo.Sucursal;



/**
 *
 * @author danny
 */
public class Utilities {
    public static void imprimir(Object [] objs){
        System.out.println("Lista de "+ objs.getClass().getSimpleName());
        for (Object o : objs) {
            System.out.println(o.toString());
        }
    }
    
    public static Double sumarVentas(Sucursal s){
        

        return null;
        

    }
    
    public static Double mediaVentas(Sucursal s){
        

        return null;
        

    }
}

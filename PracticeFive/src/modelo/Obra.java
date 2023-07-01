/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author emilio
 */
public class Obra {

    private Integer id;
    private String nombre;
    
     public Obra() {
    }
    
     public Obra(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String toString() {
        return nombre.toString();
    }

    public static class ObraComparator implements Comparator<Obra> {

        @Override
        public int compare(Obra o1, Obra o2) {
            return o1.getNombre().compareToIgnoreCase(o2.getNombre());
        }
    }
    
}

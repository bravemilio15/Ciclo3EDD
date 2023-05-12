/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.exception.EspacioException;
import modelo.Sucursal;
import modelo.Venta;

/**
 *
 * @author emilio
 */
public class SucursalControl {

    private Sucursal sucursal;
    private Venta venta;
    /// Lista de Sucursales
    
       public SucursalControl(String nombre) {
        getSucursal().setNombre(nombre);
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public boolean registrar() throws EspacioException {
        
        
        return true;
    }
    
    public boolean guardarVentas(Integer posVenta, Double valor) throws EspacioException{
       
        return true;
    }
 
    
    

}

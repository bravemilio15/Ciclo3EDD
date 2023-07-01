/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.dao;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class Conexion {
    private XStream xstream;
    public static String URL = "data/";
    
    private void conectar(){
        xstream = new XStream(new JettisonMappedXmlDriver());
        xstream.setMode(XStream.NO_REFERENCES);
        xstream.addPermission(AnyTypePermission.ANY);
    }
    
    public XStream getXStream(){
        if(xstream == null)
            conectar();
        return xstream;
    }
    
    public void setXstream(XStream xstream){
        this.xstream = xstream;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.edd.segundointento;

import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 *
 * @author Usuario
 */
public class BDContactos {
    public LinkedList<Contacto> obtener(){
        LinkedList<Contacto> Contactos=null;
        Archivo archivo=new Archivo("contactos.txt");
        LinkedList<String> lineas=archivo.obtenerTextoDelArchivo();
        if(lineas!=null){
            Contactos=new LinkedList();
            for(int i=0;i<lineas.size();i++){
                String linea=lineas.get(i);
                StringTokenizer tokens=new StringTokenizer(linea,";");
                String id=tokens.nextToken();
                String nombre=tokens.nextToken();
                String apellido=tokens.nextToken();
                long numero=Long.parseLong(tokens.nextToken());
                String direccion=tokens.nextToken();        
                Contactos.add(new Contacto(id,nombre,apellido, numero, direccion));
            }
        }
        return Contactos;
    }
    
    public boolean registrarContactos(Contacto C){
        Archivo archivo = new Archivo("contactos.txt");
        return archivo.registrarArchivo(C.getId()+";"+
                C.getNombre()+";"+C.getApellido()+";"+C.getNumero()+";"+C.getDireccion());
    }
}

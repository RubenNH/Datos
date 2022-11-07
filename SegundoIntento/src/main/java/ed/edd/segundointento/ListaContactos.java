/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.edd.segundointento;

import java.util.LinkedList;

/**
 *
 * @author Usuario
 */
public class ListaContactos {
    private LinkedList<Contacto> Contactos;

    public ListaContactos() {
        Contactos=new LinkedList();
    }
    
    public void agregar(Contacto a){
        Contactos.add(a);
    }
    
    public void eliminar(int indice){
        Contactos.remove(indice);
    }
       
       
    public int total(){
        return Contactos.size();
    }
    
    public Contacto obtener(int indice){
        return Contactos.get(indice);
    }
    
    public void cargarContactod(){
        BDContactos bd=new BDContactos();
        Contactos=bd.obtener();        
    }
    
    public void imprimirContactos(){
        for (int i = 0; i <Contactos.size(); i++) {
            System.out.println(Contactos.get(i).getId()+" "+Contactos.get(i).getNombre());
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.edd.segundointento;

import java.util.Collections;
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
    //carga los contacos  con orden como estan registrados
    public void cargarContactod(){
        BDContactos bd=new BDContactos();
        Contactos=bd.obtener();        
    }
    // carga los contactos ordenados, los trae del modeloçContacosOrdenados
    public void cargarContactosOrden(){
        BDContactos bd=new BDContactos();
        Contactos=bd.obtener();
        //ordena los datos
        Collections.sort(Contactos);
    }
    //acciones para guardar el archivo
    public void guardarEnArchivo(){
        BDContactos bd=new BDContactos();
        bd.borrarTodo();
        for(int i=0;i<Contactos.size();i++){
            bd.registrarContactos(Contactos.get(i));
        }
    }
    //imprime los contactos con un  for teniendo el limite el tamaño de la lista
    public void imprimirContactos(){
        for (int i = 0; i <Contactos.size(); i++) {
            System.out.println(Contactos.get(i).getId()+" "+Contactos.get(i).getNombre());
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.edd.segundointento;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Archivo{
    private String nombre; // declaramos el nombnre general que tendra el archivo a manipilar
    public Archivo(String nombre) {
        this.nombre=nombre;
    } // constructor


    //Genereamos un clase encargada de buscar el archivo de texto
    public LinkedList<String> obtenerTextoDelArchivo() {
        LinkedList<String> lineasDeTexto=null; //nueva LinkedList
        try {            
            File archivo = obtenerArchivo();//un Dato tipo file que tendra la direccion del archivo txt
            //Si el archivo es encontrado se empezaraa extraer las lineas de texto una por una
            if (archivo.exists()) {
                lineasDeTexto=new LinkedList();
                BufferedReader br = new BufferedReader(new FileReader(archivo));
                String linea;
                while ((linea = br.readLine()) != null) {
                    System.out.println(linea);
                    lineasDeTexto.add(linea);
                }
                br.close();//cerrar
            } else {//de lo contrario manda una notificacion
                JOptionPane.showMessageDialog(null, "El archivo de texto no existe");
            }
        } catch (Exception ex) {
            ex.printStackTrace();//so ocurre un error manda esta notificacion
            JOptionPane.showMessageDialog(null, "Se produjo un Error ");
        }
        return lineasDeTexto; // si logra funcionar el metodo devolvera los archivos como linked list
    }
    
    private File obtenerArchivo() {       
        try {
            URL url = getClass().getClassLoader().getResource("archivos/"+nombre);
            return new File(url.toURI());
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public boolean registrarArchivo(String linea) { 
        File archivo = obtenerArchivo();
        try {
            assert archivo != null;
            if(archivo.exists()){
                FileWriter fw = new FileWriter(archivo, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println(linea);
                pw.flush();
                pw.close();
                return true;
            }          
        } catch (Exception error) {
            error.printStackTrace();
        }
        return false;
    }

    public boolean borrarContenido(){
        try{
            File archivo = obtenerArchivo();
            assert archivo != null;
            String directorio = archivo.getParent();
            archivo.delete();
            new FileWriter(directorio + "/contactos.txt", true);
            return true;
        }catch (IOException ex){
            ex.printStackTrace();
        }
        return false;
    }
}

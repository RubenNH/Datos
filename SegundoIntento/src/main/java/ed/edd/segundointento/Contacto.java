/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.edd.segundointento;

/**
 *
 * @author Usuario
 */
public class Contacto {
    private String id;
    private String Nombre;
    private String Apellido;
    private long Numero;
    private String Direccion;

    public Contacto(String id, String Nombre, String Apellido, long Numero, String Direccion) {
        this.id = id;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Numero = Numero;
        this.Direccion = Direccion;
    }

    public Contacto() {
    }

    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public long getNumero() {
        return Numero;
    }

    public void setNumero(long Numero) {
        this.Numero = Numero;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
    
    
}

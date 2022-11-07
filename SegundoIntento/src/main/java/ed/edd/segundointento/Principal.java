/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.edd.segundointento;

import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Principal {
    public static void main(String[] args) {
        ListaContactos l = new ListaContactos();
        l.cargarContactod();
        l.imprimirContactos();
        
        BDContactos bd = new BDContactos();
        Contacto c = new Contacto("700", "Eduardo", "Pana", 77712365463L, "Enrique Segoviano");
        if(bd.registrarContactos(c)){
            JOptionPane.showMessageDialog(null, "Good");
        }
    }
}

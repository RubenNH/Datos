/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.edd.segundointento;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Usuario
 */
public class ModeloContactos extends AbstractTableModel{
    private ListaContactos contactos;

    public ModeloContactos() {
        contactos=new ListaContactos();
        contactos.cargarContactod();
    }
    
    
    @Override
    public int getRowCount() {
        return contactos.total();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Contacto aux=contactos.obtener(rowIndex);
        switch(columnIndex){
            case 0: return aux.getId();
            case 1: return aux.getNombre();
            case 2: return aux.getApellido();
            case 3: return aux.getNumero();
            default: return aux.getDireccion();
        }
    }
    
    @Override
    public String getColumnName(int col) {
        switch(col){
            case 0: return "ID";
            case 1: return "NOMBRE";
            case 2: return "APELLIDO";
            case 3: return "NUMERO";
            default: return "DIRECCION";
        }
    }
    
    @Override
    public Class getColumnClass(int col) {
        switch(col){
            case 0: return Integer.class;
            case 1: return String.class;
            case 2: return String.class;
            case 3: return Long.class;
            default: return String.class;
        }
    }
    
    @Override
    public boolean isCellEditable(int row, int col) {
        return true;        
    }
  
    @Override
    public void setValueAt(Object value, int fila, int columna) {
        Contacto aux=contactos.obtener(fila);
        switch(columna){
            case 0: aux.setId((String)value);
                    break;
            case 1: aux.setNombre((String)value);
                    break;
            case 2: aux.setApellido((String)value);
                    break;
            case 3: aux.setNumero((Long)value);
                    break;
            default: aux.setDireccion((String)value);
        }
        fireTableCellUpdated(fila, columna);
    }
    
    public void agregarContacto(Contacto producto){
        contactos.agregar(producto);
        this.fireTableDataChanged();   
    }
    
    public void eliminarContacto(int indice){
        contactos.eliminar(indice);
        this.fireTableDataChanged(); 
    }
}

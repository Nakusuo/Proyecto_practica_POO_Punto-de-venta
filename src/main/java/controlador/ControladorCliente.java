package controlador;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ControladorCliente {
    
    public void MostrarClientes(JTable tablaTotalClientes){
        
      configuracion.CConexion objetoCConexion =new configuracion.CConexion();
        
       modelos.ModeloCliente objeCliente=new modelos.ModeloCliente();
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        String sql ="";
        
        modelo.addColumn("id");
        modelo.addColumn("Nombres");
        modelo.addColumn("ApPaterno");
        modelo.addColumn("ApMaterno"); 
    
        tablaTotalClientes.setModel(modelo);
       
        sql = "SELECT cliente.idcliente, cliente.nombres, cliente.ApePaterno, cliente.ApeMaterno FROM cliente;";
        
        try {
            
            Statement st = objetoCConexion.estableceConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {                
                
                objeCliente.setIdCliente(rs.getInt("idcliente"));
                objeCliente.setNombres(rs.getString("nombres"));
                objeCliente.setApePaterno(rs.getString("ApePaterno"));
                objeCliente.setApeMaterno(rs.getString("ApeMaterno"));
                 
                 modelo.addRow(new Object[]{objeCliente.getIdCliente(),objeCliente.getNombres(),objeCliente.getApePaterno(),objeCliente.getApeMaterno()});
            }
            
            tablaTotalClientes.setModel(modelo);
            
        } catch (Exception e) {
            
            JOptionPane.showInputDialog(null,"Error al mostrar usuarios, "+e.toString());
        } finally {
            
            objetoCConexion.CerrarConexion();
        }
        
        }

    public void AgregarCliente(JTextField nombres,JTextField appaterno,JTextField apmaterno ){
        
        
        String consulta ="insert into cliente (nombres,ApePaterno,ApeMaterno ) values(?,?,?);";
        configuracion.CConexion objetCConexion=new configuracion.CConexion();
        modelos.ModeloCliente obCliente = new modelos.ModeloCliente();
        try {
            obCliente.setNombres(nombres.getText());
            obCliente.setApePaterno(appaterno.getText());
            obCliente.setApeMaterno(apmaterno.getText()); 
            
            CallableStatement cs = objetCConexion.estableceConexion().prepareCall(consulta);
            cs.setString(1, obCliente.getNombres());
            cs.setString(2, obCliente.getApePaterno());
            cs.setString(3, obCliente.getApeMaterno());
            
            cs.execute();
          
           JOptionPane.showMessageDialog(null, "Se guardo correctamente");
            
        } catch (Exception e) {
            
             JOptionPane.showMessageDialog(null, "Error al guardar"+e.toString());
        } finally {
            
            objetCConexion.CerrarConexion();
        }
    }
    
    
    public void Seleccion (JTable totalcliente,JTextField id,JTextField Nombre, JTextField appaterno, JTextField apmaterno){
        
        int fila =totalcliente.getSelectedRow();
        try {
            if (fila>=0) {
                
                id.setText(totalcliente.getValueAt(fila, 0).toString());
                Nombre.setText(totalcliente.getValueAt(fila, 1).toString());
                appaterno.setText(totalcliente.getValueAt(fila, 2).toString());
                apmaterno.setText(totalcliente.getValueAt(fila, 3).toString());
            }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "ERROR AL SELECCIONAR:"+e.toString());
        }
    }
    
    public void MoidificaCliente(JTextField id,JTextField nombres,JTextField appaterno,JTextField apmaterno){
        configuracion.CConexion objetCConexion=new configuracion.CConexion();
        modelos.ModeloCliente obCliente = new modelos.ModeloCliente();
        
        String consulta = "UPDATE cliente Set cliente.nombres=?,cliente.ApePaterno=?,cliente.ApeMaterno=? where cliente.idcliente=?; ";
        
     try {
            obCliente.setIdCliente(Integer.parseInt(id.getText()));
            obCliente.setNombres(nombres.getText());
            obCliente.setApePaterno(appaterno.getText());
            obCliente.setApeMaterno(apmaterno.getText());
            
            CallableStatement cs= objetCConexion.estableceConexion().prepareCall(consulta);
            
            cs.setString(1,obCliente.getNombres());
            cs.setString(2,obCliente.getApePaterno());
            cs.setString(3,obCliente.getApeMaterno());
            cs.setInt(4,obCliente.getIdCliente());
          
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "se modifico correctamente");
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "error al  modificar "+e.toString());
            
            
        } finally {
            objetCConexion.CerrarConexion();
        }
    }
    public void limpiarCamposClientes (JTextField id, JTextField Nombre, JTextField appaterno, JTextField apmaterno ) {
          id.setText("");
          Nombre.setText("");
          appaterno.setText("");
          apmaterno.setText("");     
    }
    public void EliminarClientes (JTextField id) {
        configuracion.CConexion objetCConexion=new configuracion.CConexion();
        modelos.ModeloCliente obCliente = new modelos.ModeloCliente();
        
        String consulta = "DELETE FROM cliente WHERE idcliente = ?;";
        
        try {
            obCliente.setIdCliente (Integer.parseInt(id.getText()));
            CallableStatement cs= objetCConexion.estableceConexion().prepareCall(consulta);
            cs.setInt(1,obCliente.getIdCliente());
            cs.execute();
            JOptionPane.showMessageDialog(null, "Se elimino correctamente");
      
        } catch(Exception e) {
            
                   JOptionPane.showMessageDialog(null, "No se elimino correctamente"+ e.toString());  
        }finally{
            objetCConexion.CerrarConexion();
  
        }        
    }
}
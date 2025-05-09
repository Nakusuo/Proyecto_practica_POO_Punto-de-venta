
package controlador;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ControladorProducto {
public void MostrarProductos(JTable tablaTotalProductos){

configuracion.CConexion objetoCConexion =new configuracion.CConexion();

modelos.ModeloProducto objeProducto=new modelos.ModeloProducto();

DefaultTableModel modelo = new DefaultTableModel();

String sql ="";

modelo.addColumn("id");
modelo.addColumn("NombreProd");
modelo.addColumn("Precio");
modelo.addColumn("Stock");


tablaTotalProductos.setModel(modelo);

sql = "select producto.idproducto, producto.nombre, producto.precioProducto, producto.stock from producto;";

try {

Statement st = objetoCConexion.estableceConexion().createStatement();
ResultSet rs = st.executeQuery(sql);

while (rs.next()) {

objeProducto.setIdProducto (rs.getInt("idproducto"));
objeProducto.setNombre (rs.getString("nombre"));
objeProducto.setPrecioProducto (rs.getDouble("precioProducto"));
objeProducto.setStockProducto (rs.getInt("stock"));

modelo.addRow(new Object[]{objeProducto.getIdProducto(),objeProducto.getNombre(),objeProducto.getPrecioProducto(),objeProducto.getStockProducto()});
}

tablaTotalProductos.setModel(modelo);

} catch (Exception e) {

JOptionPane.showInputDialog(null,"Error al mostrar productos, "+e.toString());
} finally {

objetoCConexion.CerrarConexion();
}}


public void AgregarProducto(JTextField nombre,JTextField precioProducto,JTextField stock ){
        
        
        String consulta ="insert into producto (nombre,precioProducto,stock ) values(?,?,?);";
        configuracion.CConexion objetCConexion=new configuracion.CConexion();
        modelos.ModeloProducto objeProducto = new modelos.ModeloProducto();
        try {
            objeProducto.setNombre(nombre.getText());
            objeProducto.setPrecioProducto (Double.parseDouble(precioProducto.getText()));
            objeProducto.setStockProducto(Integer.parseInt(stock.getText())); 
            
            CallableStatement cs = objetCConexion.estableceConexion().prepareCall(consulta);
            cs.setString(1, objeProducto.getNombre());
            cs.setDouble(2, objeProducto.getPrecioProducto());
            cs.setInt(3, objeProducto.getStockProducto());
            
            cs.execute();
            
            
           JOptionPane.showMessageDialog(null, "Se guardo correctamente");
            
        } catch (Exception e) {
            
             JOptionPane.showMessageDialog(null, "Error al guardar"+e.toString());
        } finally {
            
            objetCConexion.CerrarConexion();
        }
    }

public void Seleccion (JTable totalProducto,JTextField id,JTextField Nombre, JTextField precioProducto, JTextField stock){
        
        int fila =totalProducto.getSelectedRow();
        try {
            if (fila>=0) {
                
                id.setText(totalProducto.getValueAt(fila, 0).toString());
                Nombre.setText(totalProducto.getValueAt(fila, 1).toString());
                precioProducto.setText(totalProducto.getValueAt(fila, 2).toString());
                stock.setText(totalProducto.getValueAt(fila, 3).toString());
            }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, "ERROR AL SELECCIONAR:"+e.toString());
        }
    }
public void MoidificaProducto(JTextField id,JTextField nombres,JTextField precioProducto,JTextField stock){
        configuracion.CConexion objetCConexion=new configuracion.CConexion();
        modelos.ModeloProducto obProducto = new modelos.ModeloProducto();
        
        String consulta = "UPDATE producto Set producto.nombre=?,producto.precioProducto=?,producto.stock=? where producto.idproducto=?";
        
        
        try {
            obProducto.setIdProducto(Integer.parseInt(id.getText()));
            obProducto.setNombre(nombres.getText());
           obProducto.setPrecioProducto(Double.parseDouble(precioProducto.getText()));
            obProducto.setStockProducto(Integer.parseInt(stock.getText()));
            
            CallableStatement cs= objetCConexion.estableceConexion().prepareCall(consulta);
            
            cs.setString(1,obProducto.getNombre());
            cs.setDouble(2,obProducto.getPrecioProducto());
            cs.setInt(3,obProducto.getStockProducto());
            cs.setInt(4,obProducto.getIdProducto());
            
            
            cs.execute();
            
            JOptionPane.showMessageDialog(null, "se modifico correctamente");
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "error al  modificar "+e.toString());
            
            
        } finally {
            objetCConexion.CerrarConexion();
        }
    }

    public void limpiarCamposProducto (JTextField id, JTextField Nombre, JTextField precioProducto, JTextField stock ) {
          id.setText("");
          Nombre.setText("");
          precioProducto.setText("");
          stock.setText("");     
    }
    public void EliminarProducto (JTextField id) {
        configuracion.CConexion objetCConexion=new configuracion.CConexion();
        modelos.ModeloProducto obProducto = new modelos.ModeloProducto();
        
        String consulta = "DELETE FROM producto WHERE idproducto = ?;";
        
        try {
            obProducto.setIdProducto (Integer.parseInt(id.getText()));
            CallableStatement cs= objetCConexion.estableceConexion().prepareCall(consulta);
            cs.setInt(1,obProducto.getIdProducto());
            cs.execute();
            JOptionPane.showMessageDialog(null, "Se elimino correctamente");
            
             
        } catch(Exception e) {
            
                   JOptionPane.showMessageDialog(null, "No se elimino correctamente"+ e.toString());  
        }finally{
            objetCConexion.CerrarConexion();           
        }   
    }

}
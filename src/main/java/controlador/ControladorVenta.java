
package controlador;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class ControladorVenta {
    
    public void BuscarProducto (JTextField nombreProducto, JTable tablaproductos){
      configuracion.CConexion objetoCConexion =new configuracion.CConexion();
      modelos.ModeloProducto objeProducto=new modelos.ModeloProducto();
      
        DefaultTableModel modelo = new DefaultTableModel();
                modelo.addColumn("id");
                modelo.addColumn("Nombre");
                modelo.addColumn("preciProducto");
                modelo.addColumn("stock");
                
                tablaproductos.setModel(modelo);
                try{
                    String consulta ="select * from producto where producto.nombre like concat('%',?, '%');";
                    PreparedStatement ps = objetoCConexion.estableceConexion().prepareStatement(consulta);
                    ps.setString(1, nombreProducto.getText());
                    
                    ResultSet rs = ps.executeQuery();
                    
                    while (rs.next()) {
                        objeProducto.setIdProducto (rs.getInt("idproducto"));
                        objeProducto.setNombre (rs.getString("nombre"));
                        objeProducto.setPrecioProducto (rs.getDouble("precioProducto"));
                        objeProducto.setStockProducto (rs.getInt("stock"));
                        
                        modelo.addRow(new Object[]{objeProducto.getIdProducto(),objeProducto.getNombre(),objeProducto.getPrecioProducto(),objeProducto.getStockProducto()});
                    }
                    tablaproductos.setModel(modelo);
                    
                }catch (SQLException e){
                    JOptionPane.showMessageDialog(null,"Error al mostrar" + e.toString());
                }
                finally{
                  objetoCConexion.CerrarConexion();
                }
                for (int column = 0; column < tablaproductos.getColumnCount(); column ++  ){
                    Class <?> columClass = tablaproductos.getColumnClass(column);
                    tablaproductos.setDefaultEditor(columClass, null);
                }
    }
    
    public void SeleccionarProductoVenta (JTable tablaProducto, JTextField id,JTextField nombres,JTextField precioProducto,JTextField stock, JTextField precioFinal){
        int fila = tablaProducto.getSelectedRow();
        try{
            
            if(fila>= 0) {
                id.setText(tablaProducto.getValueAt(fila, 0).toString());
                nombres.setText(tablaProducto.getValueAt(fila, 1).toString());
                precioProducto.setText(tablaProducto.getValueAt(fila, 2).toString());
                stock.setText(tablaProducto.getValueAt(fila, 3).toString());
                precioFinal.setText(tablaProducto.getValueAt(fila, 2).toString());     
        }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error de selección"+ e.toString());
        }
    }
        public void BuscarCliente (JTextField nombreCliente, JTable tablaClientes){
      configuracion.CConexion objetoCConexion =new configuracion.CConexion();
      modelos.ModeloCliente objeCliente =new modelos.ModeloCliente();
      
        DefaultTableModel modelo = new DefaultTableModel();
                modelo.addColumn("id");
                modelo.addColumn("Nombres");
                modelo.addColumn("ApPaterno");
                modelo.addColumn("ApMaterno");
                
                tablaClientes.setModel(modelo);
                try{
                    String consulta ="select * from cliente where cliente.nombres like concat('%',?, '%');";
                    PreparedStatement ps = objetoCConexion.estableceConexion().prepareStatement(consulta);
                    ps.setString(1, nombreCliente.getText());
                    
                    ResultSet rs = ps.executeQuery();
                    
                    while (rs.next()) {
                        objeCliente.setIdCliente(rs.getInt("idcliente"));
                        objeCliente.setNombres(rs.getString("nombres"));
                        objeCliente.setApePaterno(rs.getString("ApePaterno"));
                        objeCliente.setApeMaterno(rs.getString("ApeMaterno"));
                        
                        modelo.addRow(new Object[]{objeCliente.getIdCliente(),objeCliente.getNombres(),objeCliente.getApePaterno(),objeCliente.getApeMaterno()});
                    }
                    tablaClientes.setModel(modelo);
                    
                }catch (SQLException e){
                    JOptionPane.showMessageDialog(null,"Error al mostrar" + e.toString());
                }
                finally{
                  objetoCConexion.CerrarConexion();
                }
                for (int column = 0; column < tablaClientes.getColumnCount(); column ++  ){
                    Class <?> columClass = tablaClientes.getColumnClass(column);
                    tablaClientes.setDefaultEditor(columClass, null);
                }
    }
            public void SeleccionarclienteVenta (JTable tablaClientes, JTextField id, JTextField nombres, JTextField appaterno, JTextField apmaterno ){
        int fila = tablaClientes.getSelectedRow();
        try{
            
            if(fila>= 0) {
                id.setText(tablaClientes.getValueAt(fila, 0).toString());
                nombres.setText(tablaClientes.getValueAt(fila, 1).toString());
                appaterno.setText(tablaClientes.getValueAt(fila, 2).toString());
                apmaterno.setText(tablaClientes.getValueAt(fila, 3).toString());
 
        }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error de selección"+ e.toString());
        }
    }
            public void pasarProductosVenta (JTable tablaResumen, JTextField idproducto, JTextField nombreProducto, JTextField precioProducto, JTextField cantidadVenta, JTextField stock){
             
            DefaultTableModel modelo = (DefaultTableModel) tablaResumen.getModel();
              int stockDisponible = Integer.parseInt(stock.getText());
              String idProducto = idproducto.getText();
                for (int i = 0; i < modelo.getRowCount(); i++) {
                    String idExistente = (String) modelo.getValueAt (i, 0);
                    if (idExistente.equals(idProducto)) {
                        JOptionPane.showMessageDialog(null, "El producto ya esta registrado");
                        return;
    
                    }  
                }
                String nProducto = nombreProducto.getText();
                double precioUnitario = Double.parseDouble(precioProducto.getText());
                int cantidad = Integer.parseInt(cantidadVenta.getText());
                
                if (cantidad > stockDisponible) {
                    JOptionPane.showMessageDialog(null, "la cantidad de venta no puede ser mayor al stock disponible");
                    return;
                }
                double subtotal = precioUnitario*cantidad;
                
                modelo.addRow(new Object[]{idProducto,nProducto,precioUnitario,cantidad,subtotal});
            }
            
            
    public void eliminarProductosSeleccionadosResumentVenta(JTable tablaResumen) {
        try {
            DefaultTableModel modelo = (DefaultTableModel) tablaResumen.getModel();
        
            int indiceSeleccionado = tablaResumen.getSelectedRow();
        
            if (indiceSeleccionado != -1) {
                 modelo.removeRow(indiceSeleccionado);
             } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar");
            }
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al seleccionar: " + e.toString());
    }
}
public void calcularTotalPagar(JTable tablaResumen,JLabel IVA, JLabel totalPagar){
        
        DefaultTableModel modelo = (DefaultTableModel) tablaResumen.getModel();
        
        double totalSubtotal = 0;
        double iva=0.18;
        double totaliva=0;
        
        DecimalFormat formato = new DecimalFormat("#.##");
        
        for (int i = 0; i < modelo.getRowCount(); i++) {
            
            totalSubtotal=   Double.parseDouble(formato.format(totalSubtotal+(double)modelo.getValueAt(i, 4)));
            totaliva = Double.parseDouble(formato.format(iva*totalSubtotal));
        }
        totalPagar.setText(String.valueOf(totalSubtotal));
        IVA.setText(String.valueOf(totaliva));
        
        
        
    }

    public void crearFactura(JTextField codCliente ){
        
       configuracion.CConexion objetoCConexion =new configuracion.CConexion();
        modelos.ModeloCliente objCliente=new modelos.ModeloCliente();
        String consulta="INSERT INTO factura(fechaFactura,fkcliente) values (curdate(),?);";
        
        try {
            objCliente.setIdCliente(Integer.parseInt(codCliente.getText()));
            CallableStatement cs= objetoCConexion.estableceConexion().prepareCall(consulta);
            cs.setInt(1, objCliente.getIdCliente());
            cs.execute();
            
            JOptionPane.showMessageDialog(null,"Factura creada");
            
        } catch (Exception e) {
            
             JOptionPane.showMessageDialog(null,"ERROR al crear Factura"+e.toString());
        } finally {
            objetoCConexion.CerrarConexion();
        }            
    }
    
    public void realizarVenta(JTable tablaResumenVenta){
        
        configuracion.CConexion objetoCConexion =new configuracion.CConexion();
        
        String consultaDetalle ="INSERT INTO detalle (fkfactura, fkproducto, cantidad, precioVenta) VALUES ((SELECT MAX(idfactura) FROM factura), ?, ?, ?);";
        String consultaStock="UPDATE producto SET producto.stock=stock - ? WHERE idproducto=?;";
        
        try {
            
            PreparedStatement psDetalle = objetoCConexion.estableceConexion().prepareStatement(consultaDetalle);
            PreparedStatement psStock = objetoCConexion.estableceConexion().prepareStatement(consultaStock);
            
            int filas = tablaResumenVenta.getRowCount();
            
            for (int i = 0; i < filas; i++) {
                
               int idProducto = Integer.parseInt(tablaResumenVenta.getValueAt(i, 0).toString());
               int cantidad = Integer.parseInt(tablaResumenVenta.getValueAt(i, 3).toString());
               double precioVenta = Double.parseDouble(tablaResumenVenta.getValueAt(i, 2).toString());
     
                psDetalle.setInt(1, idProducto);
                psDetalle.setInt(2, cantidad);
                psDetalle.setDouble(3, precioVenta);
                psDetalle.executeUpdate();
                
                psStock.setInt(1, cantidad);
                psStock.setInt(2, idProducto);
                psDetalle.executeUpdate();
 
            }
            
            JOptionPane.showMessageDialog(null, "Ventta Realizada");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL VENDER: "+e.toString());
        } finally {
            objetoCConexion.CerrarConexion();
        }
    }
           
    
public void limpiarCamposLuegoVenta(
        JTextField buscarCliente, JTable tablaCliente, JTextField buscarProducto, JTable tablaproducto,
        JTextField selectIdCliente, JTextField selectNombreCliente, JTextField selectAppaternosCliente,
        JTextField selectApmaternoCliente, JTextField selectIdProducto, JTextField selectNombreProducto,
        JTextField selectPrecioProducto, JTextField selectStockProducto, JTextField precioVenta,
        JTextField cantidadVenta, JTable tablaresumen, JLabel IVA, JLabel total) {

        buscarCliente.setText("");
        buscarCliente.requestFocus();
        DefaultTableModel modeloCliente = (DefaultTableModel) tablaCliente.getModel();
        modeloCliente.setRowCount(0);
        buscarProducto.setText("");
        DefaultTableModel modeloProdcuto = (DefaultTableModel) tablaCliente.getModel();
        modeloProdcuto.setRowCount(0);
        
        selectIdCliente.setText("");
        selectNombreCliente.setText("");
        selectAppaternosCliente.setText("");
        selectApmaternoCliente.setText("");
        
        selectIdProducto.setText("");
        selectNombreProducto.setText("");
        selectPrecioProducto.setText("");
        selectStockProducto.setText("");
        
        precioVenta.setText("");
        precioVenta.setEnabled(false);
        
        cantidadVenta.setText("");
        
        DefaultTableModel modeloResumenVenta = (DefaultTableModel) tablaresumen.getModel();
        modeloResumenVenta.setRowCount(0);
        
        
        IVA.setText("----");
        total.setText("----");
    }

public void MostrarUltimaFactura(JLabel ultimafactura){
    
    configuracion.CConexion objetoCConexion = new configuracion.CConexion();
    
    try {
        String consulta ="SELECT MAX(idfactura) as UltimaFactura from factura";
        PreparedStatement ps = objetoCConexion.estableceConexion().prepareCall(consulta);
        ResultSet rs= ps.executeQuery();
        
        if (rs.next()) {
            ultimafactura.setText(String.valueOf(rs.getInt("UltimaFactura")));   
        }
  
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR LA ULTIMA FACTURA"+e.toString());
    } finally {
        
        objetoCConexion.CerrarConexion();
        }
    }
}
 
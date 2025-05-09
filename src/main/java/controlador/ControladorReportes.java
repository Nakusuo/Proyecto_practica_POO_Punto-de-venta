
package controlador;

import com.toedter.calendar.JDateChooser;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class ControladorReportes {
    
   public void BuscarFacturaMostrarDatosCliente(JTextField numeroFactura, JLabel numeroFacturaEncontrado, JLabel fechaFacturaEntrado, JLabel nombreCliente, JLabel apPaterno, JLabel apMaterno) {

       configuracion.CConexion objetoCConexion = new configuracion.CConexion();
       
       try {
           String consulta = "SELECT factura.idfactura, factura.fechaFactura, cliente.nombres, cliente.ApePaterno, cliente.ApeMaterno FROM factura INNER JOIN cliente ON cliente.idcliente = factura.fkcliente WHERE factura.idfactura = ?; "; 

           PreparedStatement ps = objetoCConexion.estableceConexion().prepareStatement(consulta);
           ps.setInt(1, Integer.parseInt(numeroFactura.getText()));
           
           ResultSet rs = ps.executeQuery();
           
           if (rs.next()) {
               
               numeroFacturaEncontrado.setText(String.valueOf(rs.getInt("idfactura")));
               fechaFacturaEntrado.setText(rs.getDate("fechaFactura").toString());
               nombreCliente.setText(rs.getString("nombres"));
               apPaterno.setText(rs.getString("ApePaterno"));
               apMaterno.setText(rs.getString("ApeMaterno"));

           }
           
           else
           {  
               numeroFacturaEncontrado.setText("");
               fechaFacturaEntrado.setText("");
               nombreCliente.setText("");
               apPaterno.setText("");
               apMaterno.setText("");
               
               JOptionPane.showMessageDialog(null, "No se encontro la factura");
           }    
           
       } catch (Exception e){
           JOptionPane.showMessageDialog(null, "Error al buscar la factura"+ e.toString());
       }
       finally {
           objetoCConexion.CerrarConexion();
      
       }
   }
   
   public void BuscarFacturaMostrarDatosProductos(JTextField numeroFactura, JTable tablaProductos, JLabel IVA, JLabel total){
   
       configuracion.CConexion objetoCConexion =new configuracion.CConexion();
       DefaultTableModel modelo = new DefaultTableModel();
       
       modelo.addColumn("N.Producto");
       modelo.addColumn("Cantidad");
       modelo.addColumn("PrecioVenta");
       modelo.addColumn("Subtotal");
       
       tablaProductos.setModel(modelo);
       
       try {
           
           String consulta = "SELECT producto.nombre, detalle.cantidad, detalle.precioVenta FROM detalle INNER JOIN factura ON factura.idFactura = detalle.fkfactura INNER JOIN producto ON producto.idproducto = detalle.fkproducto WHERE factura.idfactura = ?;";

                 PreparedStatement ps = objetoCConexion.estableceConexion().prepareStatement(consulta);
                    ps.setInt (1, Integer.parseInt(numeroFactura.getText()));
           
           ResultSet rs = ps.executeQuery();
           
                double totalFactura = 0.0;
                double valorIVA = 0.18;
           
           DecimalFormat formato = new DecimalFormat("#.##");
           
           while (rs.next()) {
               
               String nombreProducto = rs.getString("nombre");
                 int cantidad = rs.getInt("cantidad");
                 double precioVenta = rs.getDouble("precioVenta");
                 double subtotal = cantidad* precioVenta;
               
               totalFactura = Double.parseDouble(formato.format(totalFactura+subtotal));
               
               modelo.addRow(new Object[]{nombreProducto, cantidad, precioVenta, subtotal});          
           }
              double totalIVA = Double.parseDouble(formato.format(totalFactura*valorIVA));
       
             IVA.setText(String.valueOf(totalIVA));
             total.setText(String.valueOf(totalFactura));
           
       
       } catch (Exception e) {
           
            JOptionPane.showMessageDialog(null, "Error al mostrar los productos de la factura: " + e.toString());
       }
       finally {
           
           objetoCConexion.CerrarConexion();
       }

   }   
   
public void mostrarTotalVentaPorFecha(JDateChooser desde, JDateChooser hasta, JTable tablaVentasJTable, JLabel totalGeneral) {

    configuracion.CConexion objetoCConexion = new configuracion.CConexion();

    DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("idFactura");
    modelo.addColumn("FechaFactura");
    modelo.addColumn("Nproducto");
    modelo.addColumn("Cantidad");
    modelo.addColumn("PrecioVenta");
    modelo.addColumn("Subtotal");

    tablaVentasJTable.setModel(modelo);

    try {

        String consulta = "SELECT factura.idFactura, factura.FechaFactura, producto.nombre, detalle.cantidad, detalle.precioVenta, (detalle.cantidad * detalle.precioVenta) AS Subtotal FROM detalle INNER JOIN factura ON factura.idFactura = detalle.fkfactura INNER JOIN producto ON producto.idproducto = detalle.fkproducto WHERE factura.FechaFactura BETWEEN ? AND ?;";

        PreparedStatement ps = objetoCConexion.estableceConexion().prepareStatement(consulta);

        java.util.Date fechaDesde = desde.getDate();
        java.util.Date fechaHasta = hasta.getDate();

        if (fechaDesde == null || fechaHasta == null) {
            JOptionPane.showMessageDialog(null, "Por favor selecciona ambas fechas.");
            return;
        }

        java.sql.Date fechaDesdeSQL = new java.sql.Date(fechaDesde.getTime());
        java.sql.Date fechaHastaSQL = new java.sql.Date(fechaHasta.getTime());

        ps.setDate(1, fechaDesdeSQL);
        ps.setDate(2, fechaHastaSQL);

        ResultSet rs = ps.executeQuery();
        double totalFactura = 0.0;
        DecimalFormat formato = new DecimalFormat("#.##");

        while (rs.next()) {
            int idFactura = rs.getInt("idFactura");
            Date fechaFactura = rs.getDate("fechaFactura");
            String nombreProducto = rs.getString("nombre");
            int cantidad = rs.getInt("cantidad");
            double precioVenta = rs.getDouble("precioVenta");
            double subtotal = cantidad * precioVenta;
            
            totalFactura = Double.parseDouble(formato.format(totalFactura+subtotal));

            modelo.addRow(new Object[]{idFactura, fechaFactura, nombreProducto, cantidad, precioVenta, subtotal});
        }

        totalGeneral.setText(String.valueOf(totalFactura));

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al buscar los ingresos por fechas: " + e.toString());
    } finally {
        objetoCConexion.CerrarConexion();
    }

    for (int column = 0; column < tablaVentasJTable.getColumnCount(); column++) {
        Class<?> columnClass = tablaVentasJTable.getColumnClass(column);
        tablaVentasJTable.setDefaultEditor(columnClass, null);
    }
}
}

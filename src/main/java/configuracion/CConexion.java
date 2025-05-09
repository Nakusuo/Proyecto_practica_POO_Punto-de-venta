
package configuracion;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;

public class CConexion {
    
    Connection conectar = null;
    
    String usuario="root";
    String Contrasenia="root";
    String bd="kofe";
    String ip="localhost";
    String puerto="3306";
    
    String cadena ="jdbc:mysql://"+ip+":"+puerto+"/"+bd;
  
    public Connection estableceConexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            conectar = DriverManager.getConnection(cadena,usuario,Contrasenia);
             //JOptionPane.showMessageDialog(null, "Conexion Correcta a Bd");
        } 
        
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se conecto a la BD"+e.toString());
        }
        return conectar;    
    }
    
    public void CerrarConexion(){
        try {
            if (conectar!=null && !conectar.isClosed()) {
                conectar.close();
                
                //JOptionPane.showMessageDialog(null, "La Conexion fue cerrada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No logro Cerrar la conexion"+e.toString());       
        }  
    }  
}

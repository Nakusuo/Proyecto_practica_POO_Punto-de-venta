
package modelos;

public class ModeloCliente {
int idCliente;

    
    
    String Nombres;
    String apPaterno;
    String apMaterno;
   
    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApePaterno() {
        return apPaterno;
    }

    public void setApePaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApeMaterno() {
        return apMaterno;
    }

    public void setApeMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }
    
    
}

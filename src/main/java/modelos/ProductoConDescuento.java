package modelos;

public class ProductoConDescuento extends ModeloProducto {
    private double descuento;


    public ProductoConDescuento(int idProducto, String nombre, double precioProducto, int stockProducto, double descuento) {
        super.setIdProducto(idProducto);
        super.setNombre(nombre);
        super.setPrecioProducto(precioProducto);
        super.setStockProducto(stockProducto);
        this.descuento = descuento;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double obtenerPrecioConDescuento() {
        return super.getPrecioProducto() - (super.getPrecioProducto() * (descuento / 100));
    }

    public String obtenerMensajeDescuento() {
        return "¡Hoy hay descuento en " + super.getNombre() + "! Precio con descuento: " + obtenerPrecioConDescuento();
    }

    @Override
    public String toString() {
        return "Producto [ID=" + super.getIdProducto() + ", Nombre=" + super.getNombre() + ", Precio con descuento=" + obtenerPrecioConDescuento() + "]";
    }
}

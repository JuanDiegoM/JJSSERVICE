
package modelo;


public class Descuento {
    
    private int idDescuento;
    private String descripcion;
    private int porcentajeDescuento;

    public Descuento() {
    }

    public Descuento(int idDescuento, String descripcion, int porcentajeDescuento) {
        this.idDescuento = idDescuento;
        this.descripcion = descripcion;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public int getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(int idDescuento) {
        this.idDescuento = idDescuento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(int porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public String toString() {
        return "Descuento{" + "idDescuento=" + idDescuento + ", descripcion=" + descripcion + ", porcentajeDescuento=" + porcentajeDescuento + '}';
    }
    
    
    
}

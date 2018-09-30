
package modelo;

public class Reporte {
    
    private String fechaServicio;
    private String tipoServicio;
    private String tipoVehiculo;
    private int cantidadServicios;
    private double costoTotalServicios;
    private float tiempoPromedio;
    private double valorServicio;

    public Reporte() {
    }

    public Reporte(String fechaServicio, String tipoServicio, String tipoVehiculo, int cantidadServicios, double costoTotalServicios, float tiempoPromedio) {
        this.fechaServicio = fechaServicio;
        this.tipoServicio = tipoServicio;
        this.tipoVehiculo = tipoVehiculo;
        this.cantidadServicios = cantidadServicios;
        this.costoTotalServicios = costoTotalServicios;
        this.tiempoPromedio = tiempoPromedio;
    }
    
    public Reporte(String fechaServicio, String tipoServicio, String tipoVehiculo, double valorServicio) {
        this.fechaServicio = fechaServicio;
        this.tipoServicio = tipoServicio;
        this.tipoVehiculo = tipoVehiculo;
        this.valorServicio = valorServicio;
    }

    public double getValorServicio() {
        return valorServicio;
    }

    public void setValorServicio(double valorServicio) {
        this.valorServicio = valorServicio;
    }
    
    

    public String getFechaServicio() {
        return fechaServicio;
    }

    public void setFechaServicio(String fechaServicio) {
        this.fechaServicio = fechaServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public int getCantidadServicios() {
        return cantidadServicios;
    }

    public void setCantidadServicios(int cantidadServicios) {
        this.cantidadServicios = cantidadServicios;
    }

    public double getCostoTotalServicios() {
        return costoTotalServicios;
    }

    public void setCostoTotalServicios(double costoTotalServicios) {
        this.costoTotalServicios = costoTotalServicios;
    }

    public float getTiempoPromedio() {
        return tiempoPromedio;
    }

    public void setTiempoPromedio(float tiempoPromedio) {
        this.tiempoPromedio = tiempoPromedio;
    }
    
    
    
    
    
}

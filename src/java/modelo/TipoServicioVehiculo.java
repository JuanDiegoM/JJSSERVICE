
package modelo;

public class TipoServicioVehiculo {
    
    private int idTipoServicioVehiculo;
    private int idTipoServicio;
    private int idTipoVehiculo;
    private double valorServicio;

    public TipoServicioVehiculo() {
    }

    public TipoServicioVehiculo(int idTipoServicioVehiculo, int idTipoServicio, int idTipoVehiculo, double valorServicio) {
        this.idTipoServicioVehiculo = idTipoServicioVehiculo;
        this.idTipoServicio = idTipoServicio;
        this.idTipoVehiculo = idTipoVehiculo;
        this.valorServicio = valorServicio;
    }

    public int getIdTipoServicioVehiculo() {
        return idTipoServicioVehiculo;
    }

    public void setIdTipoServicioVehiculo(int idTipoServicioVehiculo) {
        this.idTipoServicioVehiculo = idTipoServicioVehiculo;
    }

    public int getIdTipoServicio() {
        return idTipoServicio;
    }

    public void setIdTipoServicio(int idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
    }

    public int getIdTipoVehiculo() {
        return idTipoVehiculo;
    }

    public void setIdTipoVehiculo(int idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }

    public double getValorServicio() {
        return valorServicio;
    }

    public void setValorServicio(double valorServicio) {
        this.valorServicio = valorServicio;
    }

    @Override
    public String toString() {
        return "TipoServicioVehiculo{" + "idTipoServicioVehiculo=" + idTipoServicioVehiculo + ", idTipoServicio=" + idTipoServicio + ", idTipoVehiculo=" + idTipoVehiculo + ", valorServicio=" + valorServicio + '}';
    }
    
    
    
}

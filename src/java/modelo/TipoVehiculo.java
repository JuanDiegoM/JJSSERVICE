
package modelo;

public class TipoVehiculo {
    
    private int idTipoVehiculo;
    String tipoVehiculo;

    public TipoVehiculo() {
    }

    public TipoVehiculo(int idTipoVehiculo, String tipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
        this.tipoVehiculo = tipoVehiculo;
    }

    public int getIdTipoVehiculo() {
        return idTipoVehiculo;
    }

    public void setIdTipoVehiculo(int idTipoVehiculo) {
        this.idTipoVehiculo = idTipoVehiculo;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    @Override
    public String toString() {
        return "TipoVehiculo{" + "idTipoVehiculo=" + idTipoVehiculo + ", tipoVehiculo=" + tipoVehiculo + '}';
    }
    
    
    
}

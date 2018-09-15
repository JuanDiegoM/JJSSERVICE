
package modelo;


public class TipoServicio {
    
    private int idTipoServicio;
    private String tipoServicio;

    public TipoServicio() {
    }

    public TipoServicio(int idTipoServicio, String tipoServicio) {
        this.idTipoServicio = idTipoServicio;
        this.tipoServicio = tipoServicio;
    }

    public int getIdTipoServicio() {
        return idTipoServicio;
    }

    public void setIdTipoServicio(int idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    @Override
    public String toString() {
        return "TipoServicio{" + "idTipoServicio=" + idTipoServicio + ", tipoServicio=" + tipoServicio + '}';
    }
    
    
    
}

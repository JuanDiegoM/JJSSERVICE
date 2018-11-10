
package modelo;


public class TipoUsuario {
    
    private int idTipoUsuario;
    private String tipoUsuario;

    public TipoUsuario() {
    }

    public TipoUsuario(int idTipoUsuario, String tipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
        this.tipoUsuario = tipoUsuario;
    }
    
    public TipoUsuario(int idTipoUsuario){
        this.idTipoUsuario = idTipoUsuario;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return "TipoUsuario{" + "idTipoUsuario=" + idTipoUsuario + ", tipoUsuario=" + tipoUsuario + '}';
    }
    
    
    
}

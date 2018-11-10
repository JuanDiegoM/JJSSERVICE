package modelo;


public class Usuario {

    private int idUsuario;
    private String nombre;
    private String contraseña;
    private int idTipoUsuario;
    private String tipoUsuario;

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public Usuario(int idUsuario, String nombre, int idTipoUsuario, String tipoUsuario) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.idTipoUsuario = idTipoUsuario;
        this.tipoUsuario = tipoUsuario;
    }
    
    public Usuario(String nombre, String contraseña, int idTipoUsuario) {
        
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.idTipoUsuario = idTipoUsuario;
        
    }
    
    public Usuario() {
    }
    
    public Usuario(int idUsuario){
        this.idUsuario = idUsuario;
    }

    public Usuario(int idUsuario, String nombre, String contraseña, int idTipoUsuario) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.idTipoUsuario = idTipoUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(int idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombre=" + nombre + ", contrase\u00f1a=" + contraseña + ", idTipoUsuario=" + idTipoUsuario + ", tipoUsuario=" + tipoUsuario + '}';
    }

    
    
    
    
}

package uml;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Database;
import modelo.Usuario;

public class DaoUsuario extends Database {

    PreparedStatement pst = null;
    ResultSet rs = null;

    public Usuario autenticacionUsuario(String usuario, String contraseña) {

        try {
            String sql = "select * from usuar where nombre = ? and contraseña = ?";
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, usuario);
            pst.setString(2, contraseña);
            rs = pst.executeQuery();

            if (rs.absolute(1)) {
                System.out.println("valido");
                Usuario u = new Usuario(rs.getString(2), rs.getString(3), rs.getInt(4));
                return u;
            }

        } catch (SQLException e) {
            System.err.println("Error" + e);
        } finally {
            try {

                if (getConnection() != null) {
                    getConnection().close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }

            } catch (SQLException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public boolean registrarUsuario(String nombre, String contraseña, int idTipoUsuario) throws SQLException {

        String sql = "insert into usuar(nombre, contraseña, idTipoUsuario) values(?,?,?)";

        pst = getConnection().prepareStatement(sql);
        pst.setString(1, nombre);
        pst.setString(2, contraseña);
        pst.setInt(3, idTipoUsuario);

        if (pst.executeUpdate() == 1) {

            return true;
        }
        try {

        } catch (Exception e) {
            System.err.println("Error" + e);
        } finally {
            try {
                if (getConnection() != null) {
                    getConnection().close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.err.println("Error" + e);
            }
        }
        return false;
    }

    public List<Usuario> obtenerTodosLosUsuarios() throws SQLException {
        List<Usuario> listaUsuario = new LinkedList<>();
        String sql = "select u.idUsuario, u.nombre, tu.idTipoUsuario as idTipoUsuario, tu.tipoUsuario as tipoUsuario  from usuar u inner join tipoUsuario tu on u.idTipoUsuario = tu.idTipoUsuario";
        pst = getConnection().prepareStatement(sql);
        rs = pst.executeQuery();
        while (rs.next()) {
            int idUsuario = rs.getInt("idUsuario");
            String nombre = rs.getString("nombre");
            int idTipoUsuario = rs.getInt("idTipoUsuario");
            String tipoUsuario = rs.getString("tipoUsuario");

            System.out.println(idUsuario + " " + nombre + " " + tipoUsuario);
            Usuario u = new Usuario(idUsuario, nombre, idTipoUsuario, tipoUsuario);
        }
        pst.close();
        return listaUsuario;
    }

    public boolean eliminarUsuario(int idUsuario) throws SQLException {
        String sql = "delete from usuar where idUsuario = ?";
        pst = getConnection().prepareStatement(sql);
        pst.setInt(1, idUsuario);
        if (pst.executeUpdate() == 1) {
            return true;
        }
        try {

        } catch (Exception e) {
            System.err.println("Error" + e);
        } finally {
            try {
                if (getConnection() != null) {
                    getConnection().close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.err.println("Error" + e);
            }
        }
        return false;
    }

    public boolean editarUsuario(int idUsuario, String nombreUsuario, String contraseña, int idTipoUsuario) throws SQLException {

        String sql = "update usuar set nombre=?, contraseña=?, idTipoUsuario=? where idUsuario = ?";        
        
        pst = getConnection().prepareStatement(sql);
        pst.setString(1, nombreUsuario);
        pst.setString(2, contraseña);
        pst.setInt(3, idTipoUsuario);
        pst.setInt(4, idUsuario);
        if (pst.executeUpdate() == 1) {
            return true;
        }
        try {

        } catch (Exception e) {
            System.err.println("Error" + e);
        } finally {
            try {
                if (getConnection() != null) {
                    getConnection().close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.err.println("Error" + e);
            }
        }
        return false;

    }
    
    public boolean editarUsuarioSinPassw(int idUsuario, String nombreUsuario, int idTipoUsuario) throws SQLException {

        String sql = "update usuar set nombre=?, idTipoUsuario=? where idUsuario = ?";        
        
        pst = getConnection().prepareStatement(sql);
        pst.setString(1, nombreUsuario);
        pst.setInt(2, idTipoUsuario);
        pst.setInt(3, idUsuario);
        if (pst.executeUpdate() == 1) {
            return true;
        }
        try {

        } catch (Exception e) {
            System.err.println("Error" + e);
        } finally {
            try {
                if (getConnection() != null) {
                    getConnection().close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.err.println("Error" + e);
            }
        }
        return false;

    }
    

}

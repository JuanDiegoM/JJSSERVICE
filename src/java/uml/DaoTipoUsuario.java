
package uml;

import java.sql.*;
import modelo.Database;

public class DaoTipoUsuario extends Database {
    
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public boolean registrarTipoUsuario(String tipoUsuario) throws SQLException {

        String sql = "insert into tipoUsuario(tipoUsuario) values(?)";

        pst = getConnection().prepareStatement(sql);
        pst.setString(1, tipoUsuario);
        
        if (pst.executeUpdate() == 1) {
            System.out.println("Tipo de usuario guardado");
            return true;
        }else{
            System.out.println("Error al tratar de guardar el tipo de usuario");
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
    
    public boolean eliminarTipoUsuario(int idTipoUsuario) throws SQLException {
        
        String sqlCons = "select * from usuar where idTipoUsuario = ?";
        pst = getConnection().prepareStatement(sqlCons);
        pst.setInt(1, idTipoUsuario);
        rs = pst.executeQuery();
        if (rs.absolute(1)) {
                System.out.println("No se puede eliminar el tipo de usuario por que esta relacionado con usuario");
                return false;
        }else{        
            String sql = "delete from tipoUsuario where idTipoUsuario = ?";
            pst = getConnection().prepareStatement(sql);
            pst.setInt(1, idTipoUsuario);
            if (pst.executeUpdate() == 1) {
                System.out.println("Tipo de usuario eliminado");
                return true;
            }else{
                System.out.println("Error al tratar de eliminar el tipo de usuario");
            }
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
    
    public boolean editarTipoUsuario(int idTipoUsuario, String tipoUsuario) throws SQLException {

        String sql = "update tipoUsuario set tipoUsuario=? where idTipoUsuario = ?";        
        
        pst = getConnection().prepareStatement(sql);
        pst.setString(1, tipoUsuario);
        pst.setInt(2, idTipoUsuario);
        if (pst.executeUpdate() == 1) {
            System.out.println("Tipo de usuario editado");
            return true;
        }else{
            System.out.println("Error al tratar de editar el tipo de usuario");
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

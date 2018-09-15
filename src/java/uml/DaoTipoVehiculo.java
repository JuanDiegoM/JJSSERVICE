
package uml;

import java.sql.*;
import modelo.Database;
import java.sql.SQLException;

public class DaoTipoVehiculo extends Database{
    
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public boolean registrarTipoVehiculo (String tipoVehiculo) throws SQLException {

        String sql = "insert into tipoVehiculo(tipoVehiculo) values(?)";

        pst = getConnection().prepareStatement(sql);
        pst.setString(1, tipoVehiculo);

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
    
    public boolean editarTipoVehiculo(int idTipoVehiculo, String tipoVehiculo) throws SQLException {

        String sql = "update tipoVehiculo set tipoVehiculo=? where idTipoVehiculo = ?";        
        
        pst = getConnection().prepareStatement(sql);
        pst.setString(1, tipoVehiculo);
        pst.setInt(2, idTipoVehiculo);
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
    
    public boolean eliminarTipoVehiculo(int idTipoVehiculo) throws SQLException {
        
        String sqlCons = "select * from tipoServicioVehiculo where idTipoVehiculo = ?";
        pst = getConnection().prepareStatement(sqlCons);
        pst.setInt(1, idTipoVehiculo);
        rs = pst.executeQuery();
        if (rs.absolute(1)) {
                System.out.println("En uso");
                return false;
        }else{        
            String sql = "delete from tipoVehiculo where idTipoVehiculo = ?";
            pst = getConnection().prepareStatement(sql);
            pst.setInt(1, idTipoVehiculo);
            if (pst.executeUpdate() == 1) {
                return true;
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

    
}

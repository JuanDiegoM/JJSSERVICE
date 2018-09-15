package uml;

import java.sql.*;
import modelo.Database;

public class DaoTipoServicio extends Database {

    PreparedStatement pst = null;
    ResultSet rs = null;

    public boolean registrarTiposervicio(String tipoServicio) throws SQLException {

        String sql = "insert into tipoServicio(tipoServicio) values(?)";

        pst = getConnection().prepareStatement(sql);
        pst.setString(1, tipoServicio);

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
    
    public boolean editarTipoServicio(int idTipoServicio, String tipoServicio) throws SQLException {

        String sql = "update tipoServicio set tipoServicio=? where idTipoServicio = ?";        
        
        pst = getConnection().prepareStatement(sql);
        pst.setString(1, tipoServicio);
        pst.setInt(2, idTipoServicio);
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
    
    public boolean eliminarTipoServicio(int idTipoServicio) throws SQLException {
        
        String sqlCons = "select * from tipoServicioVehiculo where idTipoServicio = ?";
        pst = getConnection().prepareStatement(sqlCons);
        pst.setInt(1, idTipoServicio);
        rs = pst.executeQuery();
        if (rs.absolute(1)) {
                System.out.println("En uso");
                return false;
        }else{        
            String sql = "delete from tipoServicio where idTipoServicio = ?";
            pst = getConnection().prepareStatement(sql);
            pst.setInt(1, idTipoServicio);
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

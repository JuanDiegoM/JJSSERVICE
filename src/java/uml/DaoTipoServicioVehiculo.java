package uml;

import java.sql.*;
import modelo.Database;

public class DaoTipoServicioVehiculo extends Database {

    PreparedStatement pst = null;
    ResultSet rs = null;

    public boolean registrarTiposervicioVehiculo(int idTipoServicio, int idTipoVehiculo, double valorServicio) throws SQLException {
        String sql = "insert into tipoServicioVehiculo(idTipoVehiculo, idTipoServicio, valorServicio) values(?,?,?)";

        pst = getConnection().prepareStatement(sql);
        pst.setInt(1, idTipoVehiculo);
        pst.setInt(2, idTipoServicio);
        pst.setDouble(3, valorServicio);

        if (pst.executeUpdate() == 1) {
            System.out.println("Costo de servicio registrado");
            return true;
        }else{
            System.out.println("Error al tratar de guardar el costo de servicio");
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

    public boolean editarTipoServicioVehiculo(int idTipoServicioVehiculo, int idTipoVehiculo, int idTipoServicio, double valorServicio) throws SQLException {
        String sql = "update tipoServicioVehiculo set idTipoVehiculo=?, idTipoServicio=?, valorServicio=? where idTipoServicioVehiculo = ?";

        pst = getConnection().prepareStatement(sql);
        
        pst.setInt(1, idTipoVehiculo);
        pst.setInt(2, idTipoServicio);
        pst.setDouble(3, valorServicio);
        pst.setInt(4, idTipoServicioVehiculo);
        if (pst.executeUpdate() == 1) {
            System.out.println("Costo de servicio editado");
            return true;
        }else{
            System.out.println("Error al tratar de editar el costo de servicio");
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
    
    public boolean eliminarTipoServicioVehiculo(int idTipoServicioVehiculo) throws SQLException {
        String sql = "delete from tipoServicioVehiculo where idTipoServicioVehiculo = ?";
        pst = getConnection().prepareStatement(sql);
        pst.setInt(1, idTipoServicioVehiculo);
        if (pst.executeUpdate() == 1) {
            System.out.println("Costo de servicio eliminado");
            return true;
        }else{
            System.out.println("Error al tratar de eliminar el costo de servicio");
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

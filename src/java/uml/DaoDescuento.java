    
package uml;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Database;

public class DaoDescuento extends Database{
    
    PreparedStatement pst;
    ResultSet rs;
    
    public boolean registrarParametroDescuento(String descripcion, int porcentajeDescuento) throws SQLException {

        String sql = "insert into descuento(descripcion, porcentajeDescuento) values(?,?)";

        pst = getConnection().prepareStatement(sql);
        pst.setString(1, descripcion);
        pst.setInt(2, porcentajeDescuento);

        if (pst.executeUpdate() == 1) {
            System.out.println("Parametro de descuento guardado");
            return true;
        }else{
            System.out.println("Error al tratar de guardar el parametro de descuentp");
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
    
    public boolean editarPorcentajeDescuento(int idParametroDescuento, String descripcion, int porcentajeDescuento) throws SQLException {

        String sql = "update descuento set descripcion=?, porcentajeDescuento=? where iddescuento = ?";        
        
        pst = getConnection().prepareStatement(sql);
        pst.setString(1, descripcion);
        pst.setInt(2, porcentajeDescuento);
        pst.setInt(3, idParametroDescuento);
        if (pst.executeUpdate() == 1) {
            System.out.println("Parametro de descuento editado");
            return true;
        }else{
            System.out.println("Error al tratar de editar el parametro de descuento");
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
    
    public boolean eliminarParametroDescuento(int idParametroDescuento) throws SQLException {
             
            String sql = "delete from descuento where iddescuento = ?";
        pst = getConnection().prepareStatement(sql);
        pst.setInt(1, idParametroDescuento);
        if (pst.executeUpdate() == 1) {
            System.out.println("Parametro de descuento eliminado");
            return true;
        }else{
            System.out.println("Error al tratar de eliminar el parametro de descuento");
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

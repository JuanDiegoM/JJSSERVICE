package uml;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import modelo.Database;

public class DaoServicio extends Database {

    PreparedStatement pst = null;
    ResultSet rs = null;
    PreparedStatement pst2 = null;
    ResultSet rs2 = null;

    public DaoServicio() {
    }

    public boolean registrarServicio(String cedulaCliente, String placaVehiculo, String horaEntrada, String fechaServicio, double subtotal, int porcentajeDescuento, double valorDescuento, double valorTotalServicio, int[] idTipoServicio, double[] valorServicio, int idTipoVehiculo)throws SQLException, ParseException {
        System.out.println("Entro");
        
        /*SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd",Locale.US);
        Date fechaServicio = null;        
        fechaServicio = (Date) formatoFecha.parse(fecha);
        
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss",Locale.US);
        Time horaEntrada = null;        
        horaEntrada = (Time) formatoHora.parse(horaEnt);*/
        
        String horaSalida = "";

        String estado = "proceso";
        String sql = "insert into servicio(cedulaCliente, placaVehiculo, horaEntrada, horaSalida, fechaServicio, subtotal, porcentajeDescuento, valorDescuento, valorTotalServicio, estado, idTipoVehiculo)values(?,?,?,?,?,?,?,?,?,?,?)";

        pst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, cedulaCliente);
        pst.setString(2, placaVehiculo);
        pst.setString(3, horaEntrada);
        pst.setString(4, horaSalida);
        pst.setString(5, fechaServicio);
        pst.setDouble(6, subtotal);
        pst.setInt(7, porcentajeDescuento);
        pst.setDouble(8, valorDescuento);
        pst.setDouble(9, valorTotalServicio);
        pst.setString(10, estado);
        pst.setInt(11, idTipoVehiculo);
        if (pst.executeUpdate() == 1) {
            ResultSet generatedKeys = pst.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idGenerado = generatedKeys.getInt(1);
                System.out.println(idGenerado);
                String sql2 = "insert into detalleServicio(idServicio, idTipoServicio, valorServicio)values(?,?,?)";
                for(int i=0; i<valorServicio.length; i++){
                    pst2 = getConnection().prepareStatement(sql2);
                    pst2.setInt(1, idGenerado);
                    pst2.setInt(2, idTipoServicio[i]);
                    pst2.setDouble(3, valorServicio[i]);
                    if(pst2.executeUpdate() == 1){
                        System.out.println("Detalle servicio guardado");
                    }
                }
            }
            return true;
        } else {
            System.out.println("No gurado");
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

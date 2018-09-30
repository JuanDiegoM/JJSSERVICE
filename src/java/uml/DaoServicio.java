package uml;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import modelo.Database;
import modelo.Servicio;

public class DaoServicio extends Database {

    PreparedStatement pst = null;
    ResultSet rs = null;
    PreparedStatement pst2 = null;
    ResultSet rs2 = null;

    public DaoServicio() {
    }

    public boolean registrarServicio(String cedulaCliente, String placaVehiculo, double subtotal, int porcentajeDescuento, double valorDescuento, double valorTotalServicio, int[] idTipoServicio, double[] valorServicio, int idTipoVehiculo) throws SQLException, ParseException {
        String estado = "proceso";
        String sql = "insert into servicio(cedulaCliente, placaVehiculo, subtotal, porcentajeDescuento, valorDescuento, valorTotalServicio, estado, idTipoVehiculo)values(?,?,?,?,?,?,?,?)";

        pst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, cedulaCliente);
        pst.setString(2, placaVehiculo);
        pst.setDouble(3, subtotal);
        pst.setInt(4, porcentajeDescuento);
        pst.setDouble(5, valorDescuento);
        pst.setDouble(6, valorTotalServicio);
        pst.setString(7, estado);
        pst.setInt(8, idTipoVehiculo);
        if (pst.executeUpdate() == 1) {
            ResultSet generatedKeys = pst.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idGenerado = generatedKeys.getInt(1);

                String sql2 = "insert into detalleServicio(idServicio, idTipoServicio, valorServicio)values(?,?,?)";
                for (int i = 0; i < valorServicio.length; i++) {
                    pst2 = getConnection().prepareStatement(sql2);
                    pst2.setInt(1, idGenerado);
                    pst2.setInt(2, idTipoServicio[i]);
                    pst2.setDouble(3, valorServicio[i]);
                    if (pst2.executeUpdate() == 1) {
                        System.out.println("true");
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

    public boolean finalizarServicio(int idServicio) throws SQLException {
        String sql = "update servicio set horaSalida=CURRENT_TIMESTAMP, estado='terminado' where idServicio = " + idServicio + "";
        pst = getConnection().prepareStatement(sql);

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

    public List<Servicio> liquidarServicio(int idServicio) throws SQLException {
        List<Servicio> listaServicio = new LinkedList<>();

        String sql = "SELECT DATE(fechaServicio) fechaServicio, cedulaCliente, placaVehiculo, TIME(horaEntrada) horaEntrada, TIME(horaSalida) horaSalida, TIMEDIFF(TIME(horaSalida), TIME(horaEntrada)) as tiempoDiferencia, subtotal, porcentajeDescuento, valorDescuento, valorTotalServicio from servicio where idServicio = " + idServicio + "";
        pst = getConnection().prepareStatement(sql);
        rs = pst.executeQuery();
        //int i = 0;
        while (rs.next()) {
            Date fechaServicio = rs.getDate("fechaServicio");
            String cedulaCliente = rs.getString("cedulaCliente");
            String placaVehiculo = rs.getString("placaVehiculo");
            Time horaLlegada = rs.getTime("horaEntrada");
            Time horaSalida = rs.getTime("horaSalida");
            String tiempoDiferencia = rs.getTime("tiempoDiferencia").toString();
            double subtotal = rs.getDouble("subtotal");
            int porcentajeDescuento = rs.getInt("porcentajeDescuento");
            double valorDescuento = rs.getDouble("valorDescuento");
            double valorTotalServicio = rs.getDouble("valorTotalServicio");

            Servicio se = new Servicio(fechaServicio, horaLlegada, cedulaCliente, placaVehiculo, horaSalida, porcentajeDescuento, valorDescuento, subtotal, valorTotalServicio, tiempoDiferencia);
            listaServicio.add(se);
            //System.out.println(listaServicio);
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
        return listaServicio;
    }

    public static void main(String[] args) throws SQLException {

        DaoServicio d = new DaoServicio();
        List<Servicio> lstServicio = d.liquidarServicio(27);
        for (Servicio lstServ : lstServicio) {
            System.out.println(lstServ.getFechaServicio());
            System.out.println(lstServ.getCedulaCliente());
            System.out.println(lstServ.getPlacaVehiculo());
            System.out.println(lstServ.getHoraLlegada());
            System.out.println(lstServ.getHoraSalida());
            System.out.println(lstServ.getTiempoDuracion());
            System.out.println(lstServ.getSubtotal());
            System.out.println(lstServ.getPorcentajeDescuento());
            System.out.println(lstServ.getValorDescuento());
            System.out.println(lstServ.getValorTotalServicio());
            
        }
        

    }
}

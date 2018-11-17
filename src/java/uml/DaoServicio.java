package uml;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
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
                        System.out.println("detalle servicio registrado");
                    }else{
                        System.out.println("Error al tratar de registrar el detalle de servicio");
                    }
                }
            }
            System.out.println("Servicio registrado correctamente");
            return true;
        } else {
            System.out.println("Error al tratar de registrar el servicio");
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
            System.out.println("Servicio finalizado correctamente");
            return true;
        }else{
            System.out.println("Error al tratar de finalizar el servicio");
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
    
    public boolean eliminarServicio(int idServicio) throws SQLException {
             
            String sql = "delete from servicio where idServicio = ?";
        pst = getConnection().prepareStatement(sql);
        pst.setInt(1, idServicio);
        if (pst.executeUpdate() == 1) {
            System.out.println("Servicio eliminado correctamente");
            return true;
        }else{
            System.out.println("Error al tratar de eliminar el servicio");
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
        String tiempoServicio = null;
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
            tiempoServicio = rs.getTime("tiempoDiferencia").toString();
            Servicio se = new Servicio(fechaServicio, horaLlegada, cedulaCliente, placaVehiculo, horaSalida, porcentajeDescuento, valorDescuento, subtotal, valorTotalServicio, tiempoDiferencia);
            listaServicio.add(se);
        }
        try {
            registrarTiempoDiferencia(tiempoServicio, idServicio);
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
            } catch (SQLException e) {
                System.err.println("Error" + e);
            }
        }
        return listaServicio;
    }

    public static void main(String[] args) throws SQLException {
        Database db = new Database();
        /*DaoServicio d = new DaoServicio();
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

        }*/
        PreparedStatement pst = null;
        ResultSet rs = null;
        //String sql = "select count(idServicio) as cantidad, sum(tiempoServicio) as tiempo from servicio";
        
        String sql = "SELECT sec_to_time(avg(time_to_sec(tiempoServicio))) tiempo FROM servicio";
        String sqlWhere = " where idServicio = 84";
        
        pst = db.getConnection().prepareStatement(sql+sqlWhere);
        rs = pst.executeQuery();
        //int i = 0;
        while (rs.next()) {
            
            String tiempo = rs.getString("tiempo");
            
            System.out.println(tiempo);
        }

    }

    private void registrarTiempoDiferencia(String tiempoServicio, int idServicio) throws SQLException {

        try {

            SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");

            java.util.Date d1 = (java.util.Date) format.parse(tiempoServicio);

            java.sql.Time ppstime = new java.sql.Time(d1.getTime());

            System.out.println(ppstime);

            String sql = "update servicio set tiempoServicio = ? where idServicio = ? ";

            pst = getConnection().prepareStatement(sql);
            pst.setTime(1, ppstime);
            pst.setInt(2, idServicio);
            if (pst.executeUpdate() == 1) {
                System.out.println("Guarda");
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

        } catch (ParseException e) {

        }
    }
}

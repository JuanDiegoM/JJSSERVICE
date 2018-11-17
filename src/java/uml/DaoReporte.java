package uml;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import modelo.Database;
import modelo.Reporte;
import java.util.Date;

public class DaoReporte extends Database {

    PreparedStatement pst = null;
    ResultSet rs = null;

    public List<Reporte> generarReporte(int idTipoVehiculo, int idTipoServicio, String fechaInicio, String fechaFin) throws SQLException, ParseException {

        List<Reporte> listaReporte = new LinkedList<>();
        String sql = "";

        if (idTipoVehiculo == 0 && idTipoServicio == 0 && "".equals(fechaInicio) && "".equals(fechaFin)) {
            sql = "SELECT DATE(se.fechaServicio) fechaServicio, ts.tipoServicio as tipoServicio,"
                    + " tv.tipoVehiculo as tipoVehiculo, ds.valorServicio as valorServicio, se.tiempoServicio as tiempoServicio"
                    + " FROM detalleservicio ds  LEFT JOIN servicio se ON ds.idServicio = se.idServicio"
                    + " LEFT JOIN tiposervicio ts on ds.idTipoServicio = ts.idTipoServicio"
                    + " LEFT JOIN tipovehiculo tv ON se.idTipoVehiculo = tv.idTipoVehiculo";

        }

        if (idTipoVehiculo != 0 && idTipoServicio == 0 && "".equals(fechaInicio) && "".equals(fechaFin)) {
            sql = "SELECT DATE(se.fechaServicio) fechaServicio, ts.tipoServicio as tipoServicio,"
                    + " tv.tipoVehiculo as tipoVehiculo, ds.valorServicio as valorServicio, se.tiempoServicio as tiempoServicio"
                    + " FROM detalleservicio ds  LEFT JOIN servicio se ON ds.idServicio = se.idServicio"
                    + " LEFT JOIN tiposervicio ts on ds.idTipoServicio = ts.idTipoServicio"
                    + " LEFT JOIN tipovehiculo tv ON se.idTipoVehiculo = tv.idTipoVehiculo"
                    + " where se.idTipoVehiculo = " + idTipoVehiculo + "";

        }
        if (idTipoVehiculo == 0 && idTipoServicio != 0 && "".equals(fechaInicio) && "".equals(fechaFin)) {
            sql = "SELECT DATE(se.fechaServicio) fechaServicio, ts.tipoServicio as tipoServicio,"
                    + " tv.tipoVehiculo as tipoVehiculo, ds.valorServicio as valorServicio, se.tiempoServicio as tiempoServicio"
                    + " FROM detalleservicio ds  LEFT JOIN servicio se ON ds.idServicio = se.idServicio"
                    + " LEFT JOIN tiposervicio ts on ds.idTipoServicio = ts.idTipoServicio"
                    + " LEFT JOIN tipovehiculo tv ON se.idTipoVehiculo = tv.idTipoVehiculo"
                    + " where ds.idTipoServicio = " + idTipoServicio + "";

        }
        if (idTipoVehiculo != 0 && idTipoServicio != 0 && "".equals(fechaInicio) && "".equals(fechaFin)) {
            sql = "SELECT DATE(se.fechaServicio) fechaServicio, ts.tipoServicio as tipoServicio,"
                    + " tv.tipoVehiculo as tipoVehiculo, ds.valorServicio as valorServicio, se.tiempoServicio as tiempoServicio"
                    + " FROM detalleservicio ds  LEFT JOIN servicio se ON ds.idServicio = se.idServicio"
                    + " LEFT JOIN tiposervicio ts on ds.idTipoServicio = ts.idTipoServicio"
                    + " LEFT JOIN tipovehiculo tv ON se.idTipoVehiculo = tv.idTipoVehiculo"
                    + " where se.idTipoVehiculo = " + idTipoVehiculo + " and ds.idTipoServicio = " + idTipoServicio + "";

        }
        if (idTipoServicio == 0 && idTipoVehiculo == 0 && "".equals(fechaFin) && !"".equals(fechaInicio)) {
            Date fechaIni = convertStringToDate(fechaInicio);

            sql = "SELECT DATE(se.fechaServicio) fechaServicio, ts.tipoServicio as tipoServicio,"
                    + " tv.tipoVehiculo as tipoVehiculo, ds.valorServicio as valorServicio, se.tiempoServicio as tiempoServicio"
                    + " FROM detalleservicio ds  LEFT JOIN servicio se ON ds.idServicio = se.idServicio"
                    + " LEFT JOIN tiposervicio ts on ds.idTipoServicio = ts.idTipoServicio"
                    + " LEFT JOIN tipovehiculo tv ON se.idTipoVehiculo = tv.idTipoVehiculo"
                    + " where DATE( se.fechaServicio) >= " + "'" + fechaIni + "'";
        }

        if (idTipoServicio == 0 && idTipoVehiculo == 0 && !"".equals(fechaFin) && "".equals(fechaInicio)) {
            Date fechaF = convertStringToDate(fechaFin);

            sql = "SELECT DATE(se.fechaServicio) fechaServicio, ts.tipoServicio as tipoServicio,"
                    + " tv.tipoVehiculo as tipoVehiculo, ds.valorServicio as valorServicio, se.tiempoServicio as tiempoServicio"
                    + " FROM detalleservicio ds  LEFT JOIN servicio se ON ds.idServicio = se.idServicio"
                    + " LEFT JOIN tiposervicio ts on ds.idTipoServicio = ts.idTipoServicio"
                    + " LEFT JOIN tipovehiculo tv ON se.idTipoVehiculo = tv.idTipoVehiculo"
                    + " where DATE( se.fechaServicio) <= " + "'" + fechaF + "'";

        }

        if (idTipoServicio == 0 && idTipoVehiculo == 0 && !"".equals(fechaFin) && !"".equals(fechaInicio)) {
            Date fechaIni = convertStringToDate(fechaInicio);
            Date fechaF = convertStringToDate(fechaFin);

            sql = "SELECT DATE(se.fechaServicio) fechaServicio, ts.tipoServicio as tipoServicio,"
                    + " tv.tipoVehiculo as tipoVehiculo, ds.valorServicio as valorServicio, se.tiempoServicio as tiempoServicio"
                    + " FROM detalleservicio ds  LEFT JOIN servicio se ON ds.idServicio = se.idServicio"
                    + " LEFT JOIN tiposervicio ts on ds.idTipoServicio = ts.idTipoServicio"
                    + " LEFT JOIN tipovehiculo tv ON se.idTipoVehiculo = tv.idTipoVehiculo"
                    + " where DATE(se.fechaServicio) >= " + "'" + fechaIni + "' and DATE(se.fechaServicio) <= " + "'" + fechaF + "'";

        }

        if (idTipoServicio == 0 && idTipoVehiculo != 0 && !"".equals(fechaFin) && !"".equals(fechaInicio)) {
            Date fechaIni = convertStringToDate(fechaInicio);
            Date fechaF = convertStringToDate(fechaFin);

            sql = "SELECT DATE(se.fechaServicio) fechaServicio, ts.tipoServicio as tipoServicio,"
                    + " tv.tipoVehiculo as tipoVehiculo, ds.valorServicio as valorServicio, se.tiempoServicio as tiempoServicio"
                    + " FROM detalleservicio ds  LEFT JOIN servicio se ON ds.idServicio = se.idServicio"
                    + " LEFT JOIN tiposervicio ts on ds.idTipoServicio = ts.idTipoServicio"
                    + " LEFT JOIN tipovehiculo tv ON se.idTipoVehiculo = tv.idTipoVehiculo"
                    + " where se.idTipoVehiculo = " + idTipoVehiculo + " and DATE(se.fechaServicio) >= " + "'" + fechaIni + "' and DATE(se.fechaServicio) <= " + "'" + fechaF + "'";

        }

        if (idTipoServicio != 0 && idTipoVehiculo == 0 && !"".equals(fechaFin) && !"".equals(fechaInicio)) {
            Date fechaIni = convertStringToDate(fechaInicio);
            Date fechaF = convertStringToDate(fechaFin);

            sql = "SELECT DATE(se.fechaServicio) fechaServicio, ts.tipoServicio as tipoServicio,"
                    + " tv.tipoVehiculo as tipoVehiculo, ds.valorServicio as valorServicio, se.tiempoServicio as tiempoServicio"
                    + " FROM detalleservicio ds  LEFT JOIN servicio se ON ds.idServicio = se.idServicio"
                    + " LEFT JOIN tiposervicio ts on ds.idTipoServicio = ts.idTipoServicio"
                    + " LEFT JOIN tipovehiculo tv ON se.idTipoVehiculo = tv.idTipoVehiculo"
                    + " where ds.idTipoServicio = " + idTipoServicio + " and DATE(se.fechaServicio) >= " + "'" + fechaIni + "' and DATE(se.fechaServicio) <= " + "'" + fechaF + "'";

        }

        if (idTipoServicio != 0 && idTipoVehiculo != 0 && !"".equals(fechaFin) && !"".equals(fechaInicio)) {
            Date fechaIni = convertStringToDate(fechaInicio);
            Date fechaF = convertStringToDate(fechaFin);

            sql = "SELECT DATE(se.fechaServicio) fechaServicio, ts.tipoServicio as tipoServicio,"
                    + " tv.tipoVehiculo as tipoVehiculo, ds.valorServicio as valorServicio, se.tiempoServicio as tiempoServicio"
                    + " FROM detalleservicio ds  LEFT JOIN servicio se ON ds.idServicio = se.idServicio"
                    + " LEFT JOIN tiposervicio ts on ds.idTipoServicio = ts.idTipoServicio"
                    + " LEFT JOIN tipovehiculo tv ON se.idTipoVehiculo = tv.idTipoVehiculo"
                    + " where se.idTipoVehiculo = " + idTipoVehiculo + " and ds.idTipoServicio = " + idTipoServicio + " and DATE(se.fechaServicio) >= " + "'" + fechaIni + "' and DATE(se.fechaServicio) <= " + "'" + fechaF + "'";

        }

        if (idTipoServicio != 0 && idTipoVehiculo != 0 && "".equals(fechaFin) && !"".equals(fechaInicio)) {
            Date fechaIni = convertStringToDate(fechaInicio);

            sql = "SELECT DATE(se.fechaServicio) fechaServicio, ts.tipoServicio as tipoServicio,"
                    + " tv.tipoVehiculo as tipoVehiculo, ds.valorServicio as valorServicio, se.tiempoServicio as tiempoServicio"
                    + " FROM detalleservicio ds  LEFT JOIN servicio se ON ds.idServicio = se.idServicio"
                    + " LEFT JOIN tiposervicio ts on ds.idTipoServicio = ts.idTipoServicio"
                    + " LEFT JOIN tipovehiculo tv ON se.idTipoVehiculo = tv.idTipoVehiculo"
                    + " where se.idTipoVehiculo = " + idTipoVehiculo + " and ds.idTipoServicio = " + idTipoServicio + " and DATE(se.fechaServicio) >= " + "'" + fechaIni + "'";

        }

        if (idTipoServicio != 0 && idTipoVehiculo != 0 && !"".equals(fechaFin) && "".equals(fechaInicio)) {
            Date fechaF = convertStringToDate(fechaFin);

            sql = "SELECT DATE(se.fechaServicio) fechaServicio, ts.tipoServicio as tipoServicio,"
                    + " tv.tipoVehiculo as tipoVehiculo, ds.valorServicio as valorServicio, se.tiempoServicio as tiempoServicio"
                    + " FROM detalleservicio ds  LEFT JOIN servicio se ON ds.idServicio = se.idServicio"
                    + " LEFT JOIN tiposervicio ts on ds.idTipoServicio = ts.idTipoServicio"
                    + " LEFT JOIN tipovehiculo tv ON se.idTipoVehiculo = tv.idTipoVehiculo"
                    + " where se.idTipoVehiculo = " + idTipoVehiculo + " and ds.idTipoServicio = " + idTipoServicio + " and DATE(se.fechaServicio) <= " + "'" + fechaF + "'";

        }

        if (idTipoServicio != 0 && idTipoVehiculo == 0 && "".equals(fechaFin) && !"".equals(fechaInicio)) {
            Date fechaIni = convertStringToDate(fechaInicio);

            sql = "SELECT DATE(se.fechaServicio) fechaServicio, ts.tipoServicio as tipoServicio,"
                    + " tv.tipoVehiculo as tipoVehiculo, ds.valorServicio as valorServicio, se.tiempoServicio as tiempoServicio"
                    + " FROM detalleservicio ds  LEFT JOIN servicio se ON ds.idServicio = se.idServicio"
                    + " LEFT JOIN tiposervicio ts on ds.idTipoServicio = ts.idTipoServicio"
                    + " LEFT JOIN tipovehiculo tv ON se.idTipoVehiculo = tv.idTipoVehiculo"
                    + " where ds.idTipoServicio = " + idTipoServicio + " and DATE( se.fechaServicio) >= " + "'" + fechaIni + "'";

        }

        if (idTipoServicio == 0 && idTipoVehiculo != 0 && "".equals(fechaFin) && !"".equals(fechaInicio)) {
            Date fechaIni = convertStringToDate(fechaInicio);

            sql = "SELECT DATE(se.fechaServicio) fechaServicio, ts.tipoServicio as tipoServicio,"
                    + " tv.tipoVehiculo as tipoVehiculo, ds.valorServicio as valorServicio, se.tiempoServicio as tiempoServicio"
                    + " FROM detalleservicio ds  LEFT JOIN servicio se ON ds.idServicio = se.idServicio"
                    + " LEFT JOIN tiposervicio ts on ds.idTipoServicio = ts.idTipoServicio"
                    + " LEFT JOIN tipovehiculo tv ON se.idTipoVehiculo = tv.idTipoVehiculo"
                    + " where se.idTipoVehiculo = " + idTipoVehiculo + " and DATE(se.fechaServicio) >= " + "'" + fechaIni + "'";

        }

        if (idTipoServicio != 0 && idTipoVehiculo == 0 && !"".equals(fechaFin) && "".equals(fechaInicio)) {
            Date fechaF = convertStringToDate(fechaFin);

            sql = "SELECT DATE(se.fechaServicio) fechaServicio, ts.tipoServicio as tipoServicio,"
                    + " tv.tipoVehiculo as tipoVehiculo, ds.valorServicio as valorServicio, se.tiempoServicio as tiempoServicio"
                    + " FROM detalleservicio ds  LEFT JOIN servicio se ON ds.idServicio = se.idServicio"
                    + " LEFT JOIN tiposervicio ts on ds.idTipoServicio = ts.idTipoServicio"
                    + " LEFT JOIN tipovehiculo tv ON se.idTipoVehiculo = tv.idTipoVehiculo"
                    + " where ds.idTipoServicio = " + idTipoServicio + " and DATE(se.fechaServicio) <= " + "'" + fechaF + "'";

        }

        if (idTipoServicio == 0 && idTipoVehiculo != 0 && !"".equals(fechaFin) && "".equals(fechaInicio)) {
            Date fechaF = convertStringToDate(fechaFin);

            sql = "SELECT DATE(se.fechaServicio) fechaServicio, ts.tipoServicio as tipoServicio,"
                    + " tv.tipoVehiculo as tipoVehiculo, ds.valorServicio as valorServicio, se.tiempoServicio as tiempoServicio"
                    + " FROM detalleservicio ds  LEFT JOIN servicio se ON ds.idServicio = se.idServicio"
                    + " LEFT JOIN tiposervicio ts on ds.idTipoServicio = ts.idTipoServicio"
                    + " LEFT JOIN tipovehiculo tv ON se.idTipoVehiculo = tv.idTipoVehiculo"
                    + " where se.idTipoVehiculo = " + idTipoVehiculo + " and DATE(se.fechaServicio) <= " + "'" + fechaF + "'";

        }

        double costoTotalServicios = 0;
        pst = getConnection().prepareStatement(sql);
        rs = pst.executeQuery();
        while (rs.next()) {
            String fechaServicio = rs.getString("fechaServicio");
            String tipoServicio = rs.getString("tipoServicio");
            String tipoVehiculo = rs.getString("tipoVehiculo");
            double valorServicio = rs.getDouble("valorServicio");
            String tiempoServicio = rs.getString("tiempoServicio");
            System.out.println(tiempoServicio);
            Reporte re = new Reporte(fechaServicio, tipoServicio, tipoVehiculo, valorServicio, tiempoServicio);
            listaReporte.add(re);
        }

        return listaReporte;
    }

    public String extraerConsulta(int idTipoVehiculo, int idTipoServicio, String fechaInicio, String fechaFin) throws ParseException {

        String sql = "";
        if (idTipoVehiculo == 0 && idTipoServicio == 0 && "".equals(fechaInicio) && "".equals(fechaFin)) {
            sql = "SELECT DATE(se.fechaServicio) fechaServicio, ts.tipoServicio as tipoServicio,"
                    + " tv.tipoVehiculo as tipoVehiculo, ds.valorServicio as valorServicio, se.tiempoServicio as tiempoServicio"
                    + " FROM detalleservicio ds  LEFT JOIN servicio se ON ds.idServicio = se.idServicio"
                    + " LEFT JOIN tiposervicio ts on ds.idTipoServicio = ts.idTipoServicio"
                    + " LEFT JOIN tipovehiculo tv ON se.idTipoVehiculo = tv.idTipoVehiculo";

        }

        if (idTipoVehiculo != 0 && idTipoServicio == 0 && "".equals(fechaInicio) && "".equals(fechaFin)) {
            sql = "SELECT DATE(se.fechaServicio) fechaServicio, ts.tipoServicio as tipoServicio,"
                    + " tv.tipoVehiculo as tipoVehiculo, ds.valorServicio as valorServicio, se.tiempoServicio as tiempoServicio"
                    + " FROM detalleservicio ds  LEFT JOIN servicio se ON ds.idServicio = se.idServicio"
                    + " LEFT JOIN tiposervicio ts on ds.idTipoServicio = ts.idTipoServicio"
                    + " LEFT JOIN tipovehiculo tv ON se.idTipoVehiculo = tv.idTipoVehiculo"
                    + " where se.idTipoVehiculo = " + idTipoVehiculo + "";

        }
        if (idTipoVehiculo == 0 && idTipoServicio != 0 && "".equals(fechaInicio) && "".equals(fechaFin)) {
            sql = "SELECT DATE(se.fechaServicio) fechaServicio, ts.tipoServicio as tipoServicio,"
                    + " tv.tipoVehiculo as tipoVehiculo, ds.valorServicio as valorServicio, se.tiempoServicio as tiempoServicio"
                    + " FROM detalleservicio ds  LEFT JOIN servicio se ON ds.idServicio = se.idServicio"
                    + " LEFT JOIN tiposervicio ts on ds.idTipoServicio = ts.idTipoServicio"
                    + " LEFT JOIN tipovehiculo tv ON se.idTipoVehiculo = tv.idTipoVehiculo"
                    + " where ds.idTipoServicio = " + idTipoServicio + "";

        }
        if (idTipoVehiculo != 0 && idTipoServicio != 0 && "".equals(fechaInicio) && "".equals(fechaFin)) {
            sql = "SELECT DATE(se.fechaServicio) fechaServicio, ts.tipoServicio as tipoServicio,"
                    + " tv.tipoVehiculo as tipoVehiculo, ds.valorServicio as valorServicio, se.tiempoServicio as tiempoServicio"
                    + " FROM detalleservicio ds  LEFT JOIN servicio se ON ds.idServicio = se.idServicio"
                    + " LEFT JOIN tiposervicio ts on ds.idTipoServicio = ts.idTipoServicio"
                    + " LEFT JOIN tipovehiculo tv ON se.idTipoVehiculo = tv.idTipoVehiculo"
                    + " where se.idTipoVehiculo = " + idTipoVehiculo + " and ds.idTipoServicio = " + idTipoServicio + "";

        }
        if (idTipoServicio == 0 && idTipoVehiculo == 0 && "".equals(fechaFin) && !"".equals(fechaInicio)) {
            Date fechaIni = convertStringToDate(fechaInicio);

            sql = "SELECT DATE(se.fechaServicio) fechaServicio, ts.tipoServicio as tipoServicio,"
                    + " tv.tipoVehiculo as tipoVehiculo, ds.valorServicio as valorServicio, se.tiempoServicio as tiempoServicio"
                    + " FROM detalleservicio ds  LEFT JOIN servicio se ON ds.idServicio = se.idServicio"
                    + " LEFT JOIN tiposervicio ts on ds.idTipoServicio = ts.idTipoServicio"
                    + " LEFT JOIN tipovehiculo tv ON se.idTipoVehiculo = tv.idTipoVehiculo"
                    + " where DATE( se.fechaServicio) >= " + "'" + fechaIni + "'";
        }

        if (idTipoServicio == 0 && idTipoVehiculo == 0 && !"".equals(fechaFin) && "".equals(fechaInicio)) {
            Date fechaF = convertStringToDate(fechaFin);

            sql = "SELECT DATE(se.fechaServicio) fechaServicio, ts.tipoServicio as tipoServicio,"
                    + " tv.tipoVehiculo as tipoVehiculo, ds.valorServicio as valorServicio, se.tiempoServicio as tiempoServicio"
                    + " FROM detalleservicio ds  LEFT JOIN servicio se ON ds.idServicio = se.idServicio"
                    + " LEFT JOIN tiposervicio ts on ds.idTipoServicio = ts.idTipoServicio"
                    + " LEFT JOIN tipovehiculo tv ON se.idTipoVehiculo = tv.idTipoVehiculo"
                    + " where DATE( se.fechaServicio) <= " + "'" + fechaF + "'";

        }

        if (idTipoServicio == 0 && idTipoVehiculo == 0 && !"".equals(fechaFin) && !"".equals(fechaInicio)) {
            Date fechaIni = convertStringToDate(fechaInicio);
            Date fechaF = convertStringToDate(fechaFin);

            sql = "SELECT DATE(se.fechaServicio) fechaServicio, ts.tipoServicio as tipoServicio,"
                    + " tv.tipoVehiculo as tipoVehiculo, ds.valorServicio as valorServicio, se.tiempoServicio as tiempoServicio"
                    + " FROM detalleservicio ds  LEFT JOIN servicio se ON ds.idServicio = se.idServicio"
                    + " LEFT JOIN tiposervicio ts on ds.idTipoServicio = ts.idTipoServicio"
                    + " LEFT JOIN tipovehiculo tv ON se.idTipoVehiculo = tv.idTipoVehiculo"
                    + " where DATE(se.fechaServicio) >= " + "'" + fechaIni + "' and DATE(se.fechaServicio) <= " + "'" + fechaF + "'";

        }

        if (idTipoServicio == 0 && idTipoVehiculo != 0 && !"".equals(fechaFin) && !"".equals(fechaInicio)) {
            Date fechaIni = convertStringToDate(fechaInicio);
            Date fechaF = convertStringToDate(fechaFin);

            sql = "SELECT DATE(se.fechaServicio) fechaServicio, ts.tipoServicio as tipoServicio,"
                    + " tv.tipoVehiculo as tipoVehiculo, ds.valorServicio as valorServicio, se.tiempoServicio as tiempoServicio"
                    + " FROM detalleservicio ds  LEFT JOIN servicio se ON ds.idServicio = se.idServicio"
                    + " LEFT JOIN tiposervicio ts on ds.idTipoServicio = ts.idTipoServicio"
                    + " LEFT JOIN tipovehiculo tv ON se.idTipoVehiculo = tv.idTipoVehiculo"
                    + " where se.idTipoVehiculo = " + idTipoVehiculo + " and DATE(se.fechaServicio) >= " + "'" + fechaIni + "' and DATE(se.fechaServicio) <= " + "'" + fechaF + "'";

        }

        if (idTipoServicio != 0 && idTipoVehiculo == 0 && !"".equals(fechaFin) && !"".equals(fechaInicio)) {
            Date fechaIni = convertStringToDate(fechaInicio);
            Date fechaF = convertStringToDate(fechaFin);

            sql = "SELECT DATE(se.fechaServicio) fechaServicio, ts.tipoServicio as tipoServicio,"
                    + " tv.tipoVehiculo as tipoVehiculo, ds.valorServicio as valorServicio, se.tiempoServicio as tiempoServicio"
                    + " FROM detalleservicio ds  LEFT JOIN servicio se ON ds.idServicio = se.idServicio"
                    + " LEFT JOIN tiposervicio ts on ds.idTipoServicio = ts.idTipoServicio"
                    + " LEFT JOIN tipovehiculo tv ON se.idTipoVehiculo = tv.idTipoVehiculo"
                    + " where ds.idTipoServicio = " + idTipoServicio + " and DATE(se.fechaServicio) >= " + "'" + fechaIni + "' and DATE(se.fechaServicio) <= " + "'" + fechaF + "'";

        }

        if (idTipoServicio != 0 && idTipoVehiculo != 0 && !"".equals(fechaFin) && !"".equals(fechaInicio)) {
            Date fechaIni = convertStringToDate(fechaInicio);
            Date fechaF = convertStringToDate(fechaFin);

            sql = "SELECT DATE(se.fechaServicio) fechaServicio, ts.tipoServicio as tipoServicio,"
                    + " tv.tipoVehiculo as tipoVehiculo, ds.valorServicio as valorServicio, se.tiempoServicio as tiempoServicio"
                    + " FROM detalleservicio ds  LEFT JOIN servicio se ON ds.idServicio = se.idServicio"
                    + " LEFT JOIN tiposervicio ts on ds.idTipoServicio = ts.idTipoServicio"
                    + " LEFT JOIN tipovehiculo tv ON se.idTipoVehiculo = tv.idTipoVehiculo"
                    + " where se.idTipoVehiculo = " + idTipoVehiculo + " and ds.idTipoServicio = " + idTipoServicio + " and DATE(se.fechaServicio) >= " + "'" + fechaIni + "' and DATE(se.fechaServicio) <= " + "'" + fechaF + "'";

        }

        if (idTipoServicio != 0 && idTipoVehiculo != 0 && "".equals(fechaFin) && !"".equals(fechaInicio)) {
            Date fechaIni = convertStringToDate(fechaInicio);

            sql = "SELECT DATE(se.fechaServicio) fechaServicio, ts.tipoServicio as tipoServicio,"
                    + " tv.tipoVehiculo as tipoVehiculo, ds.valorServicio as valorServicio, se.tiempoServicio as tiempoServicio"
                    + " FROM detalleservicio ds  LEFT JOIN servicio se ON ds.idServicio = se.idServicio"
                    + " LEFT JOIN tiposervicio ts on ds.idTipoServicio = ts.idTipoServicio"
                    + " LEFT JOIN tipovehiculo tv ON se.idTipoVehiculo = tv.idTipoVehiculo"
                    + " where se.idTipoVehiculo = " + idTipoVehiculo + " and ds.idTipoServicio = " + idTipoServicio + " and DATE(se.fechaServicio) >= " + "'" + fechaIni + "'";

        }

        if (idTipoServicio != 0 && idTipoVehiculo != 0 && !"".equals(fechaFin) && "".equals(fechaInicio)) {
            Date fechaF = convertStringToDate(fechaFin);

            sql = "SELECT DATE(se.fechaServicio) fechaServicio, ts.tipoServicio as tipoServicio,"
                    + " tv.tipoVehiculo as tipoVehiculo, ds.valorServicio as valorServicio, se.tiempoServicio as tiempoServicio"
                    + " FROM detalleservicio ds  LEFT JOIN servicio se ON ds.idServicio = se.idServicio"
                    + " LEFT JOIN tiposervicio ts on ds.idTipoServicio = ts.idTipoServicio"
                    + " LEFT JOIN tipovehiculo tv ON se.idTipoVehiculo = tv.idTipoVehiculo"
                    + " where se.idTipoVehiculo = " + idTipoVehiculo + " and ds.idTipoServicio = " + idTipoServicio + " and DATE(se.fechaServicio) <= " + "'" + fechaF + "'";

        }

        if (idTipoServicio != 0 && idTipoVehiculo == 0 && "".equals(fechaFin) && !"".equals(fechaInicio)) {
            Date fechaIni = convertStringToDate(fechaInicio);

            sql = "SELECT DATE(se.fechaServicio) fechaServicio, ts.tipoServicio as tipoServicio,"
                    + " tv.tipoVehiculo as tipoVehiculo, ds.valorServicio as valorServicio, se.tiempoServicio as tiempoServicio"
                    + " FROM detalleservicio ds  LEFT JOIN servicio se ON ds.idServicio = se.idServicio"
                    + " LEFT JOIN tiposervicio ts on ds.idTipoServicio = ts.idTipoServicio"
                    + " LEFT JOIN tipovehiculo tv ON se.idTipoVehiculo = tv.idTipoVehiculo"
                    + " where ds.idTipoServicio = " + idTipoServicio + " and DATE( se.fechaServicio) >= " + "'" + fechaIni + "'";

        }

        if (idTipoServicio == 0 && idTipoVehiculo != 0 && "".equals(fechaFin) && !"".equals(fechaInicio)) {
            Date fechaIni = convertStringToDate(fechaInicio);

            sql = "SELECT DATE(se.fechaServicio) fechaServicio, ts.tipoServicio as tipoServicio,"
                    + " tv.tipoVehiculo as tipoVehiculo, ds.valorServicio as valorServicio, se.tiempoServicio as tiempoServicio"
                    + " FROM detalleservicio ds  LEFT JOIN servicio se ON ds.idServicio = se.idServicio"
                    + " LEFT JOIN tiposervicio ts on ds.idTipoServicio = ts.idTipoServicio"
                    + " LEFT JOIN tipovehiculo tv ON se.idTipoVehiculo = tv.idTipoVehiculo"
                    + " where se.idTipoVehiculo = " + idTipoVehiculo + " and DATE(se.fechaServicio) >= " + "'" + fechaIni + "'";

        }

        if (idTipoServicio != 0 && idTipoVehiculo == 0 && !"".equals(fechaFin) && "".equals(fechaInicio)) {
            Date fechaF = convertStringToDate(fechaFin);

            sql = "SELECT DATE(se.fechaServicio) fechaServicio, ts.tipoServicio as tipoServicio,"
                    + " tv.tipoVehiculo as tipoVehiculo, ds.valorServicio as valorServicio, se.tiempoServicio as tiempoServicio"
                    + " FROM detalleservicio ds  LEFT JOIN servicio se ON ds.idServicio = se.idServicio"
                    + " LEFT JOIN tiposervicio ts on ds.idTipoServicio = ts.idTipoServicio"
                    + " LEFT JOIN tipovehiculo tv ON se.idTipoVehiculo = tv.idTipoVehiculo"
                    + " where ds.idTipoServicio = " + idTipoServicio + " and DATE(se.fechaServicio) <= " + "'" + fechaF + "'";

        }

        if (idTipoServicio == 0 && idTipoVehiculo != 0 && !"".equals(fechaFin) && "".equals(fechaInicio)) {
            Date fechaF = convertStringToDate(fechaFin);

            sql = "SELECT DATE(se.fechaServicio) fechaServicio, ts.tipoServicio as tipoServicio,"
                    + " tv.tipoVehiculo as tipoVehiculo, ds.valorServicio as valorServicio, se.tiempoServicio as tiempoServicio"
                    + " FROM detalleservicio ds  LEFT JOIN servicio se ON ds.idServicio = se.idServicio"
                    + " LEFT JOIN tiposervicio ts on ds.idTipoServicio = ts.idTipoServicio"
                    + " LEFT JOIN tipovehiculo tv ON se.idTipoVehiculo = tv.idTipoVehiculo"
                    + " where se.idTipoVehiculo = " + idTipoVehiculo + " and DATE(se.fechaServicio) <= " + "'" + fechaF + "'";

        }

        return sql;
    }

    public String extraerTiempoPromedio(int idTipoVehiculo, int idTipoServicio, String fechaInicio, String fechaFin) throws ParseException, SQLException {

        String sql = "";
        if (idTipoVehiculo == 0 && idTipoServicio == 0 && "".equals(fechaInicio) && "".equals(fechaFin)) {
            sql = "SELECT sec_to_time(avg(time_to_sec(tiempoServicio))) tiempo FROM servicio";

        }

        if (idTipoVehiculo != 0 && idTipoServicio == 0 && "".equals(fechaInicio) && "".equals(fechaFin)) {
            sql = "SELECT sec_to_time(avg(time_to_sec(tiempoServicio))) tiempo FROM servicio"
                    + " where idTipoVehiculo = " + idTipoVehiculo + "";

        }
        if (idTipoVehiculo == 0 && idTipoServicio != 0 && "".equals(fechaInicio) && "".equals(fechaFin)) {
            sql = "SELECT sec_to_time(avg(time_to_sec(tiempoServicio))) tiempo FROM servicio se"
                    + " inner join detalleServicio ds on se.idServicio = ds.idServicio"
                    + " where ds.idTipoServicio = " + idTipoServicio + "";

        }
        if (idTipoVehiculo != 0 && idTipoServicio != 0 && "".equals(fechaInicio) && "".equals(fechaFin)) {
            //System.out.println("Entra");
            sql = "SELECT sec_to_time(avg(time_to_sec(tiempoServicio))) tiempo FROM servicio se"
                    + " inner join detalleServicio ds on se.idServicio = ds.idServicio"
                    + " where ds.idTipoServicio = " + idTipoServicio + " and se.idTipoVehiculo = " + idTipoVehiculo + "";
        }
        if (idTipoServicio == 0 && idTipoVehiculo == 0 && "".equals(fechaFin) && !"".equals(fechaInicio)) {
            Date fechaIni = convertStringToDate(fechaInicio);

            sql = "SELECT sec_to_time(avg(time_to_sec(tiempoServicio))) tiempo FROM servicio"
                    + " where DATE(fechaServicio) >= " + "'" + fechaIni + "'";
        }

        if (idTipoServicio == 0 && idTipoVehiculo == 0 && !"".equals(fechaFin) && "".equals(fechaInicio)) {
            Date fechaF = convertStringToDate(fechaFin);

            sql = "SELECT sec_to_time(avg(time_to_sec(tiempoServicio))) tiempo FROM servicio"
                    + " where DATE(fechaServicio) <= " + "'" + fechaF + "'";

        }

        if (idTipoServicio == 0 && idTipoVehiculo == 0 && !"".equals(fechaFin) && !"".equals(fechaInicio)) {
            Date fechaIni = convertStringToDate(fechaInicio);
            Date fechaF = convertStringToDate(fechaFin);

            sql = "SELECT sec_to_time(avg(time_to_sec(tiempoServicio))) tiempo FROM servicio"
                    + " where DATE(fechaServicio) >= " + "'" + fechaIni + "' and DATE(fechaServicio) <= " + "'" + fechaF + "'";

        }

        if (idTipoServicio == 0 && idTipoVehiculo != 0 && !"".equals(fechaFin) && !"".equals(fechaInicio)) {
            Date fechaIni = convertStringToDate(fechaInicio);
            Date fechaF = convertStringToDate(fechaFin);

            sql = "SELECT sec_to_time(avg(time_to_sec(tiempoServicio))) tiempo FROM servicio"
                    + " where idTipoVehiculo = " + idTipoVehiculo + " and DATE(fechaServicio) >= " + "'" + fechaIni + "' and DATE(fechaServicio) <= " + "'" + fechaF + "'";

        }

        if (idTipoServicio != 0 && idTipoVehiculo == 0 && !"".equals(fechaFin) && !"".equals(fechaInicio)) {
            Date fechaIni = convertStringToDate(fechaInicio);
            Date fechaF = convertStringToDate(fechaFin);

            sql = "SELECT sec_to_time(avg(time_to_sec(tiempoServicio))) tiempo FROM servicio se"
                    + " inner join detalleServicio ds on se.idServicio = ds.idServicio"
                    + " where ds.idTipoServicio = " + idTipoServicio + " and DATE(se.fechaServicio) >= " + "'" + fechaIni + "' and DATE(se.fechaServicio) <= " + "'" + fechaF + "'";

        }

        if (idTipoServicio != 0 && idTipoVehiculo != 0 && !"".equals(fechaFin) && !"".equals(fechaInicio)) {
            Date fechaIni = convertStringToDate(fechaInicio);
            Date fechaF = convertStringToDate(fechaFin);

            sql = "SELECT sec_to_time(avg(time_to_sec(tiempoServicio))) tiempo FROM servicio se"
                    + " inner join detalleServicio ds on se.idServicio = ds.idServicio"
                    + " where se.idTipoVehiculo = " + idTipoVehiculo + " and ds.idTipoServicio = " + idTipoServicio + " and DATE(se.fechaServicio) >= " + "'" + fechaIni + "' and DATE(se.fechaServicio) <= " + "'" + fechaF + "'";

        }

        if (idTipoServicio != 0 && idTipoVehiculo != 0 && "".equals(fechaFin) && !"".equals(fechaInicio)) {
            Date fechaIni = convertStringToDate(fechaInicio);

            sql = "SELECT sec_to_time(avg(time_to_sec(tiempoServicio))) tiempo FROM servicio se"
                    + " inner join detalleServicio ds on se.idServicio = ds.idServicio"
                    + " where se.idTipoVehiculo = " + idTipoVehiculo + " and ds.idTipoServicio = " + idTipoServicio + " and DATE(se.fechaServicio) >= " + "'" + fechaIni + "'";

        }

        if (idTipoServicio != 0 && idTipoVehiculo != 0 && !"".equals(fechaFin) && "".equals(fechaInicio)) {
            Date fechaF = convertStringToDate(fechaFin);

            sql = "SELECT sec_to_time(avg(time_to_sec(tiempoServicio))) tiempo FROM servicio se"
                    + " inner join detalleServicio ds on se.idServicio = ds.idServicio"
                    + " where se.idTipoVehiculo = " + idTipoVehiculo + " and ds.idTipoServicio = " + idTipoServicio + " and DATE(se.fechaServicio) <= " + "'" + fechaF + "'";

        }

        if (idTipoServicio != 0 && idTipoVehiculo == 0 && "".equals(fechaFin) && !"".equals(fechaInicio)) {
            Date fechaIni = convertStringToDate(fechaInicio);

            sql = "SELECT sec_to_time(avg(time_to_sec(tiempoServicio))) tiempo FROM servicio se"
                    + " inner join detalleServicio ds on se.idServicio = ds.idServicio"
                    + " where ds.idTipoServicio = " + idTipoServicio + " and DATE( se.fechaServicio) >= " + "'" + fechaIni + "'";

        }

        if (idTipoServicio == 0 && idTipoVehiculo != 0 && "".equals(fechaFin) && !"".equals(fechaInicio)) {
            Date fechaIni = convertStringToDate(fechaInicio);

            sql = "SELECT sec_to_time(avg(time_to_sec(tiempoServicio))) tiempo FROM servicio"
                    + " where idTipoVehiculo = " + idTipoVehiculo + " and DATE(fechaServicio) >= " + "'" + fechaIni + "'";

        }

        if (idTipoServicio != 0 && idTipoVehiculo == 0 && !"".equals(fechaFin) && "".equals(fechaInicio)) {
            Date fechaF = convertStringToDate(fechaFin);

            sql = "SELECT sec_to_time(avg(time_to_sec(tiempoServicio))) tiempo FROM servicio se"
                    + " inner join detalleServicio ds on se.idServicio = ds.idServicio"
                    + " where ds.idTipoServicio = " + idTipoServicio + " and DATE(se.fechaServicio) <= " + "'" + fechaF + "'";

        }

        if (idTipoServicio == 0 && idTipoVehiculo != 0 && !"".equals(fechaFin) && "".equals(fechaInicio)) {
            Date fechaF = convertStringToDate(fechaFin);

            sql = "SELECT sec_to_time(avg(time_to_sec(tiempoServicio))) tiempo FROM servicio"
                    + " where idTipoVehiculo = " + idTipoVehiculo + " and DATE(fechaServicio) <= " + "'" + fechaF + "'";

        }

        pst = getConnection().prepareStatement(sql);
        rs = pst.executeQuery();
        String tiempo = "";
        while (rs.next()) {
            tiempo = rs.getString("tiempo");
        }

        return tiempo;
    }

    public boolean guardarReporte(String nombreReporte, String consulta, String tiempoPromedio) throws SQLException {

        String sql = "insert into reporte(nombreReporte, consulta, tiempoPromedio) values(?,?,?)";

        pst = getConnection().prepareStatement(sql);
        pst.setString(1, nombreReporte);
        pst.setString(2, consulta);
        pst.setString(3, tiempoPromedio);

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

    public List<Reporte> verReporte(String sql) throws SQLException, ParseException {

        List<Reporte> listaReporte = new LinkedList<>();
        pst = getConnection().prepareStatement(sql);
        rs = pst.executeQuery();
        while (rs.next()) {
            String fechaServicio = rs.getString("fechaServicio");
            String tipoServicio = rs.getString("tipoServicio");
            String tipoVehiculo = rs.getString("tipoVehiculo");
            double valorServicio = rs.getDouble("valorServicio");
            String tiempoServicio = rs.getString("tiempoServicio");

            Reporte re = new Reporte(fechaServicio, tipoServicio, tipoVehiculo, valorServicio, tiempoServicio);
            listaReporte.add(re);
        }

        return listaReporte;
    }

    public static Date convertStringToDate(String str_date) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        java.util.Date d1 = (java.util.Date) format.parse(str_date);

        java.sql.Date date = new java.sql.Date(d1.getTime());

        return date;

    }

    public boolean eliminarReporte(int idReporte) throws SQLException {

        String sql = "delete from reporte where idReporte = ?";
        pst = getConnection().prepareStatement(sql);
        pst.setInt(1, idReporte);
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

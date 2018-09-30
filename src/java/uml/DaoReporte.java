
package uml;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import modelo.Database;
import modelo.Reporte;


public class DaoReporte extends Database{
    PreparedStatement pst = null;
    ResultSet rs = null;
    public List<Reporte> generarReporte(int idTipoVehiculo, int idTipoServicio, String fechaInicio, String fechaFin) throws SQLException {
        System.out.println("Lllego");
        List<Reporte> listaReporte = new LinkedList<>();
        String sql = "";
        if(idTipoVehiculo == 0 && idTipoServicio == 0 && "".equals(fechaInicio) && "".equals(fechaFin)){
            String sql2 = "SELECT DATE(se.fechaServicio) fechaServicio, ts.tipoServicio as tipoServicio,"
                    + " tv.tipoVehiculo as tipoVehiculo, ds.valorServicio as valorServicio FROM detalleservicio ds"
                    + "  LEFT JOIN servicio se ON ds.idServicio = se.idServicio LEFT JOIN tiposervicio ts"
                    + " on ds.idTipoServicio = ts.idTipoServicio LEFT JOIN tipovehiculo tv"
                    + " ON se.idTipoVehiculo = tv.idTipoVehiculo"
                    + " GROUP BY fechaServicio, tipoServicio, tipoVehiculo, valorServicio";
            
            sql = "SELECT DATE(se.fechaServicio) fechaServicio, ts.tipoServicio as tipoServicio, tv.tipoVehiculo as tipoVehiculo, ds.valorServicio as valorServicio FROM detalleservicio ds  LEFT JOIN servicio se ON ds.idServicio = se.idServicio LEFT JOIN tiposervicio ts on ds.idTipoServicio = ts.idTipoServicio LEFT JOIN tipovehiculo tv ON se.idTipoVehiculo = tv.idTipoVehiculo";
        }
        if(idTipoVehiculo != 0 && idTipoServicio == 0 && "".equals(fechaInicio) && "".equals(fechaFin)){
            sql = "SELECT DATE(se.fechaServicio) fechaServicio, ts.tipoServicio as tipoServicio, tv.tipoVehiculo as tipoVehiculo, ds.valorServicio as valorServicio FROM detalleservicio ds  LEFT JOIN servicio se ON ds.idServicio = se.idServicio LEFT JOIN tiposervicio ts on ds.idTipoServicio = ts.idTipoServicio LEFT JOIN tipovehiculo tv ON se.idTipoVehiculo = tv.idTipoVehiculo where se.idTipoVehiculo = "+idTipoVehiculo+"";
        }
        if(idTipoVehiculo == 0 && idTipoServicio != 0 && "".equals(fechaInicio) && "".equals(fechaFin)){
            sql = "SELECT DATE(se.fechaServicio) fechaServicio, ts.tipoServicio as tipoServicio, tv.tipoVehiculo as tipoVehiculo, ds.valorServicio as valorServicio FROM detalleservicio ds  LEFT JOIN servicio se ON ds.idServicio = se.idServicio LEFT JOIN tiposervicio ts on ds.idTipoServicio = ts.idTipoServicio LEFT JOIN tipovehiculo tv ON se.idTipoVehiculo = tv.idTipoVehiculo where ds.idTipoServicio = "+idTipoServicio+"";
        }
        if(idTipoVehiculo != 0 && idTipoServicio != 0 && "".equals(fechaInicio) && "".equals(fechaFin)){
            sql = "SELECT DATE(se.fechaServicio) fechaServicio, ts.tipoServicio as tipoServicio, tv.tipoVehiculo as tipoVehiculo, ds.valorServicio as valorServicio FROM detalleservicio ds  LEFT JOIN servicio se ON ds.idServicio = se.idServicio LEFT JOIN tiposervicio ts on ds.idTipoServicio = ts.idTipoServicio LEFT JOIN tipovehiculo tv ON se.idTipoVehiculo = tv.idTipoVehiculo where se.idTipoVehiculo = "+idTipoVehiculo+" and ds.idTipoServicio = "+idTipoServicio+"";
        }
        if(idTipoServicio == 0 && idTipoVehiculo == 0 && "".equals(fechaFin) && !"".equals(fechaInicio)){
            //LocalDate fechaIni = LocalDate.parse(fechaInicio);
            
            sql = "SELECT DATE(se.fechaServicio) fechaServicio, ts.tipoServicio as tipoServicio, tv.tipoVehiculo as tipoVehiculo, ds.valorServicio as valorServicio FROM detalleservicio ds  LEFT JOIN servicio se ON ds.idServicio = se.idServicio LEFT JOIN tiposervicio ts on ds.idTipoServicio = ts.idTipoServicio LEFT JOIN tipovehiculo tv ON se.idTipoVehiculo = tv.idTipoVehiculo where Date(se.fechaServicio) >= "+fechaInicio+"";
        
        }
        int cantidadServicios = 0;
        double costoTotalServicios = 0;
        pst = getConnection().prepareStatement(sql);
        rs = pst.executeQuery();
        while (rs.next()) {
            String fechaServicio = rs.getString("fechaServicio");
            String tipoServicio = rs.getString("tipoServicio");
            String tipoVehiculo = rs.getString("tipoVehiculo");
            //double costoTotalServicios = rs.getDouble("valorTotalServicio");
            //int cantidadServicios = rs.getInt("idServicio");
            double valorServicio = rs.getDouble("valorServicio");
            costoTotalServicios += valorServicio;
            cantidadServicios ++;

            //System.out.println(fechaServicio + " " + tipoServicio + " " + tipoVehiculo + " " + costoTotalServicios + " " + cantidadServicios);
            Reporte re = new Reporte(fechaServicio, tipoServicio, tipoVehiculo, valorServicio);
            listaReporte.add(re);
        }
        return listaReporte;
    }
    
    /*public static void main(String[] args) throws SQLException {
        
        DaoReporte dr = new DaoReporte();
        List<Reporte> lstaReporte = dr.generarReporte(0, 0, "", "");
        for (Reporte lstReporte : lstaReporte) {
            System.out.println(lstReporte.getFechaServicio());
            System.out.println(lstReporte.getTipoServicio());
            System.out.println(lstReporte.getTipoVehiculo());
            System.out.println(lstReporte.getCostoTotalServicios());
            System.out.println(lstReporte.getCantidadServicios());
        }
    }*/
    
}

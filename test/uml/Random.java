package uml;

import java.sql.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import modelo.Database;
import modelo.Descuento;
import modelo.Servicio;
import modelo.TipoServicio;
import modelo.TipoServicioVehiculo;
import modelo.TipoUsuario;
import modelo.TipoVehiculo;
import modelo.Usuario;

public class Random extends Database {

    PreparedStatement pst;
    ResultSet rs;
    PreparedStatement pst2;
    ResultSet rs2;
    //Connection con;

    public int randomIdUsuario() throws SQLException {

        List<Usuario> lstUsuario = new LinkedList<>();
        int[] datos = null;
        int idUsuario = 0;
        int longIdUsuario = 0;
        int idUsuarioAleatorio = 0;

        Random rnd = new Random();

        String sql2 = "SELECT count(idUsuario) as idUsuario FROM usuar";
        pst2 = getConnection().prepareStatement(sql2);
        rs2 = pst2.executeQuery();

        while (rs2.next()) {
            longIdUsuario = rs2.getInt("idUsuario");
        }
        datos = new int[longIdUsuario];
        int contador = 0;
        String sql = "select idUsuario from usuar";
        pst = getConnection().prepareStatement(sql);
        rs = pst.executeQuery();

        while (rs.next()) {
            idUsuario = rs.getInt("idUsuario");
            for (int i = contador; i < datos.length; i++) {
                datos[i] = idUsuario;
            }
            contador++;
        }
        //System.out.println("Arreglo: " + Arrays.toString(datos));
        idUsuarioAleatorio = (int) (Math.random() * datos.length + 0);
        int aleatorio = datos[idUsuarioAleatorio];
        return aleatorio;
        
    }

    public int randomIdTipoUsuario() throws SQLException {
        List<TipoUsuario> lstTipoUsuario = new LinkedList<>();
        int idTipoUsuario = 0;
        int longIdTipoUsuario = 0;
        int idTipoUsuarioAleatorio = 0;
        Random rnd = new Random();

        String sql2 = "SELECT count(idTipoUsuario) as idTipoUsuario FROM tipoUsuario";
        pst2 = getConnection().prepareStatement(sql2);
        rs2 = pst2.executeQuery();

        while (rs2.next()) {
            longIdTipoUsuario = rs2.getInt("idTipoUsuario");
        }

        String sql = "select idTipoUsuario from tipoUsuario";
        pst = getConnection().prepareStatement(sql);
        rs = pst.executeQuery();
        int[] datos = null;
        datos = new int[longIdTipoUsuario];
        int contador = 0;
        while (rs.next()) {
            idTipoUsuario = rs.getInt("idTipoUsuario");
            for (int i = contador; i < datos.length; i++) {
                datos[i] = idTipoUsuario;
            }
            contador++;
        }
        //System.out.println("Arreglo: " + Arrays.toString(datos));
        idTipoUsuarioAleatorio = (int) (Math.random() * datos.length + 0);
        int aleatorio = datos[idTipoUsuarioAleatorio];
        return aleatorio;
    }
    
    public int randomIdTipoVehiculo() throws SQLException {
        List<TipoVehiculo> lstTipoVehiculo = new LinkedList<>();
        int idTipoVehiculo = 0;
        int longIdTipoVehiculo = 0;
        int idTipoVehiculoAleatorio = 0;
        Random rnd = new Random();

        String sql2 = "SELECT count(idTipoVehiculo) as idTipoVehiculo FROM tipoVehiculo";
        pst2 = getConnection().prepareStatement(sql2);
        rs2 = pst2.executeQuery();

        while (rs2.next()) {
            longIdTipoVehiculo = rs2.getInt("idTipoVehiculo");
        }

        String sql = "select idTipoVehiculo from tipoVehiculo";
        pst = getConnection().prepareStatement(sql);
        rs = pst.executeQuery();
        int[] datos = null;
        datos = new int[longIdTipoVehiculo];
        int contador = 0;
        while (rs.next()) {
            idTipoVehiculo = rs.getInt("idTipoVehiculo");
            for (int i = contador; i < datos.length; i++) {
                datos[i] = idTipoVehiculo;
            }
            contador++;
        }
        //System.out.println("Arreglo: " + Arrays.toString(datos));
        idTipoVehiculoAleatorio = (int) (Math.random() * datos.length + 0);
        int aleatorio = datos[idTipoVehiculoAleatorio];
        return aleatorio;
    }
    
    public int randomIdTipoServicio() throws SQLException {
        List<TipoServicio> lstTipoServicio = new LinkedList<>();
        int idTipoServicio = 0;
        int longIdTipoServicio = 0;
        int idTipoServicioAleatorio = 0;
        Random rnd = new Random();

        String sql2 = "SELECT count(idTipoServicio) as idTipoServicio FROM tipoServicio";
        pst2 = getConnection().prepareStatement(sql2);
        rs2 = pst2.executeQuery();

        while (rs2.next()) {
            longIdTipoServicio = rs2.getInt("idTipoServicio");
        }

        String sql = "select idTipoServicio from tipoServicio";
        pst = getConnection().prepareStatement(sql);
        rs = pst.executeQuery();
        int[] datos = null;
        datos = new int[longIdTipoServicio];
        int contador = 0;
        while (rs.next()) {
            idTipoServicio = rs.getInt("idTipoServicio");
            for (int i = contador; i < datos.length; i++) {
                datos[i] = idTipoServicio;
            }
            contador++;
        }
        //System.out.println("Arreglo: " + Arrays.toString(datos));
        idTipoServicioAleatorio = (int) (Math.random() * datos.length + 0);
        int aleatorio = datos[idTipoServicioAleatorio];
        return aleatorio;
    }
    
    public int randomIdTipoServicioVehiculo() throws SQLException {
        List<TipoServicioVehiculo> lstTipoServicioVehiculo = new LinkedList<>();
        int idTipoServicioVehiculo = 0;
        int longIdTipoServicioVehiculo = 0;
        int idTipoServicioVehiculoAleatorio = 0;
        Random rnd = new Random();

        String sql2 = "SELECT count(idTipoServicioVehiculo) as idTipoServicioVehiculo FROM tipoServicioVehiculo";
        pst2 = getConnection().prepareStatement(sql2);
        rs2 = pst2.executeQuery();

        while (rs2.next()) {
            longIdTipoServicioVehiculo = rs2.getInt("idTipoServicioVehiculo");
        }

        String sql = "select idTipoServicioVehiculo from tipoServicioVehiculo";
        pst = getConnection().prepareStatement(sql);
        rs = pst.executeQuery();
        int[] datos = null;
        datos = new int[longIdTipoServicioVehiculo];
        int contador = 0;
        while (rs.next()) {
            idTipoServicioVehiculo = rs.getInt("idTipoServicioVehiculo");
            for (int i = contador; i < datos.length; i++) {
                datos[i] = idTipoServicioVehiculo;
            }
            contador++;
        }
        //System.out.println("Arreglo: " + Arrays.toString(datos));
        idTipoServicioVehiculoAleatorio = (int) (Math.random() * datos.length + 0);
        int aleatorio = datos[idTipoServicioVehiculoAleatorio];
        return aleatorio;
    }
    
    public int randomIdDescuento() throws SQLException {
        List<Descuento> lstDescuento = new LinkedList<>();
        int idDescuento = 0;
        int longIdDescuento = 0;
        int idDescuentoAleatorio = 0;
        Random rnd = new Random();

        String sql2 = "SELECT count(idDescuento) as idDescuento FROM descuento";
        pst2 = getConnection().prepareStatement(sql2);
        rs2 = pst2.executeQuery();

        while (rs2.next()) {
            longIdDescuento = rs2.getInt("idDescuento");
        }

        String sql = "select idDescuento from descuento";
        pst = getConnection().prepareStatement(sql);
        rs = pst.executeQuery();
        int[] datos = null;
        datos = new int[longIdDescuento];
        int contador = 0;
        while (rs.next()) {
            idDescuento = rs.getInt("idDescuento");
            for (int i = contador; i < datos.length; i++) {
                datos[i] = idDescuento;
            }
            contador++;
        }
        //System.out.println("Arreglo: " + Arrays.toString(datos));
        idDescuentoAleatorio = (int) (Math.random() * datos.length + 0);
        int aleatorio = datos[idDescuentoAleatorio];
        return aleatorio;
    }
    
    public int randomIdServicio() throws SQLException {
        List<Servicio> lstServicio = new LinkedList<>();
        int idServicio = 0;
        int longIdServicio = 0;
        int idServicioAleatorio = 0;
        Random rnd = new Random();

        String sql2 = "SELECT count(idServicio) as idServicio FROM servicio where estado = 'proceso'";
        pst2 = getConnection().prepareStatement(sql2);
        rs2 = pst2.executeQuery();

        while (rs2.next()) {
            longIdServicio = rs2.getInt("idServicio");
        }

        String sql = "select idServicio from servicio where estado = 'proceso'";
        pst = getConnection().prepareStatement(sql);
        rs = pst.executeQuery();
        int[] datos = null;
        datos = new int[longIdServicio];
        int contador = 0;
        while (rs.next()) {
            idServicio = rs.getInt("idServicio");
            for (int i = contador; i < datos.length; i++) {
                datos[i] = idServicio;
            }
            contador++;
        }
        //System.out.println("Arreglo: " + Arrays.toString(datos));
        idServicioAleatorio = (int) (Math.random() * datos.length + 0);
        int aleatorio = datos[idServicioAleatorio];
        return aleatorio;
    }
    
    public String randomNombreUsuario(){
        String nameAleatorio = "";
        
        String [] names = {"Andres","Marilin","Oscar",
                            "Pedro","Carlos","Jose",
                            "Luis","Juan",
                            "Claudia","Claudia","Sebastian",
                            "Juliana", "Maria", "Mariana"};
        int aleatorio = (int) (Math.random() * names.length + 0);
       nameAleatorio = names[aleatorio];
        
        return nameAleatorio;
    }

    public static void main(String[] args) throws SQLException {
        Random r = new Random();
        int p = r.randomIdServicio();
        System.out.println(p);
    }
}

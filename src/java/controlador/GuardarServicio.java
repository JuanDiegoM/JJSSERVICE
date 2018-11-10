package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uml.DaoServicio;

/**
 *
 * @author Diego
 */
@WebServlet(name = "GuardarServicio", urlPatterns = {"/GuardarServicio"})
public class GuardarServicio extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter pt = response.getWriter();
        try {

            String[] ArrayTipoServicios = request.getParameterValues("idTipoServicio[]");
            String[] ArrayValoresServicios = request.getParameterValues("valorServicio[]");
            //System.out.println(Arrays.toString(ArrayValoresServicios));
            int idTipoServicio[];
            double valorServicio[];
            valorServicio = new double[ArrayValoresServicios.length];
            idTipoServicio = new int[ArrayTipoServicios.length];

            for (int i = 0; i < ArrayTipoServicios.length; i++) {
                idTipoServicio[i] = Integer.parseInt(ArrayTipoServicios[i]);
                valorServicio[i] = Double.parseDouble(ArrayValoresServicios[i]);
            }
            String cedulaCliente = request.getParameter("cedulaConductor");
            int idTipoVehiculo = Integer.parseInt(request.getParameter("idTipoVehiculo"));
            String placaVehiculo = request.getParameter("placaVehiculo");
            double subtotal = Double.parseDouble(request.getParameter("subtotal"));
            int porcentajeDescuento = Integer.parseInt(request.getParameter("porcentajeDescuento"));
            double valorDescuento = Double.parseDouble(request.getParameter("valorDescuento"));
            double valorTotalServicio = Double.parseDouble(request.getParameter("totalServicio"));
            String horaLlegada = request.getParameter("horaLlegada");
            String fechaServicio = request.getParameter("fechaServicio");
            DaoServicio daoS = new DaoServicio();
            if (daoS.registrarServicio(cedulaCliente, placaVehiculo, subtotal, porcentajeDescuento, valorDescuento, valorTotalServicio, idTipoServicio, valorServicio, idTipoVehiculo)) {

                pt.println("Servicio Registrado");
                

            } else {
                
                pt.println("Error al tratar de registrar el servicio");
                
            }
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(GuardarServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

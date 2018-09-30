package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Servicio;
import uml.DaoServicio;

@WebServlet(name = "liquidarServicio", urlPatterns = {"/liquidarServicio"})
public class liquidarServicio extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        int idServicio = Integer.parseInt(request.getParameter("idServicio"));
        try {
            DaoServicio daoS = new DaoServicio();
            List<Servicio> listaServicio = daoS.liquidarServicio(idServicio);
            out.println("<center><label>LIQUIDACI&Oacute;N DEL SERVICIO PRESTADO</label></center><br>");
            out.println("<center><img style='width: 30%; height: 55px;' src='images/service.jpg'></center><br><br>");
            for (Servicio lstServicio : listaServicio) {
                out.println("<center>");
                out.println("<label> Fecha Del Servicio: " + lstServicio.getFechaServicio() + "</label><br>");
                out.println("<label> Cedula Cliente: " + lstServicio.getCedulaCliente() + "</label><br>");
                out.println("<label> Placa Del Veh&iacute;culo: " + lstServicio.getPlacaVehiculo() + "</label><br>");
                out.println("<label> Hora De Entrada: " + lstServicio.getHoraLlegada() + "</label><br>");
                out.println("<label> Hora De Salida: " + lstServicio.getHoraSalida() + "</label><br>");
                out.println("<label> Duraci&oacute;n Del Servicio: " + lstServicio.getTiempoDuracion() + "</label><br>");
                out.println("<label> Subtotal: " + lstServicio.getSubtotal() + "</label><br>");
                if (lstServicio.getPorcentajeDescuento() != 0 && lstServicio.getValorDescuento() != 0) {
                    out.println("<label> Porcentaje De Descuento: " + lstServicio.getPorcentajeDescuento() + " %</label><br>");
                    out.println("<label> Valor Descuento: " + lstServicio.getValorDescuento() + "</label><br>");
                }
                
                out.println("<label> Valor Total Del Servicio: " + lstServicio.getValorTotalServicio() + "</label><br><br>");

            }
            out.println("<label>GRACIAS POR ELEGIRNOS</label>");
            out.println("<center>");

        } catch (SQLException e) {
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

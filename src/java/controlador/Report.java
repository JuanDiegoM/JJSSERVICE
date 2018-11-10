package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Reporte;
import uml.DaoReporte;

/**
 *
 * @author Diego
 */
@WebServlet(name = "Report", urlPatterns = {"/Report"})
public class Report extends HttpServlet {

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
        double costoTotalServicios = 0;
        int i = 0;
        PrintWriter out = response.getWriter();
        int idTipoVehiculo = Integer.parseInt(request.getParameter("idTipoVehiculo"));
        int idTipoServicio = Integer.parseInt(request.getParameter("idTipoServicio"));
        String fechaInicio = request.getParameter("fechaInicio");
        String fechaFin = request.getParameter("fechaFin");
        
        try {
            DaoReporte daoR = new DaoReporte();
            List<Reporte> lstaReporte = daoR.generarReporte(idTipoVehiculo, idTipoServicio, fechaInicio, fechaFin);
            String consulta = daoR.extraerConsulta(idTipoVehiculo, idTipoServicio, fechaInicio, fechaFin);
            //System.out.println(consulta);
            out.println("<input type='hidden' id='consulta' name='consulta' value='"+consulta+"'>");
            out.println("<table class='table table-bordered'>");
            out.println("<thead>");
            out.println("<tr>\n" +
"                                <th>Fecha Servicio</th>\n" +
"                                <th>Tipo Servicio</th>\n" +
"                                <th>Tipo Veh&iacute;culo</th>\n" +
"                                <th>Costo Servicio</th>\n" +
"                            </tr>");
            out.println("</thead>");
            
            for (Reporte lstReporte : lstaReporte) {
                                
                out.println("<tbody>");
                out.println("<tr>\n" +
"                                <td>"+lstReporte.getFechaServicio()+"</td>\n" +
"                                <td>"+lstReporte.getTipoServicio()+"</td>\n" +
"                                <td>"+lstReporte.getTipoVehiculo()+"</td>\n" +
"                                <td>"+lstReporte.getValorServicio()+"</td>\n" +
"                            </tr>");
                out.println("</tbody>");
                costoTotalServicios = costoTotalServicios+lstReporte.getValorServicio();
                i++;
                //out.println("<td>Valor total servicios: "+lstReporte.getCostoTotalServicios()+"</td>");
                //out.println("<td>Cantidad Servicios: "+lstReporte.getCantidadServicios()+"</td>");
            }
            out.println("<th>Valor Total Servicios</th>");
            out.println("<th>"+costoTotalServicios+"</th>");
            out.println("<th>Cantidad De servicios Prestados</th>");
            out.println("<th>"+i+"</th>");
            //out.println("<th>Promedio de tiempo</th>");
            out.println("</table>");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Report.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

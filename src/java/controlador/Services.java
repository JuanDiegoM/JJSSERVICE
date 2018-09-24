package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Database;

/**
 *
 * @author Diego
 */
@WebServlet(name = "Services", urlPatterns = {"/Services"})
public class Services extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        PreparedStatement pst = null;
        ResultSet rs = null;
        Database con = new Database();

        int idTipoVehiculo = Integer.parseInt(request.getParameter("idTipoVehiculo"));
        String sql = "select sv.idTipoServicio, ts.tipoServicio, sv.valorServicio from tipoServicioVehiculo sv inner join tipoServicio ts on sv.idTipoServicio = ts.idTipoServicio where sv.idTipoVehiculo = " + idTipoVehiculo + "";
        int i = 1;
        int contador = 0;
        try {
            pst = con.getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            out.println("<table class='table table-bordered'>");
            out.println("<thead>");
            out.println("<th></th>");
            out.println("<th>Tipo Servicio</th>");
            out.println("<th>Valor Servicio</th>");
            out.println("</thead>");
            while (rs.next()) {
                out.println("<tbody>");
                out.println("<tr>");
                out.println("<td><input type='checkbox' class='form-control idTipoServicio' value='"+rs.getString(1)+"' id='idTipoServicio"+i+"' name='idTipoServicio"+i+"' onclick='calcular("+i+")'></td>");
                out.println("<td><input type='text' class='form-control' disabled='true' value='"+rs.getString(2)+"' id='tipoServicio"+i+"' name='tipoServicio"+i+"'></td>");
                out.println("<td><input type='text' class='form-control' disabled='true' value='"+rs.getString(3)+"' id='valorServicio"+i+"' name='valorServicio"+i+"'></td>");
                out.println("</tr>");
                out.println("</tbody>");
                i++;
                contador++;
            }
            out.println("</table>");
            out.println("<input type'text' hidden='true' id='contadorTipoServicios' value='"+contador+"'>");
        } catch (SQLException ex) {
            Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

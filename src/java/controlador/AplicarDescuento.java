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
@WebServlet(name = "AplicarDescuento", urlPatterns = {"/AplicarDescuento"})
public class AplicarDescuento extends HttpServlet {

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

        String sql = "select * from descuento";
        try {
            pst = con.getConnection().prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                out.println("<label>% Descuento</label>");
                out.println("<input type='text' class='form-control' value='"+rs.getString(3)+"' name='porcentajeDescuento' id='porcentajeDescuento' disabled='true'>");

            }
        } catch (SQLException ex) {
            Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uml.DaoUsuario;

@WebServlet(name = "ControllerUsers", urlPatterns = {"/controllerusers"})
public class ControllerUsers extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControllerUsers</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControllerUsers at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        if (request.getParameter("guardarNuevoUsuario") != null) {

            String nombreUsuario = request.getParameter("nombreUsuarioNew");
            int idTipoUsuario = Integer.parseInt(request.getParameter("tipoUsuarioNew"));
            String password = request.getParameter("passNew");
            try {
                DaoUsuario du = new DaoUsuario();
                if (du.registrarUsuario(nombreUsuario, password, idTipoUsuario)) {

                    RequestDispatcher vista = request.getRequestDispatcher("usuarios.jsp");
                    vista.forward(request, response);

                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('User or password incorrect');");
                    //out.println("location='index.jsp';");
                    out.println("</script>");
                } else {
                    RequestDispatcher vista = request.getRequestDispatcher("nuevoUsuario.jsp");
                    vista.forward(request, response);
                }
            } catch (IOException | SQLException | ServletException e) {

            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

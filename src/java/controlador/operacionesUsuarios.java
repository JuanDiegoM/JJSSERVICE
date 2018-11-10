package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uml.DaoTipoUsuario;
import uml.DaoUsuario;

/**
 *
 * @author Diego
 */
@WebServlet(name = "operacionesUsuarios", urlPatterns = {"/operacionesUsuarios"})
public class operacionesUsuarios extends HttpServlet {

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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String status = "";
        String opcion = request.getParameter("opcion");
        System.out.println(opcion);
        if ("eliminarTipoUsuario".equals(request.getParameter("opcion"))) {
            int idTipoUsuario = Integer.parseInt(request.getParameter("idTipoUsuario"));
            DaoTipoUsuario daoTu = new DaoTipoUsuario();
            try {
                if (daoTu.eliminarTipoUsuario(idTipoUsuario)) {
                    //status = "OK";
                    out.println("true");
                    //out.println("Tipo de usuario eliminado");
                } else {
                    //status = "ERROR";
                    out.println("false");
                    //out.println("No se puede eliminar el tipo de usuario por que esta relacionado con un usuario");
                }
            } catch (SQLException ex) {
                Logger.getLogger(operacionesUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if ("nuevoTipoDeUsuario".equals(request.getParameter("opcion"))) {
            String tipoUsuario = request.getParameter("tipoUsuarioNew");
            DaoTipoUsuario daoTu = new DaoTipoUsuario();
            try {
                if (daoTu.registrarTipoUsuario(tipoUsuario)) {

                    out.println("true");

                } else {

                    out.println("false");

                }
            } catch (SQLException ex) {
                Logger.getLogger(operacionesUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if ("editarTipoDeUsuario".equals(request.getParameter("opcion"))) {
            int idTipoUsuario = Integer.parseInt(request.getParameter("idTipoUsuario"));
            String tipoUsuario = request.getParameter("tipoUsuarioEdit");
            DaoTipoUsuario daoTu = new DaoTipoUsuario();
            try {
                if (daoTu.editarTipoUsuario(idTipoUsuario, tipoUsuario)) {
                    out.println("true");
                } else {
                    out.println("false");
                }
            } catch (SQLException ex) {
                Logger.getLogger(operacionesUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if ("nuevoUsuario".equals(request.getParameter("opcion"))) {
            String nombreUsuario = request.getParameter("nombreUsuarioNew");
            int idTipoUsuario = Integer.parseInt(request.getParameter("tipoUsuarioNew"));
            String password = request.getParameter("passNew");

            DaoUsuario du = new DaoUsuario();
            try {
                if (du.registrarUsuario(nombreUsuario, password, idTipoUsuario)) {
                    out.println("true");
                } else {
                    out.println("false");
                }
            } catch (SQLException ex) {
                Logger.getLogger(operacionesUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if ("eliminarUsuario".equals(request.getParameter("opcion"))) {
            int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            DaoUsuario du = new DaoUsuario();

            try {
                if (du.eliminarUsuario(idUsuario)) {
                    out.println("true");
                } else {
                    out.println("false");
                }
            } catch (SQLException ex) {
                Logger.getLogger(operacionesUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if ("editarUsuario".equals(request.getParameter("opcion"))) {
            String passEdit = request.getParameter("passEdit");
            String passRep = request.getParameter("passRepEdit");
            String nombreUsuario = request.getParameter("nombreUsuarioEdit");
            int idTipoUsuarioEdit = Integer.parseInt(request.getParameter("tipoUsuarioEdit"));
            int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));

            if ("".equals(passEdit) && "".equals(passRep)) {
                DaoUsuario du = new DaoUsuario();
                try {
                    if (du.editarUsuarioSinPassw(idUsuario, nombreUsuario, idTipoUsuarioEdit)) {                        
                          out.println("true");                        
                    } else {
                        
                        out.println("false");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(operacionesUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                DaoUsuario du = new DaoUsuario();
                try {
                    if (du.editarUsuario(idUsuario, nombreUsuario, passEdit, idTipoUsuarioEdit)) {
                        out.println("true");
                        
                    } else {
                        out.println("false");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(operacionesUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

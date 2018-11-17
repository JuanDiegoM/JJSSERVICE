/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.servlet.http.HttpSession;
import uml.DaoDescuento;
import uml.DaoReporte;
import uml.DaoServicio;
import uml.DaoTipoServicio;
import uml.DaoTipoServicioVehiculo;
import uml.DaoTipoVehiculo;

/**
 *
 * @author Diego
 */
@WebServlet(name = "operacionesTipoServicioTipoVehiculo", urlPatterns = {"/operacionesTipoServicioTipoVehiculo"})
public class operacionesTipoServicioTipoVehiculo extends HttpServlet {

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
        if ("eliminarTipoVehiculo".equals(request.getParameter("opcion"))) {
            int idTipoVehiculo = Integer.parseInt(request.getParameter("idTipoVehiculo"));
            DaoTipoVehiculo daoTv = new DaoTipoVehiculo();
            try {
                if (daoTv.eliminarTipoVehiculo(idTipoVehiculo)) {
                    out.println("true");
                } else {
                    out.println("false");
                }
            } catch (SQLException ex) {

            }
        } else if ("guardarTipoVehiculo".equals(request.getParameter("opcion"))) {

            String tipoVehiculo = request.getParameter("tipoVehiculoNew");
            DaoTipoVehiculo daoTv = new DaoTipoVehiculo();
            try {
                if (daoTv.registrarTipoVehiculo(tipoVehiculo)) {
                    out.println("true");
                } else {
                    out.println("false");
                }
            } catch (SQLException ex) {
                Logger.getLogger(operacionesTipoServicioTipoVehiculo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if ("editarTipoVehiculo".equals(request.getParameter("opcion"))) {

            String tipoVehiculo = request.getParameter("tipoVehiculoEdit");
            int idTipoVehiculo = Integer.parseInt(request.getParameter("idTipoVehiculo"));
            DaoTipoVehiculo daoTv = new DaoTipoVehiculo();
            try {
                if (daoTv.editarTipoVehiculo(idTipoVehiculo, tipoVehiculo)) {
                    out.println("true");
                } else {
                    out.println("false");
                }
            } catch (SQLException ex) {
                Logger.getLogger(operacionesTipoServicioTipoVehiculo.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if ("eliminarTipoServicio".equals(request.getParameter("opcion"))) {
            int idTipoServicio = Integer.parseInt(request.getParameter("idTipoServicio"));
            DaoTipoServicio daoTs = new DaoTipoServicio();
            try {
                if (daoTs.eliminarTipoServicio(idTipoServicio)) {
                    out.println("true");
                } else {
                    out.println("false");
                }
            } catch (SQLException ex) {

            }
        } else if ("guardarTipoServicio".equals(request.getParameter("opcion"))) {
            String tipoServicio = request.getParameter("tipoServicioNew");
            DaoTipoServicio daoTs = new DaoTipoServicio();
            try {
                if (daoTs.registrarTiposervicio(tipoServicio)) {
                    out.println("true");

                } else {
                    out.println("false");

                }
            } catch (SQLException ex) {
                Logger.getLogger(operacionesTipoServicioTipoVehiculo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if ("editarTipoServicio".equals(request.getParameter("opcion"))) {
            String tipoServicio = request.getParameter("tipoServicioEdit");
            int idTipoServicio = Integer.parseInt(request.getParameter("idTipoServicio"));
            DaoTipoServicio daoTs = new DaoTipoServicio();
            try {
                if (daoTs.editarTipoServicio(idTipoServicio, tipoServicio)) {
                    out.println("true");
                } else {
                    out.println("false");
                }
            } catch (SQLException ex) {
                Logger.getLogger(operacionesTipoServicioTipoVehiculo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if ("guardarCostoServicio".equals(request.getParameter("opcion"))) {
            int idTipoVehiculo = Integer.parseInt(request.getParameter("parametroTipoVehiculonew"));
            int idTipoServicio = Integer.parseInt(request.getParameter("parametroServicionew"));
            double valorServicio = Double.parseDouble(request.getParameter("parametroValorServicio"));
            DaoTipoServicioVehiculo daoTsv = new DaoTipoServicioVehiculo();

            try {
                if (daoTsv.registrarTiposervicioVehiculo(idTipoServicio, idTipoVehiculo, valorServicio)) {
                    out.println("true");
                } else {
                    out.println("false");
                }
            } catch (SQLException ex) {

            }
        } else if ("eliminarCostoServicio".equals(request.getParameter("opcion"))) {
            int idTipoServicioVehiculo = Integer.parseInt(request.getParameter("idCostoServicio"));
            DaoTipoServicioVehiculo daoTsv = new DaoTipoServicioVehiculo();
            try {
                if (daoTsv.eliminarTipoServicioVehiculo(idTipoServicioVehiculo)) {
                    out.println("true");
                } else {
                    out.println("false");
                }
            } catch (SQLException ex) {

            }
        } else if ("editarCostoServicio".equals(request.getParameter("opcion"))) {
            int idTipoServicioVehiculo = Integer.parseInt(request.getParameter("idTipoServicioVehiculo"));
            int idTipoServicio = Integer.parseInt(request.getParameter("parametroServicioEdit"));
            int idTipoVehiculo = Integer.parseInt(request.getParameter("parametroTipoVehiculoEdit"));
            double valorServicio = Double.parseDouble(request.getParameter("parametroValorServicioEdit"));
            DaoTipoServicioVehiculo daoTsv = new DaoTipoServicioVehiculo();
            try {
                if (daoTsv.editarTipoServicioVehiculo(idTipoServicioVehiculo, idTipoVehiculo, idTipoServicio, valorServicio)) {
                    out.println("true");
                } else {
                    out.println("false");
                }
            } catch (SQLException ex) {
                Logger.getLogger(operacionesTipoServicioTipoVehiculo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if ("eliminarParametrodescuento".equals(request.getParameter("opcion"))) {
            int idParametroDescuento = Integer.parseInt(request.getParameter("idParametroDescuento"));
            DaoDescuento Dd = new DaoDescuento();
            try {
                if (Dd.eliminarParametroDescuento(idParametroDescuento)) {
                    out.println("true");
                } else {
                    out.println("false");
                }
            } catch (SQLException ex) {

            }
        } else if ("guardarParametroDescuento".equals(request.getParameter("opcion"))) {
            String descripcion = request.getParameter("parametroDescuentoNew");
            int porcentajeDescuento = Integer.parseInt(request.getParameter("porcentajeDescuentoNew"));
            DaoDescuento Dd = new DaoDescuento();
            try {
                if (Dd.registrarParametroDescuento(descripcion, porcentajeDescuento)) {
                    out.println("true");
                } else {
                    out.println("false");
                }
            } catch (SQLException ex) {
                Logger.getLogger(operacionesTipoServicioTipoVehiculo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if ("editarParametroDescuento".equals(request.getParameter("opcion"))) {
            String descripcion = request.getParameter("parametroDescuentoEdit");
            int idParametroDescuento = Integer.parseInt(request.getParameter("idParametroDescuento"));
            int porcentajeDescuento = Integer.parseInt(request.getParameter("porcentajeDescuentoEdit"));
            DaoDescuento Dd = new DaoDescuento();
            try {
                if (Dd.editarPorcentajeDescuento(idParametroDescuento, descripcion, porcentajeDescuento)) {
                    out.println("true");
                } else {
                    out.println("false");
                }
            } catch (SQLException ex) {
                Logger.getLogger(operacionesTipoServicioTipoVehiculo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if ("guardarReporte".equals(request.getParameter("opcion"))) {
            HttpSession misession = (HttpSession) request.getSession();
            String consulta =  (String) misession.getAttribute("consulta");
            String tiemoPromedio = (String) misession.getAttribute("tiemoPromedio");
            DaoReporte daoR = new DaoReporte();
            //String consulta = request.getParameter("consulta");
            String nombreReporte = request.getParameter("nombreReporte");
            try {
                if (daoR.guardarReporte(nombreReporte, consulta, tiemoPromedio)) {
                    out.println("true");
                } else {
                    out.println("false");
                }
            } catch (SQLException ex) {
                Logger.getLogger(operacionesTipoServicioTipoVehiculo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if ("eliminarServicio".equals(request.getParameter("opcion"))) {
            int idServicio = Integer.parseInt(request.getParameter("idServicio"));
            DaoServicio daoS = new DaoServicio();
            try {
                if (daoS.eliminarServicio(idServicio)) {
                    out.println("true");
                } else {
                    out.println("false");
                }
            } catch (SQLException ex) {
                Logger.getLogger(operacionesTipoServicioTipoVehiculo.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if ("finaliSezarrvicio".equals(request.getParameter("opcion"))) {
            int idServicio = Integer.parseInt(request.getParameter("idServicio"));
            DaoServicio daoS = new DaoServicio();
            try {
                if (daoS.finalizarServicio(idServicio)) {
                    out.println("true");
                } else {
                    out.println("false");
                }
            } catch (SQLException ex) {
                Logger.getLogger(operacionesTipoServicioTipoVehiculo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if("eliminarReporte".equals(request.getParameter("opcion"))){
            int idReporte = Integer.parseInt(request.getParameter("idReporte"));
            DaoReporte daoR = new DaoReporte();
            try {
                if(daoR.eliminarReporte(idReporte)){
                    out.println("true");
                }else{
                    out.println("false");
                }
            } catch (SQLException ex) {
                Logger.getLogger(operacionesTipoServicioTipoVehiculo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

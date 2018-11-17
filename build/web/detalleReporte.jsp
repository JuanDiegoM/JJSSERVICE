<%-- 
    Document   : detalleReporte
    Created on : 11/10/2018, 09:12:14 PM
    Author     : Diego
--%>

<%@page import="java.util.logging.Logger"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.util.logging.Level"%>
<%@page import="modelo.Reporte"%>
<%@page import="java.util.List"%>
<%@page import="uml.DaoReporte"%>
<%@page import="java.sql.*"%>
<%@page import="modelo.Database"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <jsp:include page="head.jsp"></jsp:include>
        </head>
        <body>
        <jsp:include page="index.jsp"></jsp:include>
            <a href="listarReportes.jsp" type="button" class="btn btn-success btn-sm" aria-label="Left Align">
                <span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span>
            </a><br>
        <%
            String consulta = "";
            String tiempoPromedio = "";
        %>
        <%
            try {

                int idReporte = Integer.parseInt(request.getParameter("consulta"));
                Database con = new Database();
                PreparedStatement pst = null;
                ResultSet rs = null;

                String sql = "select consulta, tiempoPromedio from reporte where idReporte = " + idReporte + "";
                pst = con.getConnection().prepareStatement(sql);
                rs = pst.executeQuery();

                while (rs.next()) {
                    consulta = rs.getString("consulta");
                    tiempoPromedio = rs.getString("tiempoPromedio");
                }
                //System.out.println(consulta);

            } catch (Exception e) {

            }

        %>

        <%            double costoTotalServicios = 0;
            int i = 0;
            try {
                DaoReporte daoR = new DaoReporte();
                List<Reporte> lstaReporte = daoR.verReporte(consulta);
                out.println("<br>");
                out.println("<table class='table table-bordered'>");
                out.println("<thead>");
                out.println("<tr>\n"
                        + "                                <th>Fecha Servicio</th>\n"
                        + "                                <th>Tipo Servicio</th>\n"
                        + "                                <th>Tipo Veh&iacute;culo</th>\n"
                        + "                                <th>Costo Servicio</th>\n"
                        + "                                <th>Tiempo Servicio</th>\n"
                        + "                            </tr>");
                out.println("</thead>");

                for (Reporte lstReporte : lstaReporte) {

                    out.println("<tbody>");
                    out.println("<tr>\n"
                            + "                                <td>" + lstReporte.getFechaServicio() + "</td>\n"
                            + "                                <td>" + lstReporte.getTipoServicio() + "</td>\n"
                            + "                                <td>" + lstReporte.getTipoVehiculo() + "</td>\n"
                            + "                                <td>" + lstReporte.getValorServicio() + "</td>\n"
                            + "                                <td>" + lstReporte.getTiempoServicio()+ "</td>\n"
                            + "                            </tr>");
                    out.println("</tbody>");
                    costoTotalServicios = costoTotalServicios + lstReporte.getValorServicio();
                    i++;
                    //out.println("<td>Valor total servicios: "+lstReporte.getCostoTotalServicios()+"</td>");
                    //out.println("<td>Cantidad Servicios: "+lstReporte.getCantidadServicios()+"</td>");
                }
                out.println("</table><br>");
                out.println("<table class='table table-bordered'>");
                out.println("<tr>");
                out.println("<th>Valor Total Servicios</th>");
                out.println("<th>" + costoTotalServicios + "</th>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<th>Cantidad De servicios Prestados</th>");
                out.println("<th>" + i + "</th>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<th>Tiempo Promedio</th>");
                out.println("<th>" + tiempoPromedio + "</th>");
                out.println("</tr>");
                out.println("</table>");

            } catch (SQLException ex) {

            }
        %>
    </body>
</html>

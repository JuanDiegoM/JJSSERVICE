<%-- 
    Document   : operacionesServicios
    Created on : 30/09/2018, 09:50:58 AM
    Author     : Diego
--%>

<%@page import="uml.DaoServicio"%>
<%@page import="java.io.PrintWriter"%>
<% PrintWriter pt = response.getWriter(); %>

<%

    if (request.getParameter("liquidarServicio") != null) {
        int idServicio = Integer.parseInt(request.getParameter("liquidarServicio"));
        DaoServicio daoS = new DaoServicio();
        if (daoS.finalizarServicio(idServicio)) {

            pt.println("<script type=\"text/javascript\">");
            pt.println("alert('Servicio Finalizado');");
            session.setAttribute( "idServicio", idServicio);
            pt.println("location='liquidarServicio.jsp';");
            pt.println("</script>");

        } else {

            pt.println("<script type=\"text/javascript\">");
            pt.println("alert('Error al tratar de finalizar el servicio');");
            pt.println("location='listarServicios.jsp';");
            pt.println("</script>");

        }

    }
%>
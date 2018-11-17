<%-- 
    Document   : operacionesServicios
    Created on : 30/09/2018, 09:50:58 AM
    Author     : Diego
--%>

<%@page import="uml.DaoReporte"%>
<%@page import="modelo.Reporte"%>
<%@page import="java.sql.SQLException"%>
<%@page import="uml.DaoServicio"%>
<%@page import="java.io.PrintWriter"%>
<% PrintWriter pt = response.getWriter(); %>

<%

    if (request.getParameter("liquidarServicio") != null) {
        int idServicio = Integer.parseInt(request.getParameter("liquidarServicio"));
        DaoServicio daoS = new DaoServicio();
        if (daoS.finalizarServicio(idServicio)) {

            pt.println("<script type=\"text/javascript\">");
            session.setAttribute("idServicio", idServicio);
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

<%
    if (request.getParameter("jjjj") != null) {
        try {

            String[] ArrayTipoServicios = request.getParameterValues("idTipoServicio[]");
            String[] ArrayValoresServicios = request.getParameterValues("valorServicio[]");
            //System.out.println(Arrays.toString(ArrayValoresServicios));
            int idTipoServicio[];
            double valorServicio[];
            valorServicio = new double[ArrayValoresServicios.length];
            idTipoServicio = new int[ArrayTipoServicios.length];
            try {
                for (int i = 0; i < ArrayTipoServicios.length; i++) {
                    valorServicio[i] = Double.parseDouble(ArrayValoresServicios[i]);
                    idTipoServicio[i] = Integer.parseInt(ArrayTipoServicios[i]);

                }
            } catch (Exception e) {
            }

            String cedulaCliente = request.getParameter("cedulaConductor");
            int idTipoVehiculo = Integer.parseInt(request.getParameter("parametroTipoVehiculonew"));
            String placaVehiculo = request.getParameter("placaVehiculo");
            //double subtotal = Double.parseDouble(request.getParameter("subtotal"));
            int porcentajeDescuento = Integer.parseInt(request.getParameter("porcentajeDescuento"));
            double valorDescuento = Double.parseDouble(request.getParameter("valorDescuento"));
            double valorTotalServicio = Double.parseDouble(request.getParameter("totalServicio"));

            DaoServicio daoS = new DaoServicio();
            if (daoS.registrarServicio(cedulaCliente, placaVehiculo, 0, porcentajeDescuento, valorDescuento, valorTotalServicio, idTipoServicio, valorServicio, idTipoVehiculo)) {

                pt.println("<script type=\"text/javascript\">");
                pt.println("alert('Servicio Registrado');");
                pt.println("location='listarServicios.jsp';");
                pt.println("</script>");
            } else {
                pt.println("<script type=\"text/javascript\">");
                pt.println("alert('Error al tratar de registrar el servicio');");
                pt.println("location='nuevoServicio.jsp';");
                pt.println("</script>");
            }
        } catch (SQLException ex) {

        }
    }
%>

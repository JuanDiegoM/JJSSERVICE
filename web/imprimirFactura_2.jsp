<%-- 
    Document   : imprimirFactura
    Created on : 8/10/2018, 09:10:58 PM
    Author     : Diego
--%>

<%@page import="modelo.Servicio"%>
<%@page import="java.util.List"%>
<%@page import="uml.DaoServicio"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.SQLException"%>
<%
    HttpSession misession = (HttpSession) request.getSession();
    int idServicio = (int)misession.getAttribute("idServicio");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>       
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.2/jspdf.min.js"></script>
    </head>
    <body  onload="window.print()">
        <br><br>
        <input type="hidden" value="<%= idServicio%>" id="idServicio">
    <form>
    <%
        PrintWriter pt = response.getWriter();
        
        try {
            DaoServicio daoS = new DaoServicio();
            List<Servicio> listaServicio = daoS.liquidarServicio(idServicio);%>
            
            <center><label>LIQUIDACI&Oacute;N DEL SERVICIO PRESTADO</label></center><br>
            <center><img style='width: 30%; height: 55px;' src='images/service.jpg'></center><br><br>
            <%
            for (Servicio lstServicio : listaServicio) {%>
                <center>
                <label> Fecha Del Servicio: <%= lstServicio.getFechaServicio() %></label><br>
                <label> Cedula Cliente: <%= lstServicio.getCedulaCliente()%></label><br>
                <label> Placa Del Veh&iacute;culo: <%= lstServicio.getPlacaVehiculo()%></label><br>
                <label> Hora De Entrada: <%= lstServicio.getHoraLlegada()%></label><br>
                <label> Hora De Salida: <%= lstServicio.getHoraSalida()%></label><br>
                <label> Duraci&oacute;n Del Servicio: <%= lstServicio.getTiempoDuracion()%></label><br>
                <label> Subtotal: <%= lstServicio.getSubtotal()%></label><br>
                <%
                if (lstServicio.getPorcentajeDescuento() != 0 && lstServicio.getValorDescuento() != 0) {%>
                    <label> Porcentaje De Descuento: <%= lstServicio.getPorcentajeDescuento()%>%</label><br>
                    <label> Valor Descuento: <%= lstServicio.getValorDescuento()%></label><br>
                <%}%>
                
                <label> Valor Total Del Servicio: <%= lstServicio.getValorTotalServicio()%></label><br><br>

            <%}%>
            <br><br>
            <label>GRACIAS POR ELEGIRNOS</label>
            <center>

        <%} catch (SQLException e) {
        }
    %>
    </form>
    </body>
</html>

<%-- 
    Document   : liquidarServicio
    Created on : 27/09/2018, 05:52:59 PM
    Author     : Diego
--%>

<%
    HttpSession misession = (HttpSession) request.getSession();
    Object idServicio = misession.getAttribute("idServicio");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="head.jsp"></jsp:include>
            <script src="boostrap/js/liquidarServicio.js" type="text/javascript"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.2/jspdf.min.js"></script>
        </head>
        <body>
        <jsp:include page="index.jsp"></jsp:include>
        <input type="hidden" value="<%= idServicio%>" id="idServicio">

        <div id="tablaLiquidacion">

        </div><br>
    <center>
        <a href="javascript:generarFactura()" class="btn btn-success" type="button">Generar Factura</a>
    </center>
</body>
</html>

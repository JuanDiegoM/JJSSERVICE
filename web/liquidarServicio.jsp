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
            <script src="boostrap/js/jspdf.js" type="text/javascript"></script>
        </head>
        <script src="boostrap/js/jspdf.js" type="text/javascript"></script>
        <body>
        <jsp:include page="index.jsp"></jsp:include>
        <input type="hidden" value="<%= idServicio%>" id="idServicio">
        <form>
            <div id="tablaLiquidacion">

            </div><br>
        </form>
    <center>
        <input type="button" value="IMPRIMIR" class="btn btn-success" onclick="imprimirFactura();">
        <!--input type="button" value="IMPRIMIR" class="btn btn-success"
            onclick="javascript:window.open('imprimirFactura_2.jsp', 'Factura', 'width=1200, height=650, scrollbars=NO')"--> 
    </center>
</body>
</html>

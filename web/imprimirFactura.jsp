<%-- 
    Document   : imprimirFactura
    Created on : 8/10/2018, 09:46:16 PM
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
        <body onload="window.print()">
        
        <input type="hidden" value="<%= idServicio%>" id="idServicio">
        <form>
            <div id="tablaLiquidacion">

            </div><br>
        </form>
</body>
</html>

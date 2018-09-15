<%-- 
    Document   : listarServicios
    Created on : 30/08/2018, 08:26:18 PM
    Author     : Diego
--%>

<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="head.jsp"></jsp:include>
    </head>
    <body>
        <%
            HttpSession misession = (HttpSession) request.getSession();
            Usuario usuario = (Usuario) misession.getAttribute("usuarios");
        %>
        <jsp:include page="index.jsp"></jsp:include>
        <br><br>
    </body>
</html>

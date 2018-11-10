<%-- 
    Document   : tipoUsuario
    Created on : 30/08/2018, 08:29:36 PM
    Author     : Diego
--%>

<%@page import="modelo.Usuario"%>
<%
    HttpSession misession = (HttpSession) request.getSession();
    Usuario usuario = (Usuario) misession.getAttribute("usuarios");
%>

<%@page import="java.sql.*"%>
<%@page import="modelo.Database"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="head.jsp"></jsp:include>
            <script src="boostrap/js/Reportes.js" type="text/javascript"></script>
            <link href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet" />

        </head>
        <body>

        <jsp:include page="index.jsp"></jsp:include>
            <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js" ></script>
            <script src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
            <br><br>
            <form action="" method="post" id="" name="">
                <div class = "row">
                    <div class = "col-md-10 col-md-offset-1">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <h3 class="panel-title">Lista de reportes</h3>
                            </div>
                            <div class="panel-body">
                                <div  class="form-control-col-sm-4 col-xs-4">
                                    <input type="text" id="filtrar" class="form-control" placeholder="Buscar..."><br>
                                </div>
                                <table class="table table-bordered">
                                    <thead>
                                        <tr>
                                            <th style="visibility: hidden" style="width: 1%;"></th> 
                                            <th></th>
                                            <th>Nombre del reporte</th>
                                            <th>
                                                <a href="nuevoReporte.jsp" type="button" class="btn btn-info ">
                                                    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                                                </a> 
                                            </th>

                                        </tr>
                                    </thead>
                                    <tbody class="buscar">
                                    <%                                        try {
                                            Database con = new Database();
                                            PreparedStatement pst = null;
                                            ResultSet rs = null;

                                            String sql = "select * from reporte";
                                            pst = con.getConnection().prepareStatement(sql);
                                            rs = pst.executeQuery();

                                            while (rs.next()) {

                                    %>
                                    <tr>
                                        <td style="visibility: hidden; width: 1%;"></td>
                                        <td style="width: 10px;">
                                            <a href="detalleReporte.jsp?consulta=<%=rs.getString(1)%>" type="button" class="btn btn-default">
                                                <span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
                                            </a>
                                        </td>                                   

                                        <td><%=rs.getString(2)%></td>
                                        <td style="width: 10px;">
                                            <%

                                                if (usuario.getIdTipoUsuario() == 1) {

                                            %>
                                            <button type="button" class="btn btn-danger" onclick="borrarReporte(<%=rs.getString(1)%>);" id="" name="">
                                                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                            </button>
                                            <%}%>

                                        </td>

                                    </tr> 
                                    <%}

                                            pst.close();
                                            rs.close();
                                            con.getConnection().close();

                                        } catch (Exception e) {
                                            System.err.println("Error" + e);
                                        }
                                    %>
                                </tbody>
                            </table> 
                        </div>

                    </div>
                </div>
            </div>
        </form>
    </body>
</html>

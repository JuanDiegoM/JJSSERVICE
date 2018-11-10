<%-- 
    Document   : parametroCostoServicios
    Created on : 30/08/2018, 08:29:00 PM
    Author     : Diego
--%>

<%@page import="java.sql.*"%>
<%@page import="modelo.Database"%>
<%
    HttpSession misession = (HttpSession) request.getSession();
    Usuario usuario = (Usuario) misession.getAttribute("usuarios");
    if (usuario.getIdTipoUsuario() == 1) {

%>

<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="head.jsp"></jsp:include>
            <script src="boostrap/js/parametrosCostoServicios.js" type="text/javascript"></script>
            <link href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet" />
        </head>
        <body>

        <jsp:include page="index.jsp"></jsp:include>
            <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js" ></script>
            <script src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
            <br><br>

            <form action="" method="post" id="formularioCostoServicio" name="formularioCostoServicio">
                <div class = "row">
                    <div class = "col-md-10 col-md-offset-1">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <h3 class="panel-title">Costo De Servicios</h3>
                            </div>
                            <div class="panel-body">
                                <div class="container">
                                    <div  class="form-control-col-sm-4 col-xs-4">                                    
                                        <input type="text" id="filtrar" class="form-control" placeholder="Buscar..."><br>
                                    </div> 
                                </div>

                                <table class="table table-bordered">
                                    <thead>
                                        <tr>
                                            <th style="visibility: hidden" style="width: 1%;"></th> 
                                            <th></th>
                                            <th>Tipo Servicio</th>
                                            <th>Tipo Vehículo</th>
                                            <th>Valor Servicio</th>

                                            <th colspan="2">
                                                <a href="nuevoCostoServicio.jsp" type="button" class="btn btn-info ">
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

                                            //String sql = "select * from tipoServicioVehiculo";
                                            String sql = "SELECT sv.idTipoServicioVehiculo, ts.tipoServicio, tv.tipoVehiculo, sv.valorServicio FROM tipoServicioVehiculo sv INNER JOIN tipoServicio ts on sv.idTipoServicio = ts.idTipoServicio INNER JOIN tipoVehiculo tv on sv.idTipoVehiculo = tv.idTipoVehiculo";
                                            pst = con.getConnection().prepareStatement(sql);
                                            rs = pst.executeQuery();

                                            while (rs.next()) {

                                    %>
                                    <tr>
                                        <td style="visibility: hidden; width: 1%;"><%=rs.getString(1)%></td>
                                        <td>
                                            <a href="" type="button" class="btn btn-default">
                                                <span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
                                            </a>
                                        </td>                                   

                                        <td><%=rs.getString(2)%></td>
                                        <td><%=rs.getString(3)%></td>
                                        <td><%=rs.getString(4)%></td>

                                        <td>
                                            <a type="button" class="btn btn-primary " href="editarCostoServicio.jsp?idTipoServicioVehiculo=<%=rs.getString(1)%>">
                                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                            </a>

                                        </td>

                                        <td>

                                            <button type="button" class="btn btn-danger" onclick="borrarCostoServicio(<%=rs.getString(1)%>);" id="btnEliminarTipoServicioVehiculo" name="btnEliminarTipoServicioVehiculo">
                                                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                            </button>

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

<%
    } else {
        response.sendRedirect("index.jsp");
    }
%>

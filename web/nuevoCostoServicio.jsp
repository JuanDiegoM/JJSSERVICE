<%-- 
    Document   : nuevoUsuario
    Created on : 2/09/2018, 12:35:25 PM
    Author     : Diego
--%>

<%@page import="modelo.Usuario"%>
<%
    HttpSession misession = (HttpSession) request.getSession();
    Usuario usuario = (Usuario) misession.getAttribute("usuarios");
    if (usuario.getIdTipoUsuario() == 1) {

%>

<%    Database con = new Database();
    PreparedStatement pst = null;
    ResultSet rs = null;
    PreparedStatement pst2 = null;
    ResultSet rs2 = null;
%>

<%@page import="java.sql.*"%>
<%@page import="modelo.Database"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Costo Servicio</title>
        <jsp:include page="head.jsp"></jsp:include>
            <script src="boostrap/js/parametrosCostoServicios.js" type="text/javascript"></script>
            <link href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet" />
        </head>
        <body>

        <jsp:include page="index.jsp"></jsp:include>
            <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js" ></script>
            <script src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
            <br><br>
            <div class = "row">
                <div class = "col-md-10 col-md-offset-1">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title">Nuevo Costo Servicio</h3>
                        </div>

                        <div class="panel-body">
                            <form action="" method="post" id="formNuevoCostoServicio">
                                <div class="row">
                                    <div class="form-group">

                                        <div class="col-md-3">
                                            <label>Tipo de Servicio</label>
                                            <select class="form-control" id="parametroServicionew" name="parametroServicionew">
                                                <option selected="true" disabled="true">Seleccione tipo de servicio</option>
                                            <%
                                                try {

                                                    String sql = "select * from tipoServicio";
                                                    pst = con.getConnection().prepareStatement(sql);
                                                    rs = pst.executeQuery();

                                                    while (rs.next()) {
                                            %>

                                            <option value="<%=rs.getString(1)%>"><%=rs.getString(2)%></option>

                                            <%}

                                                } catch (Exception e) {
                                                    System.err.println("Error" + e);
                                                }
                                            %>
                                        </select>
                                    </div>

                                    <div class="col-md-3">
                                        <label>Tipo de Vehículo</label>
                                        <select class="form-control" id="parametroTipoVehiculonew" name="parametroTipoVehiculonew">
                                            <option selected="true" disabled="true">Seleccione tipo de vehículo</option>
                                            <%
                                                try {

                                                    String sql2 = "select * from tipoVehiculo";
                                                    pst2 = con.getConnection().prepareStatement(sql2);
                                                    rs2 = pst2.executeQuery();

                                                    while (rs2.next()) {
                                            %>

                                            <option value="<%=rs2.getString(1)%>"><%=rs2.getString(2)%></option>

                                            <%}

                                                    pst.close();
                                                    rs.close();
                                                    pst2.close();
                                                    rs2.close();
                                                    con.getConnection().close();

                                                } catch (Exception e) {
                                                    System.err.println("Error" + e);
                                                }
                                            %>
                                        </select>
                                    </div>

                                    <div class="col-md-3">
                                        <label>Valor Servicio</label>
                                        <input type="number" name="parametroValorServicio" id="parametroValorServicio" class="form-control">
                                    </div>

                                </div>
                            </div>
                            <br>

                            <div class="row">
                                <div class="form-group">                                    
                                    <div class="col-md-5">
                                        <br>
                                        <input type="button" class="btn btn-success" value="Guardar" id="guardarNuevoCostoServicio">
                                        <a href="parametroCostoServicios.jsp" class="btn btn-success">Cancelar</a>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>
    </body>
</html>

<%
    } else {
        response.sendRedirect("paginaPrincipal.jsp");
    }
%>

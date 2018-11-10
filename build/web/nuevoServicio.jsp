<%-- 
    Document   : nuevoServicio
    Created on : 30/08/2018, 06:58:02 PM
    Author     : Aida
--%>

<%@page import="java.sql.*"%>
<%@page import="modelo.Database"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="head.jsp"></jsp:include>
            <script src="boostrap/js/servicios.js" type="text/javascript"></script>
            <link href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet" />
        </head>
        <body>
        <%
            HttpSession misession = (HttpSession) request.getSession();
            Usuario usuario = (Usuario) misession.getAttribute("usuarios");
        %>

        <%
            Database con = new Database();
            PreparedStatement pst = null;
            ResultSet rs = null;
            PreparedStatement pst2 = null;
            ResultSet rs2 = null;
        %>

        <% PrintWriter pt = response.getWriter(); %>

        <jsp:include page="index.jsp"></jsp:include>
        
        <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js" ></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
            <br><br>        
            <div class = "row">
                <div class = "col-md-10 col-md-offset-1">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title">Nuevo Servicio</h3>
                        </div>
                        <form method="post">
                            <div class="panel-body">
                                <div class="row">
                                    <div class="form-group">
                                        <div class="col-md-4">
                                            <label>Cedula Conductor</label>
                                            <input type="text" class="form-control" id="cedulaConductor" name="cedulaConductor">
                                        </div>
                                        <div class="col-md-4">
                                            <label>Placa Vehículo</label>
                                            <input type="text" class="form-control" id="placaVehiculo" name="placaVehiculo">
                                        </div>
                                        <div class="col-md-4">
                                            <label>Tipo de vehículo</label>
                                            <select class="form-control" id="parametroTipoVehiculonew" name="parametroTipoVehiculonew">
                                                <option selected="true" disabled="true">Seleccione tipo de vehículo</option>
                                            <%
                                                try {

                                                    String sql = "select * from tipoVehiculo";
                                                    pst = con.getConnection().prepareStatement(sql);
                                                    rs = pst.executeQuery();

                                                    while (rs.next()) {
                                            %>

                                            <option value="<%=rs.getString(1)%>"><%=rs.getString(2)%></option>

                                            <%}

                                                    pst.close();
                                                    rs.close();
                                                    con.getConnection().close();

                                                } catch (Exception e) {
                                                    System.err.println("Error" + e);
                                                }
                                            %>
                                        </select>
                                    </div>
                                </div>
                            </div><br>
                            <div class="row">                       
                                <div class="form-group panel panel-success">

                                    <div class="panel-heading">
                                        <h3 class="panel-title">Seleccione uno o mas tipos de servicios</h3>
                                    </div>

                                    <div class="panel-body">
                                        <div id="tabla">

                                        </div>
                                    </div>

                                </div>
                            </div><br>
                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-4">
                                        <label>Subtotal</label>
                                        <input type="text" class="form-control" id="subtotal" name="subtotal" disabled="true">
                                    </div>

                                    <div class="col-md-4">
                                        <label>Valor descuento</label>
                                        <input type="text" class="form-control" id="valorDescuento" name="valorDescuento" disabled="true">
                                    </div>
                                    <div class="col-md-4">    
                                        <div id="descuento">

                                        </div>                                        
                                    </div>
                                </div>
                            </div>
                            <br>
                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-4">
                                        <label>Total Servicio</label>
                                        <input type="text" class="form-control" id="totalServicio" name="totalServicio" disabled="true">
                                    </div><br>

                                    <div class="col-md-4">
                                        <input type="button" class="btn btn-success" value="Guardar" name="guardarNuevoServicio" onclick="guardarServicio()">
                                        <a href="listarServicios.jsp" type="button" class="btn btn-success">Cancelar</a>
                                    </div>

                                </div>
                            </div>

                        </div>
                    </form>
                    <div class="panel-footer">

                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

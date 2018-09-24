<%-- 
    Document   : nuevoUsuario
    Created on : 2/09/2018, 12:35:25 PM
    Author     : Diego
--%>
<%@page import="java.sql.*"%>
<%@page import="modelo.Database"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Database con = new Database();
    PreparedStatement pst = null;
    ResultSet rs = null;
    PreparedStatement pst2 = null;
    ResultSet rs2 = null;
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Reporte</title>
        <jsp:include page="head.jsp"></jsp:include>

        </head>
        <body>
        <jsp:include page="index.jsp"></jsp:include>
            <br><br>
            <div class = "row">
                <div class = "col-md-10 col-md-offset-1">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title">Nuevo Reporte</h3>
                        </div>

                        <div class="panel-body">
                            <form action="" method="post" id="formNuevoReporte">
                                <div class="row">
                                    <div class="form-group">
                                        <div class="col-md-5">
                                            <label>Fecha Inicio</label>
                                            <input type="date" class="form-control" id="reporteFechaInicio" name="reporteFechaInicio">
                                        </div>

                                        <div class="col-md-5">
                                            <label>Fecha Fin</label>
                                            <input type="date" class="form-control" id="reporteFechaFin" name="reporteFechaFin">
                                        </div>

                                    </div>
                                </div>
                                <br>

                                <div class="row">
                                    <div class="form-group">

                                        <div class="col-md-5">
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

                                    <div class="col-md-5">
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
                                </div>
                            </div>

                            <br>

                            <div class="row">
                                <div class="form-group">                                    
                                    <div class="col-md-4">
                                        <br>
                                        <input type="submit" class="btn btn-success" value="Generar Reporte" name="generarReporte">
                                        <a href="listarReportes.jsp" class="btn btn-success">Cancelar</a>
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


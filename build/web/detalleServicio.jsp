<%-- 
    Document   : tipoUsuario
    Created on : 30/08/2018, 08:29:36 PM
    Author     : Diego
--%>


<%@page import="java.sql.*"%>
<%@page import="modelo.Database"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="head.jsp"></jsp:include>

        </head>
        <body>

        <jsp:include page="index.jsp"></jsp:include>
            <br><br>
            <form action="" method="post" id="formularioTipoServicio" name="formularioServicio">
                <div class = "row">
                    <div class = "col-md-10 col-md-offset-1">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <h3 class="panel-title">Detalle Servicio</h3>
                            </div>
                            <div class="panel-body"><br>

                            <%
                                try {
                                    int idservicio = Integer.parseInt(request.getParameter("idservicio"));
                                    Database con = new Database();
                                    PreparedStatement pst2 = null;
                                    ResultSet rs2 = null;

                                    String sql2 = "select se.placaVehiculo, se.cedulaCliente, tv.tipoVehiculo from servicio se inner join tipoVehiculo tv on se.idTipoVehiculo = tv.idTipoVehiculo where idServicio = " + idservicio + "";
                                    pst2 = con.getConnection().prepareStatement(sql2);
                                    rs2 = pst2.executeQuery();

                                    while (rs2.next()) {

                            %>
                            <div class="row">
                                <div class="col-lg-4">
                                    <label>Cédula Cliente </label> <%= rs2.getString(2)%>
                                </div>
                                <div class="col-lg-4">
                                    <label>Placa Vehículo: </label> <%= rs2.getString(1)%>
                                </div>
                                <div class="col-lg-4">
                                    <label>Tipo Vehículo: </label> <%= rs2.getString(3)%>
                                </div>

                            </div><br>
                            <%}

                                    pst2.close();
                                    rs2.close();
                                    con.getConnection().close();

                                } catch (Exception e) {
                                    System.err.println("Error" + e);
                                }
                            %>
                            <table class="table table-bordered">
                                <thead>
                                    <tr>


                                        <th>Tipo Servicio</th>
                                        <th>Valor Servicio</th>

                                    </tr>
                                </thead>
                                <tbody>
                                    <%                                        try {
                                            int idservicio = Integer.parseInt(request.getParameter("idservicio"));
                                            Database con = new Database();
                                            PreparedStatement pst = null;
                                            ResultSet rs = null;

                                            String sql = "select ts.tipoServicio, ds.valorServicio from detalleServicio ds inner join tipoServicio ts on ds.idTipoServicio = ts.idTipoServicio inner join servicio se on ds.idServicio = se.idServicio where se.idServicio = " + idservicio + "";
                                            pst = con.getConnection().prepareStatement(sql);
                                            rs = pst.executeQuery();

                                            while (rs.next()) {

                                    %>
                                    <tr>


                                        <td><%=rs.getString(1)%></td>
                                        <td><%=rs.getString(2)%></td>


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
            <div class="container">
                <div class="col-md-12">
                    <a href="listarServicios.jsp" class="btn btn-success">Volver</a>
                </div>
            </div>

        </form>
    </body>
</html>


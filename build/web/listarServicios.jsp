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
            <form action="operacionesServicios.jsp" method="post" id="formularioServicio" name="formularioServicio">
                <div class = "row">
                    <div class = "col-md-10 col-md-offset-1">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <h3 class="panel-title">Servicios</h3>
                            </div>
                            <div class="panel-body">

                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th style="visibility: hidden" style="width: 1%;"></th> 
                                        <th></th>
                                        <th>Cedula Cliente</th>
                                         <th>Placa Vehiculo</th>
                                          <th>Fecha Servicio</th>
                                          <th>Hora de Entrada</th>
                                          <th>Tipo Vehículo</th>
                                          <th>Valor Servicio</th>
                                          <th>Estado Servicio</th>

                                        <th colspan="2">
                                            <a href="nuevoServicio.jsp" type="button" class="btn btn-info ">
                                                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                                            </a>                                          

                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%                                        try {
                                            Database con = new Database();
                                            PreparedStatement pst = null;
                                            ResultSet rs = null;

                                            String sql = "select se.idServicio, se.cedulaCliente, se.placaVehiculo, DATE(se.date) Fecha, TIME(se.horaEntrada) Hora, tv.tipoVehiculo, se.valorTotalservicio, se.estado  from servicio se inner join tipoVehiculo tv on se.idTipoVehiculo = tv.idTipoVehiculo where se.estado = 'proceso'";
                                            pst = con.getConnection().prepareStatement(sql);
                                            rs = pst.executeQuery();

                                            while (rs.next()) {

                                    %>
                                    <tr>
                                        <td style="visibility: hidden; width: 1%;"><%=rs.getString(1)%></td>
                                        <td>
                                            <a href="detalleServicio.jsp?idservicio=<%=rs.getString(1) %>" type="button" class="btn btn-default">
                                                <span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
                                            </a>
                                        </td>                                   

                                        <td><%=rs.getString(2)%></td>
                                        <td><%=rs.getString(3)%></td>
                                        <td><%=rs.getString(4)%></td>
                                        <td><%=rs.getString(5)%></td>
                                        <td><%=rs.getString(6)%></td>
                                        <td><%=rs.getString(7)%></td>
                                        <td><%=rs.getString(8)%></td>

                                        <!--td>
                                            <a type="button" class="btn btn-primary " href="editarServicio.jsp?idServicio=<%=rs.getString(1)%>">
                                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                            </a>

                                        </td>

                                        <td>

                                            <button type="submit" class="btn btn-danger" value="<%=rs.getString(1)%>" id="btnEliminarServicio" name="btnEliminarServicio">
                                                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                            </button>

                                        </td-->
                                        
                                        <td>
                                           <button type="submit" class="btn btn-success" value="<%=rs.getString(1)%>" id="liquidarServicio" name="liquidarServicio">
                                                Liquidar Servicio
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


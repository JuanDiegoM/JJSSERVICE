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
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Tipo De Vehículo</title>
        <jsp:include page="head.jsp"></jsp:include>
        <script src="boostrap/js/tipoVehiculo.js" type="text/javascript"></script>
    </head>
    <body>
        <jsp:include page="index.jsp"></jsp:include>
        <br><br>
        <div class = "row">
            <div class = "col-md-10 col-md-offset-1">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Nuevo Tipo De Vehiculo</h3>
                    </div>

                    <div class="panel-body">
                        <form action="operacionesParametrizacion.jsp" method="post" id="formNuevoTipoVehiculo" name="formNuevoTipoVehiculo">
                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-5">
                                        <label>Tipo de Vehículo</label>
                                        <input type="text" class="form-control" id="tipoVehiculoNew" name="tipoVehiculoNew">
                                    </div>                                    
                                </div>
                            </div>
                            <br>

                            <div class="row">
                                <div class="form-group">                                    
                                    <div class="col-md-5">
                                        <br>
                                        <input type="submit" class="btn btn-success" value="Guardar" name="guardarNuevoTipoVehiculo">
                                        <a href="tipoVehiculos.jsp" class="btn btn-success">Cancelar</a>
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
    }else{
        response.sendRedirect("paginaPrincipal.jsp");
    }
%>


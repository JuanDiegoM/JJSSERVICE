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
        <title>Nuevo Tipo De Servicio</title>
        <jsp:include page="head.jsp"></jsp:include>
        <script src="boostrap/js/tipoServicioVehiculo.js" type="text/javascript"></script>
    </head>
    <body>
        <jsp:include page="index.jsp"></jsp:include>
        <br><br>
        <div class = "row">
            <div class = "col-md-10 col-md-offset-1">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Nuevo Tipo De Servicio</h3>
                    </div>

                    <div class="panel-body">
                        <form action="operacionesParametrizacion.jsp" method="post" id="formNuevoTipoServicio">
                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-5">
                                        <label>Tipo de Servicio</label>
                                        <input type="text" class="form-control" id="tipoServicioNew" name="tipoServicioNew">
                                    </div>                                    
                                </div>
                            </div>
                            <br>

                            <div class="row">
                                <div class="form-group">                                    
                                    <div class="col-md-5">
                                        <br>
                                        <input type="submit" class="btn btn-primary" value="Guardar" name="guardarNuevoTipoServicio">
                                        <a href="tipoServicios.jsp" class="btn btn-primary">Cancelar</a>
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

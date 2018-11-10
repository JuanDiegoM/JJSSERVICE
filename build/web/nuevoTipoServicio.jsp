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
                            <h3 class="panel-title">Nuevo Tipo De Servicio</h3>
                        </div>

                        <div class="panel-body">
                            <form action="" method="post" id="formNuevoTipoServicio">
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
                                            <input type="button" class="btn btn-success" value="Guardar" id="guardarNuevoTipoServicio">
                                            <a href="tipoServicios.jsp" class="btn btn-success">Cancelar</a>
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

<%    } else {
        response.sendRedirect("paginaPrincipal.jsp");
    }
%>

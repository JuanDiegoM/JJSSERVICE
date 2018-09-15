<%-- 
    Document   : nuevoServicio
    Created on : 30/08/2018, 06:58:02 PM
    Author     : Aida
--%>

<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="head.jsp"></jsp:include>
    </head>
    <body>
        <%
            HttpSession misession = (HttpSession) request.getSession();
            Usuario usuario = (Usuario) misession.getAttribute("usuarios");
        %>
        <jsp:include page="index.jsp"></jsp:include>
        <br><br>        
        <div class = "row">
            <div class = "col-md-10 col-md-offset-1">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Nuevo Servicio</h3>
                    </div>
                    <form>
                        <div class="panel-body">
                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-4">
                                        <label>Cedula Conductor</label>
                                        <input type="text" class="form-control">
                                    </div>
                                    <div class="col-md-4">
                                        <label>Placa Vehículo</label>
                                        <input type="text" class="form-control">
                                    </div>
                                    <div class="col-md-4">
                                        <label>Tipo de vehículo</label>
                                        <select class="form-control">
                                            <option selected="true" disabled="true">Seleccione tipo de vehículo</option>
                                        </select>
                                    </div>
                                </div>
                            </div><br>
                            <div class="row">                       
                                <div class="form-group">
                                    <div class="col-md-4">
                                        <label>Tipo de servicio</label>
                                        <select class="form-control">
                                            <option selected="true" disabled="true">Seleccione tipo de servicio</option>
                                        </select>
                                    </div>
                                    <div class="col-md-3">
                                        <label>Valor servicio</label>
                                        <input type="text" class="form-control">
                                    </div>
                                </div>

                                <div id="destino">

                                </div>

                                <div class="col-md-6">
                                    <br><br>
                                    <button type="button" class="btn btn-success">Agregarr servicio</button>
                                </div>

                            </div><br>
                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-4">
                                        <label>Subtotal</label>
                                        <input type="text" class="form-control">
                                    </div>
                                    <div class="col-md-4">
                                        <label>% Descuento</label>
                                        <input type="text" class="form-control">
                                    </div>
                                    <div class="col-md-4">
                                        <label>Valor descuento</label>
                                        <input type="text" class="form-control">
                                    </div>
                                </div>
                            </div>
                            <br>
                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-4">
                                        <label>Total Servicio</label>
                                        <input type="text" class="form-control">
                                    </div><br>
                                    <div class="col-md-4">
                                        <input type="submit" class="btn btn-success" value="Guardar">
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

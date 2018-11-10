<%-- 
    Document   : nuevoUsuario
    Created on : 2/09/2018, 12:35:25 PM
    Author     : Diego
--%>

<%
    HttpSession misession = (HttpSession) request.getSession();
    Usuario usuario = (Usuario) misession.getAttribute("usuarios");
    if (usuario.getIdTipoUsuario() == 1) {

%>

<%@page import="modelo.Usuario"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.Catch"%>
<%@page import="java.sql.*"%>
<%@page import="modelo.Database"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Usuario</title>
        <jsp:include page="head.jsp"></jsp:include>
            <script src="boostrap/js/usuarios.js" type="text/javascript"></script>
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
                            <h3 class="panel-title">Nuevo Usuario</h3>
                        </div>

                        <div class="panel-body">
                            <form action="" method="POST" id="formNuevoUsuario">
                                <div class="row">
                                    <div class="form-group">
                                        <div class="col-md-5">
                                            <label>Nombre Usuario</label>
                                            <input type="text" class="form-control" id="nombreUsuarioNew" name="nombreUsuarioNew" onchange="limpiarCampos()">
                                        </div>

                                        <div class="col-md-5">
                                            <label>Tipo de usuario</label>
                                            <select class="form-control" id="tipoUsuarioNew" name="tipoUsuarioNew" onchange="limpiarCampos()">
                                                <option selected="true" disabled="true">Seleccione tipo de usuario</option>
                                            <%                                                try {
                                                    Database con = new Database();
                                                    PreparedStatement pst = null;
                                                    ResultSet rs = null;

                                                    String sql = "select * from tipoUsuario";
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
                            </div>
                            <br>
                            <div class="row">
                                <div class="form-group">                                    
                                    <div class="col-md-5">
                                        <label>Contraseña</label>
                                        <input type="password" name="passNew" id="passNew" class="form-control" onchange="limpiarCampos()">
                                    </div>
                                    <div class="col-md-5">
                                        <label>Repita Contraseña</label>
                                        <input type="password" name="passRepNew" id="passRepNew" class="form-control">
                                    </div>

                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group">                                    
                                    <div class="col-md-5">
                                        <br>
                                        <input type="button" class="btn btn-success" value="Guardar" id="guardarNuevoUsuario">
                                        <a href="usuarios.jsp" class="btn btn-success">Cancelar</a>
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

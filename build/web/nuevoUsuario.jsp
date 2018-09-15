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
    </head>
    <body>
        <jsp:include page="index.jsp"></jsp:include>
        <br><br>
        <div class = "row">
            <div class = "col-md-10 col-md-offset-1">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Nuevo Usuario</h3>
                    </div>

                    <div class="panel-body">
                        <form action="controllerusers" method="POST" id="formNuevoUsuario">
                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-5">
                                        <label>Nombre Usuario</label>
                                        <input type="text" class="form-control" id="nombreUsuarioNew" name="nombreUsuarioNew">
                                    </div>

                                    <div class="col-md-5">
                                        <label>Tipo de usuario</label>
                                        <select class="form-control" id="tipoUsuarioNew" name="tipoUsuarioNew">
                                            <option selected="true" disabled="true">Seleccione tipo de usuario</option>
                                            <%
                                                try {
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
                                        <input type="password" name="passNew" id="passNew" class="form-control">
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
                                        <input type="submit" class="btn btn-primary" value="Guardar" name="guardarNuevoUsuario">
                                        <a href="usuarios.jsp" class="btn btn-primary">Cancelar</a>
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

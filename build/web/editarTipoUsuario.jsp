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
                        <h3 class="panel-title"> Editar Tipo De Usuario</h3>
                    </div>
                    
                 <%
                    Database con = new Database();
                    PreparedStatement pst = null;
                    ResultSet rs = null;

                    int idTipoUsuario = Integer.parseInt(request.getParameter("idTipoUsuario"));

                    String sql = "select * from tipoUsuario where idTipoUsuario = ?";
                    pst = con.getConnection().prepareStatement(sql);
                    pst.setInt(1, idTipoUsuario);
                    rs = pst.executeQuery();

                    while (rs.next()) {

                %>
                    <div class="panel-body">
                        <form action="operacionesUsuarios.jsp?idTipoUsuario=<%= rs.getString(1)%>" method="post" id="formEditarTipoUsuario">
                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-5">
                                        <label>Tipo de usuario</label>
                                        <input type="text" class="form-control" value="<%= rs.getString(2)%>" id="tipoUsuarioEdit" name="tipoUsuarioEdit">
                                    </div>                                    
                                </div>
                            </div>
                            <br>

                            <div class="row">
                                <div class="form-group">                                    
                                    <div class="col-md-5">
                                        <br>
                                        <input type="submit" class="btn btn-primary" value="Guardar" name="guardarEditarTipoUsuario">
                                        <a href="tipoUsuario.jsp" class="btn btn-primary">Cancelar</a>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                    <%
                        }
                        pst.close();
                        rs.close();
                        con.getConnection().close();
                    %>

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

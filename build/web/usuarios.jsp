<%-- 
    Document   : usuarios
    Created on : 30/08/2018, 08:29:20 PM
    Author     : Diego
--%>
<%
    HttpSession misession = (HttpSession) request.getSession();
    Usuario usuario = (Usuario) misession.getAttribute("usuarios");
    if (usuario.getIdTipoUsuario() == 1) {

%>
<%@page import="modelo.Usuario"%>
<%@page import="java.sql.*"%>
<%@page import="modelo.Database"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="head.jsp"></jsp:include>
        <script src="boostrap/js/usuarios.js" type="text/javascript"></script>
    </head>
    <body>
         <jsp:include page="index.jsp"></jsp:include>
        <br><br>
        <form action="operacionesUsuarios.jsp" method="post" id="formularioEliminarUsuario" name="formularioEliminarUsuario">
            <div class = "row">
                <div class = "col-md-10 col-md-offset-1">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title">Usuarios</h3>
                        </div>
                        <div class="panel-body">
                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th style="visibility: hidden" style="width: 1%;"></th> 
                                        <th></th>
                                        <th>Nombre</th>
                                        <th>Tipo de usuario</th>
                                        <th colspan="2">
                                            <a href="nuevoUsuario.jsp" type="button" class="btn btn-info ">
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

                                            String sql = "select u.idUsuario, u.nombre, tu.tipoUsuario from usuar u inner join tipoUsuario tu on u.idTipoUsuario = tu.idTipoUsuario";
                                            pst = con.getConnection().prepareStatement(sql);
                                            rs = pst.executeQuery();

                                            while (rs.next()) {

                                    %>
                                    <tr>
                                        <td style="visibility: hidden; width: 1%;"><%=rs.getString(1)%></td>
                                        <td>
                                            <a href="" type="button" class="btn btn-default">
                                                <span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
                                            </a>
                                        </td>                                   

                                        <td><%=rs.getString(2)%></td>
                                        <td><%=rs.getString(3)%></td>

                                        <td>
                                            <a type="button" class="btn btn-primary " href="editarUsuario.jsp?idUsuario=<%=rs.getString(1)%>">
                                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                            </a>

                                        </td>

                                        <td>

                                            <button type="submit" class="btn btn-danger" value="<%=rs.getString(1)%>" id="btnEliminarUsuario" name="btnEliminarUsuario">
                                                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                            </button>
                                            
                                        </td>

                                    </tr> 
                                    <%}

                                            pst.close();
                                            rs.close();
                                            con.getConnection().close();

                                        }catch (Exception e) {
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
<%}
else{
        response.sendRedirect("paginaPrincipal.jsp");
    }
%>
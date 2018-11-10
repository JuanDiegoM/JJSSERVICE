<%-- 
    Document   : editarUsuario
    Created on : 2/09/2018, 09:26:38 AM
    Author     : Diego
--%>

<%
    HttpSession misession = (HttpSession) request.getSession();
    Usuario usuario = (Usuario) misession.getAttribute("usuarios");
    if (usuario.getIdTipoUsuario() == 1) {

%>

<%@page import="java.sql.*"%>
<%@page import="modelo.Database"%>
<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="head.jsp"></jsp:include>
            <script src="boostrap/js/usuarios.js" type="text/javascript"></script>
            <link href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet" />
        </head>
        <body>
        <jsp:include page="index.jsp"></jsp:include>
            <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js" ></script>
            <script src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
            <br><br>

        <%            Database con = new Database();
            PreparedStatement pst = null;
            ResultSet rs = null;

            PreparedStatement pstEdit = null;
            ResultSet rsEdit = null;

            int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));

            String sqlEdit = "select * from usuar where idUsuario = ?";
            pstEdit = con.getConnection().prepareStatement(sqlEdit);
            pstEdit.setInt(1, idUsuario);
            rsEdit = pstEdit.executeQuery();

            while (rsEdit.next()) {

        %>
        <div class = "row">
            <div class = "col-md-10 col-md-offset-1">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Editar Usuario</h3>
                    </div>
                    <div class="panel-body">
                        <form action="" method="post" id="formEditarUsuario">
                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-5">
                                        <label>Nombre Usuario</label>
                                        <input type="text" class="form-control" name="nombreUsuarioEdit" id="nombreUsuarioEdit" value="<%=rsEdit.getString(2)%>">
                                        <input type="hidden" class="form-control" name="idUsuario" id="idUsuario" value="<%=rsEdit.getString(1)%>">
                                    </div>

                                    <div class="col-md-5">
                                        <label>Tipo de usuario</label>
                                        <select class="form-control" id="tipoUsuarioEdit" name="tipoUsuarioEdit">
                                            <!--option  value="<--%=rsEdit.getInt(4)%>"></option-->
                                            <%
                                                try {

                                                    String sql = "select * from tipoUsuario";
                                                    pst = con.getConnection().prepareStatement(sql);
                                                    rs = pst.executeQuery();

                                                    while (rs.next()) {

                                                        if (rsEdit.getInt(4) == (int) rs.getInt(1)) {


                                            %>

                                            <option value="<%=rs.getInt(1)%>" selected="true"><%=rs.getString(2)%></option>

                                            <%} else {%>
                                            <option value="<%=rs.getInt(1)%>"><%=rs.getString(2)%></option>

                                            <%}
                                                    }

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
                                        <input type="password" name="passEdit" id="passEdit" class="form-control" onchange="limpiarCampos()">
                                    </div>
                                    <div class="col-md-5">
                                        <label>Repita Contraseña</label>
                                        <input type="password" name="passRepEdit" id="passRepEdit" class="form-control">
                                    </div>

                                </div>
                            </div>
                            <div class="row">
                                <div class="form-group">                                    
                                    <div class="col-md-5">
                                        <br>
                                        <input type="button" class="btn btn-success" value="Guardar" id="guardarEditarUsuario">
                                        <a href="usuarios.jsp" class="btn btn-success">Cancelar</a>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>
        <%
            }
            pst.close();
            rs.close();
            con.getConnection().close();
        %>

    </body>
</html>
<%
    } else {
        response.sendRedirect("paginaPrincipal.jsp");
    }
%>

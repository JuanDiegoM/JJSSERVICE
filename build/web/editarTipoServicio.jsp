<%-- 
    Document   : editarTipoServicio
    Created on : 7/09/2018, 07:42:57 PM
    Author     : Diego
--%>
<%@page import="java.sql.*"%>
<%@page import="modelo.Database"%>
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
        <title>JSP Page</title>
        <script src="boostrap/js/tipoServicioVehiculo.js" type="text/javascript"></script>
        <jsp:include page="head.jsp"></jsp:include>
    </head>
    <body>
        <jsp:include page="index.jsp"></jsp:include>
        <br><br>
        <div class = "row">
            <div class = "col-md-10 col-md-offset-1">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Editar Tipo De Servicio</h3>
                    </div>
                     <%
                        Database con = new Database();
                        PreparedStatement pst = null;
                        ResultSet rs = null;

                        int idTipoServicio = Integer.parseInt(request.getParameter("idTipoServicio"));

                        String sql = "select * from tipoServicio where idTipoServicio = ?";
                        pst = con.getConnection().prepareStatement(sql);
                        pst.setInt(1, idTipoServicio);
                        rs = pst.executeQuery();

                        while (rs.next()) {

                    %>

                    <div class="panel-body">
                        <form action="operacionesParametrizacion.jsp?idTipoServicio=<%= rs.getString(1)%>" method="post" id="formEditarTipoServicio">
                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-5">
                                        <label>Tipo de Servicio</label>
                                        <input type="text" class="form-control" value="<%= rs.getString(2)%>" id="tipoServicioEdit" name="tipoServicioEdit">
                                    </div>                                    
                                </div>
                            </div>
                            <br>

                            <div class="row">
                                <div class="form-group">                                    
                                    <div class="col-md-5">
                                        <br>
                                        <input type="submit" class="btn btn-success" value="Guardar" name="guardarEditarTipoServicio">
                                        <a href="tipoServicios.jsp" class="btn btn-success">Cancelar</a>
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
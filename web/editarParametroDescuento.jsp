<%-- 
    Document   : nuevoUsuario
    Created on : 2/09/2018, 12:35:25 PM
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
        <title>Editar Parámetro Descuento</title>
        <jsp:include page="head.jsp"></jsp:include>
    </head>
    <body>
        <jsp:include page="index.jsp"></jsp:include>
        <br><br>
        <div class = "row">
            <div class = "col-md-10 col-md-offset-1">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">Editar Parámetro Descuento</h3>
                        
                        <%
                        Database con = new Database();
                        PreparedStatement pst = null;
                        ResultSet rs = null;

                        int idParametroDescuento = Integer.parseInt(request.getParameter("idParametroDescuento"));

                        String sql = "select * from descuento where iddescuento = ?";
                        pst = con.getConnection().prepareStatement(sql);
                        pst.setInt(1, idParametroDescuento);
                        rs = pst.executeQuery();

                        while (rs.next()) {

                    %>
                    
                    </div>

                    <div class="panel-body">
                        <form action="operacionesParametrizacion.jsp?idParametroDescuento=<%= rs.getString(1)%>" method="post" id="formEditarParametroDescuento">
                            <div class="row">
                                <div class="form-group">
                                    <div class="col-md-5">
                                        <label>Descripción</label>
                                        <input type="text" class="form-control" value="<%= rs.getString(2)%>" id="parametroDescuentoEdit" name="parametroDescuentoEdit" required="true">
                                    </div>
                                    
                                    <div class="col-md-5">
                                        <label>Porcentaje</label>
                                        <input type="number" class="form-control" value="<%= rs.getString(3)%>" id="porcentajeDescuentoEdit" name="porcentajeDescuentoEdit" required="true">
                                    </div>
                                    
                                </div>
                            </div>
                            <br>

                            <div class="row">
                                <div class="form-group">                                    
                                    <div class="col-md-5">
                                        <br>
                                        <input type="submit" class="btn btn-success" value="Guardar" name="guardarEditarParametroDescuento">
                                        <a href="parametroDescuentos.jsp" class="btn btn-success">Cancelar</a>
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

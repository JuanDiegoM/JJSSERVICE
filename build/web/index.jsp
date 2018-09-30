<%-- 
    Document   : nuevoServicio
    Created on : 30/08/2018, 06:58:02 PM
    Author     : Diego
--%>

<%@page import="modelo.Usuario"%>

        <%
            HttpSession misession = (HttpSession) request.getSession();
            Usuario usuario = (Usuario) misession.getAttribute("usuarios");
        %>
        
        <nav class="navbar navbar-light" style="background-color: #696d6b;">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="paginaPrincipal.jsp"><label style="color: black;">JJS Service</label></a><br>
                    
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <br>
                    <ul class="nav navbar-nav">
                        <%
                            
                            if (usuario.getIdTipoUsuario() == 1) {

                        %>
                        <div class="col-md-4">                        
                            <li class="dropdown active">
                                <a href="#" class="dropdown-toggle btn btn-primary" style="width: 150px;" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Servicios <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="nuevoServicio.jsp" target="_self">Nuevo Servicio</a></li>
                                    <li><a href="listarServicios.jsp" target="_self">Listar Servicios</a></li>
                                </ul>
                            </li>
                        </div>
                        <%} else {%>
                        <div class="col-md-6">                        
                            <li class="dropdown active">
                                <a href="#" class="dropdown-toggle btn btn-primary" style="width: 150px;" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Servicios <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="nuevoServicio.jsp" target="_self">Nuevo Servicio</a></li>
                                    <li><a href="listarServicios.jsp" target="_self">Listar Servicios</a></li>
                                </ul>
                            </li>
                        </div>
                        <%}%>
                        <%

                            if (usuario.getIdTipoUsuario() == 1) {

                        %>
                        <div class="col-md-4"> 
                            <li class="dropdown active">
                                <a href="#" class="dropdown-toggle btn btn-primary" style="width: 150px;" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Reportes <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="nuevoReporte.jsp" target="_self">Nuevo Reporte</a></li>
                                    <li><a href="listarReportes.jsp" target="_self">Listar Reportes</a></li>
                                </ul>
                            </li>
                        </div>
                        <%} else {

                        %>
                        <div class="col-md-6"> 
                            <li class="dropdown active">
                                <a href="#" class="dropdown-toggle btn btn-primary" style="width: 150px;" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Informes <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="nuevoReporte.jsp" target="_self">Nuevo Informe</a></li>
                                    <li><a href="listarReportes.jsp" target="_self">Listar Informes</a></li>
                                </ul>
                            </li>
                        </div>
                        <%}%>

                        <%

                            if (usuario.getIdTipoUsuario() == 1) {

                        %>
                        <div class="col-md-4">

                            <li class="dropdown active">
                                <a href="#" class="dropdown-toggle btn btn-primary" style="width: 150px;" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Configuración <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="usuarios.jsp" target="_self">Usuario</a></li>
                                    <li><a href="tipoUsuario.jsp" target="_self">Tipo de usuario</a></li>
                                    <li><a href="tipoServicios.jsp" target="_self">Tipo de servicio</a></li>
                                    <li><a href="tipoVehiculos.jsp" target="_self">Tipo de vehiculo</a></li>
                                    <li><a href="parametroCostoServicios.jsp" target="_self">Parametrización costo servicios</a></li>
                                    <li><a href="parametroDescuentos.jsp" target="_self">Parametrización descuentos</a></li>
                                </ul>
                            </li>

                        </div>
                        <%}%>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">

                        <div class="col-md-6">

                            <li class="dropdown active">
                                <a href="#" class="dropdown-toggle btn btn-primary"
                                   data-toggle="dropdown" role="button" aria-haspopup="true" style="width: 150px;" 
                                        aria-expanded="false"><span class="glyphicon glyphicon-user" aria-hidden="true">
                                       <% out.println(usuario.getNombre()); %>
                                    </span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="login.jsp">Cerrar sesión</a></li>
                                </ul>
                            </li>
                        </div>

                    </ul>

                </div><!-- /.navbar-collapse -->
                <br>
            </div><!-- /.container-fluid -->
        </nav>

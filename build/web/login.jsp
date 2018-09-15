<%-- 
    Document   : login
    Created on : 31/08/2018, 04:23:20 PM
    Author     : Diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="boostrap/js/jquery.js" type="text/javascript"></script>
        <link href="boostrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="boostrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="boostrap/js/usuarios.js" type="text/javascript"></script>
        
    </head>
    <body>       
        <br><br><br><br>
        <div class = "row">
            <div class = "col-md-10 col-md-offset-1">
                <div class="panel panel-success">
                    <div class="panel-heading">
                        <center><h1 class="panel-title">Inicio de sesión</h1></center>
                    </div>
                    <form action="controladorUsuarios" method="post" id="formularioLogin">
                        <div class="panel-body">
                            <div class="form-group">                                    
                                <div class="col-md-5">
                                    <label>Nombre de usuario</label>
                                    <input type="text" name="nombre" id="nombre" class="form-control">
                                </div>
                                <div class="col-md-5">
                                    <label>Contraseña</label>
                                    <input type="password" name="pass" id="contraseña" class="form-control">
                                </div>
                            </div>
                            <div class="col-md-5">
                                <br>
                                <input type="submit" class="btn btn-primary" name="loginUsuario">
                            </div>
                        </div>
                    </form>

                </div>
            </div>
        </div>

    </body>
</html>

<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.IOException"%>
<%@page import="java.sql.SQLException"%>
<%@page import="uml.DaoUsuario"%>
<%@page import="uml.DaoTipoUsuario"%>

<% PrintWriter pt = response.getWriter(); %>

<%
    if (request.getParameter("guardarNuevoTipoUsuario") != null) {
        try {
            String tipoUsuario = request.getParameter("tipoUsuarioNew");
            DaoTipoUsuario daoTu = new DaoTipoUsuario();
            if (daoTu.registrarTipoUsuario(tipoUsuario)) {

                pt.println("<script type=\"text/javascript\">");
                pt.println("alert('Nuevo tipo de usuario guardado');");
                pt.println("location='tipoUsuario.jsp';");
                pt.println("</script>");

            } else {

                pt.println("<script type=\"text/javascript\">");
                pt.println("alert('Error al tratar de guardar el tipo de usuario');");
                pt.println("location='nuevoTipoUsuario.jsp';");
                pt.println("</script>");

            }
        } catch (Exception e) {
        }

    }%>

<%
    if (request.getParameter("guardarEditarUsuario") != null) {

        String passEdit = request.getParameter("passEdit");
        String passRep = request.getParameter("passRepEdit");
        String nombreUsuario = request.getParameter("nombreUsuarioEdit");
        int idTipoUsuarioEdit = Integer.parseInt(request.getParameter("tipoUsuarioEdit"));
        int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));

        if (passEdit == "" && passRep == "") {
            DaoUsuario du = new DaoUsuario();
            if (du.editarUsuarioSinPassw(idUsuario, nombreUsuario, idTipoUsuarioEdit)) {

                pt.println("<script type=\"text/javascript\">");
                pt.println("alert('Usuario editado');");
                pt.println("location='usuarios.jsp';");
                pt.println("</script>");

            } else {

                pt.println("<script type=\"text/javascript\">");
                pt.println("alert('Error al tratar de editar el usuario');");
                pt.println("location='editarUsuario.jsp';");
                pt.println("</script>");
            }
        } else {
            DaoUsuario du = new DaoUsuario();
            if (du.editarUsuario(idUsuario, nombreUsuario, passEdit, idTipoUsuarioEdit)) {
                pt.println("<script type=\"text/javascript\">");
                pt.println("alert('Usuario editado');");
                pt.println("location='usuarios.jsp';");
                pt.println("</script>");
            } else {
                pt.println("<script type=\"text/javascript\">");
                pt.println("alert('Error al tratar de editar el usuario');");
                pt.println("location='editarUsuario.jsp';");
                pt.println("</script>");
            }
        }
    }
%>


<%
    if (request.getParameter("btnEliminarTipoUsuario") != null) {
        try {
            int idTipoUsuario = Integer.parseInt(request.getParameter("btnEliminarTipoUsuario"));
            DaoTipoUsuario daoTu = new DaoTipoUsuario();
            if (daoTu.eliminarTipoUsuario(idTipoUsuario)) {
                pt.println("<script type=\"text/javascript\">");                
                pt.println("toastr.success('Tipo de usuario eliminado');");
                //pt.println("alert('Tipo de usuario eliminado');");
                pt.println("location='tipoUsuario.jsp';");
                pt.println("</script>");

            } else {
                pt.println("<script type=\"text/javascript\">");
                pt.println("toastr.success('No se puede eliminar el tipo de usuario por que esta relacionado con un usuario');");
                //pt.println("alert('No se puede eliminar el tipo de usuario por que esta relacionado con un usuario');");
                pt.println("location='tipoUsuario.jsp';");
                pt.println("</script>");
            }
        } catch (Exception e) {
        }

    }
%>


<%
    if (request.getParameter("guardarEditarTipoUsuario") != null) {

        int idTipoUsuario = Integer.parseInt(request.getParameter("idTipoUsuario"));
        String tipoUsuario = request.getParameter("tipoUsuarioEdit");
        DaoTipoUsuario daoTu = new DaoTipoUsuario();
        if (daoTu.editarTipoUsuario(idTipoUsuario, tipoUsuario)) {
            pt.println("<script type=\"text/javascript\">");
            pt.println("alert('Tipo de usuario editado');");
            pt.println("location='tipoUsuario.jsp';");
            pt.println("</script>");
        } else {
            pt.println("<script type=\"text/javascript\">");
            pt.println("alert('Error al tratar de editar el tipo de usuario');");
            pt.println("location='editarTipoUsuario.jsp';");
            pt.println("</script>");
        }
    }
%>

<%
    if (request.getParameter("guardarNuevoUsuario") != null) {

        String nombreUsuario = request.getParameter("nombreUsuarioNew");
        int idTipoUsuario = Integer.parseInt(request.getParameter("tipoUsuarioNew"));
        String password = request.getParameter("passNew");
        try {
            DaoUsuario du = new DaoUsuario();
            if (du.registrarUsuario(nombreUsuario, password, idTipoUsuario)) {

                pt.println("<script type=\"text/javascript\">");
                pt.println("alert('Usuario creado');");
                pt.println("location='usuarios.jsp';");
                pt.println("</script>");
            } else {
                
                pt.println("<script type=\"text/javascript\">");
                pt.println("alert('Error al tratar de crear el usuario');");
                pt.println("location='nuevoUsuario.jsp';");
                pt.println("</script>");
                
            }
        }catch (SQLException e) {
        }
    }
%>

<%
    if (request.getParameter("btnEliminarUsuario") != null) {
        int idUsuario = Integer.parseInt(request.getParameter("btnEliminarUsuario"));
        DaoUsuario du = new DaoUsuario();
        try {
            if (du.eliminarUsuario(idUsuario)) {
                pt.println("<script type=\"text/javascript\">");
                pt.println("alert('Usuario eliminado');");
                pt.println("location='usuarios.jsp';");
                pt.println("</script>");
            } else {
                pt.println("<script type=\"text/javascript\">");
                pt.println("alert('No se pudo eliminar el usuario');");
                pt.println("location='usuarios.jsp';");
                pt.println("</script>");
            }
        } catch (SQLException ex) {

        }
    }
%>
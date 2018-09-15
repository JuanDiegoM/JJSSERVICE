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

            }
            else{
                
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
            }
        }
    }
%>


<%
    if (request.getParameter("btnEliminarTipoUsuario") != null) {
        try {
            int idTipoUsuario = Integer.parseInt(request.getParameter("btnEliminarTipoUsuario"));
            DaoTipoUsuario daoTu = new DaoTipoUsuario();
            if (daoTu.eliminarTipoUsuario(idTipoUsuario)) {%>

<script>
    aletr("Tipo de usuario Eliminado");
</script>

<%
            out.println("<script> alert('Usuario o Contraseña incorrectos'); </script>");
                response.sendRedirect("tipoUsuario.jsp");
            } else {
                response.sendRedirect("tipoUsuario.jsp");
            }
        } catch (Exception e) {
        }

    }%>


<%
    if (request.getParameter("guardarEditarTipoUsuario") != null) {

        int idTipoUsuario = Integer.parseInt(request.getParameter("idTipoUsuario"));
        String tipoUsuario = request.getParameter("tipoUsuarioEdit");
        DaoTipoUsuario daoTu = new DaoTipoUsuario();
        if(daoTu.editarTipoUsuario(idTipoUsuario, tipoUsuario)){
            System.out.println("Tipo de usuario editado");
            response.sendRedirect("tipoUsuario.jsp");
        }else{
            System.out.println("No edito el tipo de usuario");
            response.sendRedirect("editarTipoUsuario.jsp");
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
                    
                    out.println("<script> alert('Hi'); </script>");
                    RequestDispatcher vista = request.getRequestDispatcher("usuarios.jsp");
                    vista.forward(request, response);
                } else {
                    RequestDispatcher vista = request.getRequestDispatcher("nuevoUsuario.jsp");
                    vista.forward(request, response);
                }
            } catch (IOException | SQLException | ServletException e) {
            }
        }
%>

<%
    if (request.getParameter("btnEliminarUsuario") != null) {
        int idUsuario = Integer.parseInt(request.getParameter("btnEliminarUsuario"));
        DaoUsuario du = new DaoUsuario();
        try {
            if (du.eliminarUsuario(idUsuario)) {
                System.out.println("Eliminado");
                RequestDispatcher vista = request.getRequestDispatcher("usuarios.jsp");
                vista.forward(request, response);
            }
        } catch (SQLException ex) {
            
        }
    }
%>
    </body>
</html>

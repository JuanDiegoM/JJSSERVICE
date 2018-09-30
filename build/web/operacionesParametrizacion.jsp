<%-- 
    Document   : operacionesParametrizacion
    Created on : 5/09/2018, 05:59:44 PM
    Author     : Diego
--%>
<%@page import="uml.DaoDescuento"%>
<%@page import="uml.DaoTipoServicioVehiculo"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="uml.DaoTipoVehiculo"%>
<%@page import="java.sql.SQLException"%>
<%@page import="uml.DaoTipoServicio"%>

<% PrintWriter pt = response.getWriter(); %>

<%

    if (request.getParameter("guardarNuevoTipoServicio") != null) {
        String tipoServicio = request.getParameter("tipoServicioNew");
        DaoTipoServicio daoTs = new DaoTipoServicio();
        if (daoTs.registrarTiposervicio(tipoServicio)) {

            pt.println("<script type=\"text/javascript\">");
            pt.println("alert('Tipo de servicio guardado');");
            pt.println("location='tipoServicios.jsp';");
            pt.println("</script>");

        } else {

            pt.println("<script type=\"text/javascript\">");
            pt.println("alert('Error al tratar de guardar el tipo de servicio');");
            pt.println("location='nuevoTipoServicio.jsp';");
            pt.println("</script>");

        }

    }
%>

<%
    if (request.getParameter("guardarEditarTipoServicio") != null) {

        String tipoServicio = request.getParameter("tipoServicioEdit");
        int idTipoServicio = Integer.parseInt(request.getParameter("idTipoServicio"));
        DaoTipoServicio daoTs = new DaoTipoServicio();
        if (daoTs.editarTipoServicio(idTipoServicio, tipoServicio)) {

            pt.println("<script type=\"text/javascript\">");
            pt.println("alert('Tipo de servicio editado');");
            pt.println("location='tipoServicios.jsp';");
            pt.println("</script>");

        } else {

            pt.println("<script type=\"text/javascript\">");
            pt.println("alert('Error al tratar de editar el tipo de servicio');");
            pt.println("location='editarTipoServicio.jsp';");
            pt.println("</script>");
        }
    }
%>

<%
    if (request.getParameter("guardarEditarTipoVehiculo") != null) {

        String tipoVehiculo = request.getParameter("tipoVehiculoEdit");
        int idTipoVehiculo = Integer.parseInt(request.getParameter("idTipoVehiculo"));
        DaoTipoVehiculo daoTv = new DaoTipoVehiculo();
        if (daoTv.editarTipoVehiculo(idTipoVehiculo, tipoVehiculo)) {

            pt.println("<script type=\"text/javascript\">");
            pt.println("alert('Tipo de vehículo editado');");
            pt.println("location='tipoVehiculos.jsp';");
            pt.println("</script>");

        } else {
            pt.println("<script type=\"text/javascript\">");
            pt.println("alert('Error al tratar de editar el tipo de vehiculo');");
            pt.println("location='editarTipoVehiculo.jsp';");
            pt.println("</script>");
        }
    }
%>

<%
    if (request.getParameter("btnEliminarTipoServicio") != null) {
        int idTipoServicio = Integer.parseInt(request.getParameter("btnEliminarTipoServicio"));
        DaoTipoServicio daoTs = new DaoTipoServicio();
        try {
            if (daoTs.eliminarTipoServicio(idTipoServicio)) {
                
                pt.println("<script type=\"text/javascript\">");
                pt.println("alert('Tipo de servicio eliminado');");
                pt.println("location='tipoServicios.jsp';");
                pt.println("</script>");
            }else{
                 pt.println("<script type=\"text/javascript\">");
                pt.println("alert('No se puede eliminar el tipo de servicio');");
                pt.println("location='tipoServicios.jsp';");
                pt.println("</script>");
            }
        } catch (SQLException ex) {

        }
    }
%>

<%
    if (request.getParameter("btnEliminarTipoVehiculo") != null) {
        int idTipoVehiculo = Integer.parseInt(request.getParameter("btnEliminarTipoVehiculo"));
        DaoTipoVehiculo daoTv = new DaoTipoVehiculo();
        try {
            if (daoTv.eliminarTipoVehiculo(idTipoVehiculo)) {
                
                pt.println("<script type=\"text/javascript\">");
                pt.println("alert('Tipo de vehículo eliminado');");
                pt.println("location='tipoVehiculos.jsp';");
                pt.println("</script>");
            }
        } catch (SQLException ex) {

        }
    }
%>



<%
    if (request.getParameter("guardarNuevoTipoVehiculo") != null) {
        String tipoVehiculo = request.getParameter("tipoVehiculoNew");
        DaoTipoVehiculo daoTv = new DaoTipoVehiculo();
        if (daoTv.registrarTipoVehiculo(tipoVehiculo)) {
            
                pt.println("<script type=\"text/javascript\">");
                pt.println("alert('Tipo de vehículo guardado');");
                pt.println("location='tipoVehiculos.jsp';");
                pt.println("</script>");

        } else {
            
                pt.println("<script type=\"text/javascript\">");
                pt.println("alert('Error al tratar de guardar el tipo de vehículo');");
                pt.println("location='nuevoTipoVehiculo.jsp';");
                pt.println("</script>");
            
        }
    }
%>

<%
    if (request.getParameter("guardarNuevoCostoServicio") != null) {
        int idTipoVehiculo = Integer.parseInt(request.getParameter("parametroTipoVehiculonew"));
        int idTipoServicio = Integer.parseInt(request.getParameter("parametroServicionew"));
        double valorServicio = Double.parseDouble(request.getParameter("parametroValorServicio"));
        DaoTipoServicioVehiculo daoTsv = new DaoTipoServicioVehiculo();

        try {
            if (daoTsv.registrarTiposervicioVehiculo(idTipoServicio, idTipoVehiculo, valorServicio)) {
                
                pt.println("<script type=\"text/javascript\">");
                pt.println("alert('Nuevo parámetro de costo guardado');");
                pt.println("location='parametroCostoServicios.jsp';");
                pt.println("</script>");
          
            } else {
                
                pt.println("<script type=\"text/javascript\">");
                pt.println("alert('Error al tratar de guardar parámetro de costo');");
                pt.println("location='nuevoCostoServicio.jsp';");
                pt.println("</script>");
            }
        } catch (SQLException ex) {

        }

    }
%>

<%

    if (request.getParameter("guardarNuevoParametroDescuento") != null) {
        String descripcion = request.getParameter("parametroDescuentoNew");
        int porcentajeDescuento = Integer.parseInt(request.getParameter("porcentajeDescuentoNew"));
        DaoDescuento Dd = new DaoDescuento();
        if (Dd.registrarParametroDescuento(descripcion, porcentajeDescuento)){

            pt.println("<script type=\"text/javascript\">");
            pt.println("alert('Parametro de descuento guardado');");
            pt.println("location='parametroDescuentos.jsp';");
            pt.println("</script>");

        } else {

            pt.println("<script type=\"text/javascript\">");
            pt.println("alert('Error al tratar de guardar el parametro de descuento');");
            pt.println("location='nuevoParametroDescuento.jsp';");
            pt.println("</script>");

        }

    }
%>

<%
    if (request.getParameter("btnEliminarParametroDescuento") != null) {
        int idParametroDescuento = Integer.parseInt(request.getParameter("btnEliminarParametroDescuento"));
        DaoDescuento Dd = new DaoDescuento();
        try {
            if (Dd.eliminarParametroDescuento(idParametroDescuento)) {
                
                pt.println("<script type=\"text/javascript\">");
                pt.println("alert('Parámetro de descuento eliminado');");
                pt.println("location='parametroDescuentos.jsp';");
                pt.println("</script>");
            }
        } catch (SQLException ex) {

        }
    }
%>

<%
    if (request.getParameter("guardarEditarParametroDescuento") != null) {

        String descripcion = request.getParameter("parametroDescuentoEdit");
        int idParametroDescuento = Integer.parseInt(request.getParameter("idParametroDescuento"));
        int porcentajeDescuento = Integer.parseInt(request.getParameter("porcentajeDescuentoEdit"));
        DaoDescuento Dd = new DaoDescuento();
        if (Dd.editarPorcentajeDescuento(idParametroDescuento, descripcion, porcentajeDescuento)) {

            pt.println("<script type=\"text/javascript\">");
            pt.println("alert('Parámetro de descuento editado');");
            pt.println("location='parametroDescuentos.jsp';");
            pt.println("</script>");

        } else {
            pt.println("<script type=\"text/javascript\">");
            pt.println("alert('Error al tratar de editar el tipo de vehiculo');");
            pt.println("location='editarParametroDescuento.jsp';");
            pt.println("</script>");
        }
    }
%>

<%
    if (request.getParameter("guardarEditarCostoServicio") != null) {

        int idTipoServicioVehiculo = Integer.parseInt(request.getParameter("idTipoServicioVehiculo"));
        int idTipoServicio = Integer.parseInt(request.getParameter("parametroServicioEdit"));
        int idTipoVehiculo = Integer.parseInt(request.getParameter("parametroTipoVehiculoEdit"));
        double valorServicio = Double.parseDouble(request.getParameter("parametroValorServicioEdit"));
        DaoTipoServicioVehiculo daoTsv = new DaoTipoServicioVehiculo();
        if (daoTsv.editarTipoServicioVehiculo(idTipoServicioVehiculo, idTipoVehiculo, idTipoServicio, valorServicio)) {

            pt.println("<script type=\"text/javascript\">");
            pt.println("alert('Costo de servicio editado');");
            pt.println("location='parametroCostoServicios.jsp';");
            pt.println("</script>");

        } else {

            pt.println("<script type=\"text/javascript\">");
            pt.println("alert('Error al tratar de editar el costo del servicio');");
            pt.println("location='editarCostoServicio.jsp';");
            pt.println("</script>");
        }
    }
%>

<%
    if (request.getParameter("btnEliminarTipoServicioVehiculo") != null) {
        int idTipoServicioVehiculo = Integer.parseInt(request.getParameter("btnEliminarTipoServicioVehiculo"));
        DaoTipoServicioVehiculo daoTsv = new DaoTipoServicioVehiculo();
        try {
            if(daoTsv.eliminarTipoServicioVehiculo(idTipoServicioVehiculo)) {
                
                pt.println("<script type=\"text/javascript\">");
                pt.println("alert('Costo de servicio eliminado');");
                pt.println("location='parametroCostoServicios.jsp';");
                pt.println("</script>");
            }
        } catch (SQLException ex) {

        }
    }
%>

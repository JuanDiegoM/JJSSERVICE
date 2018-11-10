/* global toastr */

$(document).ready(function () {

    $("#guardarNuevoTipoServicio").click(function () {

        if ($("#tipoServicioNew").val() === "") {

            $("#tipoServicioNew").css('background', 'red');
            alert("Los Campos pintados de rojo son obligatorios");

            return false;
        } else {

            $.post('operacionesTipoServicioTipoVehiculo?opcion=guardarTipoServicio', {
                tipoServicioNew: $("#tipoServicioNew").val()
            }, function (responseText) {
                if (responseText != "true") {
                    if (responseText[0] == "t") {
                        toastr.success("Tipo de servicio creado");
                        setTimeout("location.href='tipoServicios.jsp'", 1000);

                    } else {
                        toastr.error("No se puede crear el tipo de servicio");
                        setTimeout('document.location.reload()', 1000);
                    }
                } else {
                    toastr.error("Error Interno");
                    location.reload();
                }
            });
        }

    });

    $("#guardarEditarTipoServicio").click(function () {
        if ($("#tipoServicioEdit").val() === "") {

            $("#tipoServicioEdit").css('background', 'red');
            alert("Los Campos pintados de rojo son obligatorios");

            return false;
        } else {
            $.post('operacionesTipoServicioTipoVehiculo?opcion=editarTipoServicio', {
                tipoServicioEdit: $("#tipoServicioEdit").val(),
                idTipoServicio: $("#idTipoServicio").val()
            }, function (responseText) {
                if (responseText != "true") {
                    if (responseText[0] == "t") {
                        toastr.success("Tipo de servicio editado");
                        setTimeout("location.href='tipoServicios.jsp'", 1000);

                    } else {
                        toastr.error("No se puede editar el tipo de servicio");
                        setTimeout('document.location.reload()', 1000);
                    }
                } else {
                    toastr.error("Error Interno");
                    location.reload();
                }
            });

        }
    });

    $("#formularioTipoServicio").submit(function () {

        var resul = confirm('¿Esta seguro que desea eliminar el registro?');
        if (resul === true)
        {
            return true;
        } else {

            return false;
        }
    });

    (function ($) {
        $('#filtrar').keyup(function () {

            var rex = new RegExp($(this).val(), 'i');
            $('.buscar tr').hide();
            $('.buscar tr').filter(function () {
                return rex.test($(this).text());
            }).show();

        });

    }(jQuery));

});

function borrarTipoServicio(idTipoServicio) {

    var resul = confirm('¿Esta seguro que desea eliminar el registro?');
    if (resul === true)
    {
        $.post('operacionesTipoServicioTipoVehiculo?opcion=eliminarTipoServicio', {
            idTipoServicio: idTipoServicio
        }, function (responseText) {
            if (responseText != "true") {
                if (responseText[0] == "t") {
                    toastr.success("Tipo de servicio eliminado");
                    setTimeout('document.location.reload()', 1000);

                } else {
                    toastr.error("No se puede eliminar el tipo de servicio");
                }
            } else {
                toastr.error("Error Interno");
                location.reload();
            }
        });
    } else {

        return false;
    }
}



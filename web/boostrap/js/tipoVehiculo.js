/* global toastr */

$(document).ready(function () {

    $("#guardarNuevoTipoVehiculo").click(function () {

        if ($("#tipoVehiculoNew").val() === "") {

            $("#tipoVehiculoNew").css('background', 'red');
            alert("Los Campos pintados de rojo son obligatorios");
            return false;
        } else {
            $.post('operacionesTipoServicioTipoVehiculo?opcion=guardarTipoVehiculo', {
                tipoVehiculoNew: $("#tipoVehiculoNew").val()
            }, function (responseText) {
                if (responseText != "true") {
                    if (responseText[0] == "t") {
                        toastr.success("Tipo de vehículo creado");
                        setTimeout("location.href='tipoVehiculos.jsp'", 1000);

                    } else {
                        toastr.error("Error al tratar de crear el tipo de vehículo");
                        location.reload();
                    }
                } else {
                    toastr.error("Error Interno");
                    location.reload();
                }
            });

        }

    });

    $("#guardarEditarTipoVehiculo").click(function () {

        if ($("#tipoVehiculoEdit").val() === "") {

            $("#tipoVehiculoEdit").css('background', 'red');
            alert("Los Campos pintados de rojo son obligatorios");
            return false;
        } else {
            $.post('operacionesTipoServicioTipoVehiculo?opcion=editarTipoVehiculo', {
                tipoVehiculoEdit: $("#tipoVehiculoEdit").val(),
                idTipoVehiculo: $("#idTipoVehiculo").val()
            }, function (responseText) {
                if (responseText != "true") {
                    if (responseText[0] == "t") {
                        toastr.success("Tipo de vehículo editado");
                        setTimeout("location.href='tipoVehiculos.jsp'", 1000);

                    } else {
                        toastr.error("Error al tratar de editar el tipo de vehículo");
                        location.reload();
                    }
                } else {
                    toastr.error("Error Interno");
                    location.reload();
                }
            });
        }

    });

    $("#formularioTipoVehiculo").submit(function () {

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

function borrarTipoVehiculo(idTipoVehiculo) {

    var resul = confirm('¿Esta seguro que desea eliminar el registro?');
    if (resul === true) {

        $.post('operacionesTipoServicioTipoVehiculo?opcion=eliminarTipoVehiculo', {
            idTipoVehiculo: idTipoVehiculo
        }, function (responseText) {
            if (responseText != "true") {
                if (responseText[0] == "t") {
                    toastr.success("Tipo de vehículo eliminado");
                    setTimeout('document.location.reload()', 1000);

                } else {
                    toastr.error("No se puede eliminar el tipo de vehículo");
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



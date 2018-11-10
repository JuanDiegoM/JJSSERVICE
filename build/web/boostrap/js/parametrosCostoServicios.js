/* global toastr */

$(document).ready(function () {

    $("#guardarNuevoCostoServicio").click(function () {
        limpiarCampos();
        var contadorErrores = 0;
        if ($("#parametroValorServicio").val() === "") {
            contadorErrores++;
            $("#parametroValorServicio").css('background', 'red');
        }
        if ($("#parametroTipoVehiculonew").val() === null) {
            contadorErrores++;
            $("#parametroTipoVehiculonew").css('background', 'red');
        }
        if ($("#parametroServicionew").val() === null) {
            contadorErrores++;
            $("#parametroServicionew").css('background', 'red');
        }
        if (contadorErrores !== 0) {

            alert("Los Campos pintados de rojo son obligatorios");
            return false;
        } else {

            $.post('operacionesTipoServicioTipoVehiculo?opcion=guardarCostoServicio', {
                parametroTipoVehiculonew: $("#parametroTipoVehiculonew").val(),
                parametroServicionew: $("#parametroServicionew").val(),
                parametroValorServicio: $("#parametroValorServicio").val()
            }, function (responseText) {
                if (responseText != "true") {
                    if (responseText[0] == "t") {
                        toastr.success("Nuevo parámetro de costo guardado");
                        setTimeout("location.href='parametroCostoServicios.jsp'", 1000);

                    } else {
                        toastr.error("Error al tratar de guardar parámetro de costo");
                        setTimeout('document.location.reload()', 1000);
                    }
                } else {
                    toastr.error("Error Interno");
                    location.reload();
                }
            });
        }

    });

    $("#guardarEditarCostoServicio").click(function () {

        if ($("#parametroValorServicioEdit").val() === "") {
            $("#parametroValorServicioEdit").css('background', 'red');
            alert("Los Campos pintados de rojo son obligatorios");
        } else {
            $.post('operacionesTipoServicioTipoVehiculo?opcion=editarCostoServicio', {
                idTipoServicioVehiculo: $("#idTipoServicioVehiculo").val(),
                parametroServicioEdit: $("#parametroServicioEdit").val(),
                parametroTipoVehiculoEdit: $("#parametroTipoVehiculoEdit").val(),
                parametroValorServicioEdit: $("#parametroValorServicioEdit").val()
            }, function (responseText) {
                if (responseText != "true") {
                    if (responseText[0] == "t") {
                        toastr.success("Parámetro de costo editado");
                        setTimeout("location.href='parametroCostoServicios.jsp'", 1000);

                    } else {
                        toastr.error("Error al tratar de editar parámetro de costo");
                        setTimeout('document.location.reload()', 1000);
                    }
                } else {
                    toastr.error("Error Interno");
                    location.reload();
                }
            });

        }
    });

    $("#formularioDescuentos").submit(function () {

        var resul = confirm('¿Esta seguro que desea eliminar el registro?');
        if (resul === true)
        {
            return true;
        } else {

            return false;
        }
    });

    $("#formularioCostoServicio").submit(function () {

        var resul = confirm('¿Esta seguro que desea eliminar el registro?');
        if (resul === true)
        {
            return true;
        } else {

            return false;
        }
    });

    $("#guardarNuevoParametroDescuento").click(function () {
        var contadorErrores = 0;
        if ($("#parametroDescuentoNew").val() === "") {

            contadorErrores++;
            $("#parametroDescuentoNew").css('background', 'red');
        }

        if ($("#porcentajeDescuentoNew").val() === "") {

            contadorErrores++;
            $("#porcentajeDescuentoNew").css('background', 'red');
        }

        if (contadorErrores !== 0) {

            alert("Los Campos pintados de rojo son obligatorios");
            return false;
        } else {

            $.post('operacionesTipoServicioTipoVehiculo?opcion=guardarParametroDescuento', {
                parametroDescuentoNew: $("#parametroDescuentoNew").val(),
                porcentajeDescuentoNew: $("#porcentajeDescuentoNew").val()
                
            }, function (responseText) {
                if (responseText != "true") {
                    if (responseText[0] == "t") {
                        toastr.success("Parámetro de descuento creado");
                        setTimeout("location.href='parametroDescuentos.jsp'", 1000);

                    } else {
                        toastr.error("Error al tratar de crear parámetro de descuento");
                        setTimeout('document.location.reload()', 1000);
                    }
                } else {
                    toastr.error("Error Interno");
                    location.reload();
                }
            });
        }


    });
    
    $("#guardarEditarParametroDescuento").click(function () {
        var contadorErrores = 0;
        if ($("#parametroDescuentoEdit").val() === "") {

            contadorErrores++;
            $("#parametroDescuentoEdit").css('background', 'red');
        }

        if ($("#porcentajeDescuentoEdit").val() === "") {

            contadorErrores++;
            $("#porcentajeDescuentoEdit").css('background', 'red');
        }

        if (contadorErrores !== 0) {

            alert("Los Campos pintados de rojo son obligatorios");
            return false;
        } else {

            $.post('operacionesTipoServicioTipoVehiculo?opcion=editarParametroDescuento', {
                parametroDescuentoEdit: $("#parametroDescuentoEdit").val(),
                porcentajeDescuentoEdit: $("#porcentajeDescuentoEdit").val(),
                idParametroDescuento: $("#idParametroDescuento").val()
                
            }, function (responseText) {
                if (responseText != "true") {
                    if (responseText[0] == "t") {
                        toastr.success("Parámetro de descuento editado");
                        setTimeout("location.href='parametroDescuentos.jsp'", 1000);

                    } else {
                        toastr.error("Error al tratar de editar el parámetro de descuento");
                        setTimeout('document.location.reload()', 1000);
                    }
                } else {
                    toastr.error("Error Interno");
                    location.reload();
                }
            });
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

function limpiarCampos() {

    $("#parametroValorServicio").css('background', '');
    $("#parametroTipoVehiculonew").css('background', '');
    $("#parametroServicionew").css('background', '');
}

function borrarCostoServicio(idCostoServicio) {

    var resul = confirm('¿Esta seguro que desea eliminar el registro?');
    if (resul === true)
    {
        $.post('operacionesTipoServicioTipoVehiculo?opcion=eliminarCostoServicio', {
            idCostoServicio: idCostoServicio
        }, function (responseText) {
            if (responseText != "true") {
                if (responseText[0] == "t") {
                    toastr.success("Costo de servicio eliminado");
                    setTimeout('document.location.reload()', 1000);

                } else {
                    toastr.error("No se puede eliminar el Costo de servicio");
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

function borrarParametroDescuento(idParametroDescuento) {
    var resul = confirm('¿Esta seguro que desea eliminar el registro?');
    if (resul === true)
    {
        $.post('operacionesTipoServicioTipoVehiculo?opcion=eliminarParametrodescuento', {
            idParametroDescuento: idParametroDescuento
        }, function (responseText) {
            if (responseText != "true") {
                if (responseText[0] == "t") {
                    toastr.success("Parámetro de descuento eliminado");
                    setTimeout('document.location.reload()', 1000);

                } else {
                    toastr.error("No se puede eliminar el parámetro de descuento");
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




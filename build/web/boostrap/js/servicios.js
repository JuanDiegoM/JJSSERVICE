/* global arrayTotales, arrayIdTipoServicios, toastr */

$(document).ready(function () {

    porcDescuento = 0;
    arrayTotales = [];
    arrayIdTipoServicios = [];
    contador = 0;
    $("#subtotal").val(0);
    $("#valorDescuento").val(0);
    $("#porcentajeDescuento").val(0);
    $("#totalServicio").val(0);

    $("#parametroTipoVehiculonew").change(function () {
        arrayTotales = [];
        arrayIdTipoServicios = [];
        $("#subtotal").val(0);
        $("#totalServicio").val(0);
        $("#valorDescuento").val(0);
        $("#porcentajeDescuento").val(0);
        contador = 0;
        var idTipoVehiculo = $("#parametroTipoVehiculonew").val();
        $.post('Services', {
            idTipoVehiculo: idTipoVehiculo
        }, function (responseText) {

            $('#tabla').html(responseText);
        });
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


function calcular(i) {

    if ($("#subtotal").val() === "" || $("#subtotal").val() === undefined) {
        var sumaSubtotal = 0;
    } else {
        var sumaSubtotal = parseFloat($("#subtotal").val());
    }

    if ($("#idTipoServicio" + i).prop("checked")) {
        var valorServicio = parseFloat($("#valorServicio" + i).val());
        var subtotal = parseFloat(valorServicio) + parseFloat(sumaSubtotal);
        $("#subtotal").val(subtotal);
        $("#totalServicio").val(subtotal);
        contador++;
        arrayTotales.push($("#valorServicio" + i).val());
        arrayIdTipoServicios.push($("#idTipoServicio" + i).val());
        $("#idTipoServicio").val(arrayIdTipoServicios);
        $("#valorServicio").val(arrayTotales);
        //alert(arrayIdTipoServicios);
        if (contador >= 4) {

            $.post('AplicarDescuento', {

            }, function (responseText) {
                $('#descuento').html(responseText);
                var valorDescuento = parseFloat($("#totalServicio").val()) * (parseFloat($("#porcentajeDescuento").val()) / 100);
                $("#valorDescuento").val(valorDescuento);
                var totalServicio = parseFloat($("#totalServicio").val()) - parseFloat(valorDescuento);
                $("#totalServicio").val(totalServicio);
                porcDescuento = $("#porcentajeDescuento").val();
            });
        } else {

            porcDescuento = 0;
        }

    } else {
        var valorServicio = parseFloat($("#valorServicio" + i).val());
        var subtotal = parseFloat(sumaSubtotal) - parseFloat(valorServicio);
        $("#subtotal").val(subtotal);
        $("#totalServicio").val(subtotal);
        contador--;
        $("#porcentajeDescuento").val(0);
        $("#valorDescuento").val(0);
        sacarValorServicioArray(arrayTotales, $("#valorServicio" + i).val());
        sacarIdTipoServicioArray(arrayIdTipoServicios, $("#idTipoServicio" + i).val());
    }
}

function sacarValorServicioArray(array, item) {

    arrayTotales = [];
    for (var i = 0; i < array.length; i++) {
        if (array[i] !== item) {
            arrayTotales.push(array[i]);
            $("#valorServicio").val(arrayTotales);
        }
    }
    //alert(arrayTotales);
}

function sacarIdTipoServicioArray(array, item) {

    arrayIdTipoServicios = [];
    for (var i = 0; i < array.length; i++) {
        if (array[i] !== item) {
            arrayIdTipoServicios.push(array[i]);
            $("#idTipoServicio").val(arrayIdTipoServicios);
        }
    }
    //alert(arrayIdTipoServicios);
}

function guardarServicio() {
    limpiarCampos();
    var d = new Date();
    var mes = d.getMonth() + 1;
    var dia = d.getDate();
    var fechaActual = d.getFullYear() + ' / ' +
            (mes < 10 ? ' 0 ' : ' ') + mes + ' / ' +
            (dia < 10 ? ' 0 ' : ' ') + dia;

    var momentoActual = new Date();
    var hora = momentoActual.getHours();
    var minuto = momentoActual.getMinutes();
    var horaActual = hora + " : " + minuto;

    var contadorErrores = 0;
    var cont = contador;
    if ($("#cedulaConductor").val() === "") {
        contadorErrores++;
        $("#cedulaConductor").css('background', 'red');

    }
    if ($("#placaVehiculo").val() === "") {
        $("#placaVehiculo").css('background', 'red');
        contadorErrores++;
    }
    if ($("#parametroTipoVehiculonew").val() === null) {
        $("#parametroTipoVehiculonew").css('background', 'red');
        contadorErrores++;
    }
    if (contadorErrores !== 0) {
        alert("Los Campos pintados de rojo son obligatorios");
        return false;
    } else {
        if (cont === 0) {
            alert("Debe seleccionar al menos un tipo de servicio");
            return false;
        } else {
            $("#contador").val(contador);
            $.post('GuardarServicio', {
                cedulaConductor: $("#cedulaConductor").val(),
                placaVehiculo: $("#placaVehiculo").val(),
                idTipoVehiculo: $("#parametroTipoVehiculonew").val(),
                fechaServicio: fechaActual,
                horaLlegada: horaActual,
                "idTipoServicio[]": arrayIdTipoServicios,
                "valorServicio[]": arrayTotales,
                subtotal: $("#subtotal").val(),
                porcentajeDescuento: porcDescuento,
                valorDescuento: $("#valorDescuento").val(),
                totalServicio: $("#totalServicio").val()
            }, function (responseText) {
                toastr.success(responseText);
                setTimeout('document.location.reload()', 1000);

            });
        }

    }
}

function borrarServicio(idServicio) {

    var resul = confirm('¿Esta seguro que desea eliminar el registro?');
    if (resul === true)
    {
        $.post('operacionesTipoServicioTipoVehiculo?opcion=eliminarServicio', {
            idServicio: idServicio
        }, function (responseText) {
            if (responseText != "true") {
                if (responseText[0] == "t") {
                    toastr.success("Servicio eliminado");
                    setTimeout('document.location.reload()', 1000);

                } else {
                    toastr.error("No se puede eliminar el Servicio");
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

function finalizarServicio(idServicio) {
    var resul = confirm('¿Esta seguro que desea finalizar el servicio?');
    if (resul === true)
    {
        $.post('operacionesTipoServicioTipoVehiculo?opcion=finaliSezarrvicio', {
            idServicio: idServicio
        }, function (responseText) {
            if (responseText != "true") {
                if (responseText[0] == "t") {
                    toastr.success("Servicio Finalizado");
                    setTimeout('liquidarServicio.jsp', 1000);

                } else {
                    toastr.error("No se puede finalizar el Servicio");
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

function limpiarCampos() {

    $("#cedulaConductor").css('background', '');
    $("#placaVehiculo").css('background', '');
    $("#parametroTipoVehiculonew").css('background', '');
}



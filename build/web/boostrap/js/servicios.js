/* global arrayTotales, arrayIdTipoServicios */

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
        }else{
            
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
        }
    }
    //alert(arrayTotales);
}

function sacarIdTipoServicioArray(array, item) {

    arrayIdTipoServicios = [];
    for (var i = 0; i < array.length; i++) {
        if (array[i] !== item) {
            arrayIdTipoServicios.push(array[i]);
        }
    }
    //alert(arrayIdTipoServicios);
}

function guardarServicio() {
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
    
    if($("#cedulaConductor").val() === ""){        
        $("#cedulaConductor").css('border-color', 'red');
        alert("Debe ingresar un número de cédula");
    }else if($("#placaVehiculo").val() === ""){        
        $("#placaVehiculo").css('border-color', 'red');
        alert("Debe ingresar una placa de vehículo");
    }else if($("#parametroTipoVehiculonew").val() === null)    {
        $("#parametroTipoVehiculonew").css('border-color', 'red');
        alert("Debe seleccionar un tipo de vehiculo");
    }else if(contador === 0){        
        console.log("Debe seleccionar al menos un tipo de servicio");
    }
    else{
        
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
            alert("Servicio Registrado");
           
        });
    }
}



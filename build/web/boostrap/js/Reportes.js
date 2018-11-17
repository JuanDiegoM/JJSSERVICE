/* global saveAss, toastr */

$(document).ready(function () {

    $("#repoteGeneral").hide();

    $("#btn").click(function () {

        $(".table").table2excel({
            name: "Informe",
            filename: "Informe Serviteca"
        });
    });

    $("#guardarReporte").click(function () {
        if ($("#nombreReporte").val() === "") {
            $("#nombreReporte").css('background', 'red');
            alert("El reporte debe llevar un nombre");
        } else {
            
            $.post('operacionesTipoServicioTipoVehiculo?opcion=guardarReporte', {
                nombreReporte: $("#nombreReporte").val()
                

            }, function (responseText) {
                if (responseText != "true") {
                    if (responseText[0] == "t") {
                        toastr.success("Reporte guardado");
                        setTimeout("location.href='nuevoReporte.jsp'", 1000);

                    } else {
                        toastr.error("Error al tratar de guardar reporte");
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

function verReporte() {
    //window.location.href="listarReportes.jsp";
    $("#repoteGeneral").show();
    var idTipoVehiculo = 0;
    var idTipoServicio = 0;
    var fechaInicio = "";
    var fechaFin = "";
    if ($("#parametroTipoVehiculonew").val() !== null) {
        idTipoVehiculo = $("#parametroTipoVehiculonew").val();
    }
    if ($("#parametroServicionew").val() !== null) {
        idTipoServicio = $("#parametroServicionew").val();
    }
    if ($("#reporteFechaInicio").val() !== "") {
        fechaInicio = $("#reporteFechaInicio").val();
    }
    if ($("#reporteFechaFin").val() !== "") {
        fechaFin = $("#reporteFechaFin").val();
    }

    $.post('Report', {
        idTipoVehiculo: idTipoVehiculo,
        idTipoServicio: idTipoServicio,
        fechaInicio: fechaInicio,
        fechaFin: fechaFin
    }, function (responseText) {
        $('#tablaReporte').html(responseText);
    });
}

function borrarReporte(idReporte) {

    var resul = confirm('¿Esta seguro que desea eliminar el registro?');
    if (resul === true)
    {
        $.post('operacionesTipoServicioTipoVehiculo?opcion=eliminarReporte', {
            idReporte: idReporte
        }, function (responseText) {
            if (responseText != "true") {
                if (responseText[0] == "t") {
                    toastr.success("Reporte eliminado");
                    setTimeout("location.href='listarReportes.jsp'", 1000);
                } else {
                    toastr.error("Error al tratar de eliminar el reporte");
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





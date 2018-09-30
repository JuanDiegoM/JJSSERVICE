$(document).ready(function () {

    $("#repoteGeneral").hide();
    
    $("#btn").click(function (){
        
        $(".table").table2excel({
           name: "Informe",
           filename: "Informe Serviteca"
        });
    });
});

function verReporte() {    
        //window.location.href="listarReportes.jsp";
        $("#repoteGeneral").show();
        var idTipoVehiculo = 0;
        var idTipoServicio = 0;
        var fechaInicio = "";
        var fechaFin = "";
        if($("#parametroTipoVehiculonew").val() !== null){
            idTipoVehiculo = $("#parametroTipoVehiculonew").val();
        }
        if($("#parametroServicionew").val() !== null){
            idTipoServicio = $("#parametroServicionew").val();
        }
        if($("#reporteFechaInicio").val() !== ""){
            fechaInicio = $("#reporteFechaInicio").val();
        }
        if($("#reporteFechaFin").val() !== ""){
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





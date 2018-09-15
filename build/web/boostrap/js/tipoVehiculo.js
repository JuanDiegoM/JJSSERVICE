$(document).ready(function (){
    
    $("#formNuevoTipoVehiculo").submit(function () {
        
        if ($("#tipoVehiculoNew").val() === "") {

            $("#tipoVehiculoNew").css('border-color', 'red');
            $('#tipoVehiculoNew').attr('placeholder', 'Campo requerido');
            return false;
        }else{
            
            return true;
        }

    });
    
    $("#formEditarTipoVehiculo").submit(function () {
        
        if ($("#tipoVehiculoEdit").val() === "") {

            $("#tipoVehiculoEdit").css('border-color', 'red');
            $('#tipoVehiculoEdit').attr('placeholder', 'Campo requerido');
            return false;
        }else{
            
            return true;
        }

    });
    
    $("#formularioTipoVehiculo").submit(function () {
        
        var resul = confirm('¿Esta seguro que desea eliminar el registro?');
        if (resul === true)
        {
            return true;
        }else{
            
            return false;
        }
    });
    
});



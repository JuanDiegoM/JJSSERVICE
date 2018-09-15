$(document).ready(function () {
    
    $("#formNuevoTipoServicio").submit(function () {
        
        if ($("#tipoServicioNew").val() === "") {

            $("#tipoServicioNew").css('border-color', 'red');
            $('#tipoServicioNew').attr('placeholder', 'Campo requerido');
            return false;
        }else{
            
            return true;
        }

    });
    
    $("#formEditarTipoServicio").submit(function () {
        
        if ($("#tipoServicioEdit").val() === "") {

            $("#tipoServicioEdit").css('border-color', 'red');
            $('#tipoServicioEdit').attr('placeholder', 'Campo requerido');
            return false;
        }else{
            
            return true;
        }

    });
    
    $("#formularioTipoServicio").submit(function () {
        
        var resul = confirm('¿Esta seguro que desea eliminar el registro?');
        if (resul === true)
        {
            return true;
        }else{
            
            return false;
        }
    });
    
});



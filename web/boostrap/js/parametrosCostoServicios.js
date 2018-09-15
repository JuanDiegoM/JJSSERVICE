$(document).ready(function (){  
    
    $("#formNuevoCostoServicio").submit(function () {
        
        if ($("#parametroValorServicio").val() === "") {
            
            $("#parametroValorServicio").css('border-color', 'red');
            $('#parametroValorServicio').attr('placeholder', 'Campo requerido');
            return false;
        }else if($("#parametroTipoVehiculonew").val() === ""){
            $("#parametroValorServicio").css('border-color', 'red');
            return false;
        }else if($("#parametroServicionew").val() === ""){
            $("#parametroServicionew").css('border-color', 'red');
            return false;            
        }else{
            
            return true;
        }

    });
    
    $("#formularioDescuentos").submit(function () {
        
        var resul = confirm('¿Esta seguro que desea eliminar el registro?');
        if (resul === true)
        {
            return true;
        }else{
            
            return false;
        }
    });
});



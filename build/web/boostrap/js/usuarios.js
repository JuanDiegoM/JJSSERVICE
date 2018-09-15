$(document).ready(function () {
        
    $("#formularioEliminarUsuario").submit(function () {
        
        var resul = confirm('¿Esta seguro que desea eliminar el registro?');
        if (resul === true)
        {
            return true;
        }else{
            
            return false;
        }
    });
    
    $("#formularioEliminarTipoUsuario").submit(function () {
        
        var resul = confirm('¿Esta seguro que desea eliminar el registro?');
        if (resul === true)
        {
            return true;
        }else{
            
            return false;
        }
    });

    $("#formularioLogin").submit(function () {

        if ($("#nombre").val() === "") {

            $("#nombre").css('border-color', 'red');
            $('#nombre').attr('placeholder', 'Campo requerido');
            return false;
        } else if ($("#contraseña").val() === "") {

            $("#contraseña").css('border-color', 'red');
            $('#contraseña').attr('placeholder', 'Campo requerido');
            return false;
        } else {
            return true;
        }

    });

    $("#formEditarUsuario").submit(function () {

        if ($("#passEdit").val() !== $("#passRepEdit").val()) {
            alert("las contraseñas no coinciden");
            $("#passEdit").val("");
            $("#passRepEdit").val("");
            return false;

        } else {
            return true;

        }

    });

    $("#formNuevoUsuario").submit(function () {

        if ($("#nombreUsuarioNew").val() === "") {

            $("#nombreUsuarioNew").css('border-color', 'red');
            $('#nombreUsuarioNew').attr('placeholder', 'Campo requerido');
            return false;
        }

        else if ($("#tipoUsuarioNew").val() === null) {
            $("#tipoUsuarioNew").css('border-color', 'red');
            return false;
        }
        else if ($("#passNew").val() !== $("#passRepNew").val() || $("#passNew").val() === "" || $("#passRepNew").val() === "") {

            alert("las contraseñas no coinciden");
            $("#passNew").val("");
            $("#passRepNew").val("");
            return false;
        } else {

            return true;
        }
    });
    
    $("#formNuevoTipoUsuario").submit(function () {

        if ($("#tipoUsuarioNew").val() === "") {

            $("#tipoUsuarioNew").css('border-color', 'red');
            $('#tipoUsuarioNew').attr('placeholder', 'Campo requerido');
            return false;
        }
         else {

            return true;
        }
    });
    
    $("#formEditarTipoUsuario").submit(function () {

        if ($("#tipoUsuarioEdit").val() === "") {

            $("#tipoUsuarioEdit").css('border-color', 'red');
            $('#tipoUsuarioEdit').attr('placeholder', 'Campo requerido');
            return false;
        }
         else {

            return true;
        }
    });

});



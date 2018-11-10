/* global toastr */

$(document).ready(function () {

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

    $("#guardarEditarUsuario").click(function () {

        if ($("#passEdit").val() !== $("#passRepEdit").val()) {
            alert("las contraseñas no coinciden");
            $("#passEdit").css('background', 'red');
            $("#passRepEdit").css('background', 'red');
            $("#passEdit").val("");
            $("#passRepEdit").val("");
            return false;

        } else {

            $.post('operacionesUsuarios?opcion=editarUsuario', {
                passEdit: $("#passEdit").val(),
                passRepEdit: $("#passRepEdit").val(),
                nombreUsuarioEdit: $("#nombreUsuarioEdit").val(),
                tipoUsuarioEdit: $("#tipoUsuarioEdit").val(),
                idUsuario: $("#idUsuario").val()
            }, function (responseText) {
                if (responseText != "true") {
                    if (responseText[0] == "t") {
                        toastr.success("Usuario editado");
                        setTimeout("location.href='usuarios.jsp'", 1000);
                        //location = 'usuarios.jsp';
                    } else {
                        toastr.error("Error al tratar de editar el usuario");
                        setTimeout("location.href='editarUsuario.jsp'", 1000);

                    }
                } else {
                    toastr.error("Error Interno");
                    location.reload();
                }
            });
        }

    });

    $("#guardarNuevoUsuario").click(function () {
        limpiarCampos();
        var contadorErrores = 0;
        if ($("#nombreUsuarioNew").val() === "") {
            contadorErrores++;
            $("#nombreUsuarioNew").css('background', 'red');
        }

        if ($("#tipoUsuarioNew").val() === null) {
            contadorErrores++;
            $("#tipoUsuarioNew").css('background', 'red');
        }

        if ($("#passNew").val() === "") {
            contadorErrores++;
            $("#passNew").css('background', 'red');
        }

        if ($("#passRepNew").val() === "") {
            contadorErrores++;
            $("#passRepNew").css('background', 'red');
        }

        if (contadorErrores !== 0) {

            alert("Los Campos pintados de rojo son obligatorios");
            return false;

        } else if ($("#passNew").val() !== $("#passRepNew").val()) {

            alert("las contraseñas no coinciden");
            $("#passNew").css('background', 'red');
            $("#passRepNew").css('background', 'red');
            $("#passNew").val("");
            $("#passRepNew").val("");
            return false;
        } else {

            $.post('operacionesUsuarios?opcion=nuevoUsuario', {
                nombreUsuarioNew: $("#nombreUsuarioNew").val(),
                tipoUsuarioNew: $("#tipoUsuarioNew").val(),
                passNew: $("#passNew").val()
            }, function (responseText) {
                if (responseText != "true") {
                    if (responseText[0] == "t") {
                        toastr.success("Usuario creado");
                        setTimeout("location.href='usuarios.jsp'", 1000);
                    } else {
                        toastr.error("Error al tratar de crear el usuario");
                        setTimeout("location.href='nuevoUsuario.jsp'", 1000);
                    }
                } else {
                    toastr.error("Error Interno");
                    location.reload();
                }
            });
        }
    });

    $("#formEditarTipoUsuario").submit(function () {
        if ($("#tipoUsuarioEdit").val() === "") {
            $("#tipoUsuarioEdit").css('border-color', 'red');
            $('#tipoUsuarioEdit').attr('placeholder', 'Campo requerido');
            return false;
        } else {
            $.post('operacionesUsuarios?opcion=editarTipoDeUsuario', {
                idTipoUsuario: $("#idTipoUsuario").val(),
                tipoUsuarioEdit: $("#tipoUsuarioEdit").val()
            }, function (responseText) {
                if (responseText != "true") {
                    if (responseText[0] == "t") {
                        toastr.success("Tipo de usuario editado");
                        setTimeout("location.href='tipoUsuario.jsp'", 1000);

                    } else {
                        toastr.error("Error al tratar de editar el tipo de usuario");
                        setTimeout("location.href='editarTipoUsuario.jsp'", 1000);

                    }
                } else {
                    toastr.error("Error Interno");
                    location.reload();
                }
            });
        }
    });

    $("#guardarNuevoTipoUsuario").click(function () {
        var contadorErrores = 0;
        if ($("#tipoUsuarioNew").val() === "") {
            contadorErrores++;
            $("#tipoUsuarioNew").css('background', 'red');
        }
        if (contadorErrores !== 0) {
            alert("Los Campos pintados de rojo son obligatorios");
            return false;
        } else {
            $.post('operacionesUsuarios?opcion=nuevoTipoDeUsuario', {
                tipoUsuarioNew: $("#tipoUsuarioNew").val()
            }, function (responseText) {
                if (responseText != "true") {
                    if (responseText[0] == "t") {
                        toastr.success("Tipo de usuario creado");
                        setTimeout("location.href='tipoUsuario.jsp'", 1000);

                    } else {
                        toastr.error("Error al tratar de guardar el tipo de usuario");
                        setTimeout("location.href='nuevoTipoUsuario.jsp'", 1000);

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

    $("#nombreUsuarioNew").css('background', '');
    $("#tipoUsuarioNew").css('background', '');
    $("#passNew").css('background', '');
    $("#passRepNew").css('background', '');

}

function borrarTipoUsuario(idTipoUsuario) {

    var resul = confirm('¿Esta seguro que desea eliminar el registro?');
    if (resul === true)
    {
        $.post('operacionesUsuarios?opcion=eliminarTipoUsuario', {
            idTipoUsuario: idTipoUsuario
        }, function (responseText) {
            if (responseText != "true") {
                if (responseText[0] == "t") {
                    toastr.success("Tipo de usuario eliminado");
                    setTimeout('document.location.reload()', 1000);

                } else {
                    toastr.error("No se puede eliminar el tipo de usuario por que esta relacionado con un usuario");
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

function borrarUsuario(idUsuario) {

    var resul = confirm('¿Esta seguro que desea eliminar el registro?');
    if (resul === true)
    {
        $.post('operacionesUsuarios?opcion=eliminarUsuario', {
            idUsuario: idUsuario
        }, function (responseText) {
            if (responseText != "true") {
                if (responseText[0] == "t") {
                    toastr.success("Usuario eliminado");
                    setTimeout('document.location.reload()', 1000);
                } else {
                    toastr.error("Error al tratar de eliminar el usuario");
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





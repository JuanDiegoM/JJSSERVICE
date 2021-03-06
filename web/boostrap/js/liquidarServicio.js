$(document).ready(function () {

    var idServicio = $("#idServicio").val();
    $.post('liquidarServicio', {
        idServicio: idServicio
    }, function (responseText) {
        $('#tablaLiquidacion').html(responseText);
    });
});

function imprimirFactura() {
    var pdf = new jsPDF('p', 'pt', 'letter');
    source = $('#tablaLiquidacion')[0];

    specialElementHandlers = {
        '#bypassme': function (element, renderer) {
            return true;
        }
    };
    margins = {
        top: 80,
        bottom: 60,
        left: 40,
        width: 522
    };

    pdf.fromHTML(
        source,
        margins.left, // x coord
        margins.top, {// y coord
            'width': margins.width,
            'elementHandlers': specialElementHandlers
        },
        function (dispose) {
            var blob = pdf.output("blob");
            window.open(URL.createObjectURL(blob));

        }, margins
    );
}



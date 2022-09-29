function receiveSubmit() {

    let xValue = document.querySelector('#x_value').value;
    let yValue = document.querySelector('#y_value').value;
    let rValue = document.querySelector("[name='r']:checked")?.value;

    const date = new Date();
    const offset = date.getTimezoneOffset();

    if (validateValues(xValue, yValue, rValue)) {
        $.ajax({
            type: 'POST',
            url: './controller',
            data: {'x': xValue, 'y': yValue, 'r': rValue, 'offset': offset},
            success: function (response) {
                document.querySelector('#table > tbody').innerHTML = parseJSON(response);
            },
            error: function (jqXHR) {
                alert(jqXHR.text);
            }
        });
    }
}
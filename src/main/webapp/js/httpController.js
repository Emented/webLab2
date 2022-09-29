function sendCheckRequest(xValue, yValue, rValue) {

    const date = new Date();
    const offset = date.getTimezoneOffset();

    if (validateValues(xValue, yValue, rValue)) {
        $.ajax({
            type: 'POST',
            url: './controller',
            data: {'x': xValue, 'y': yValue, 'r': rValue, 'offset': offset},
            success: function (response) {
                document.querySelector('#table > tbody').innerHTML = parseJSON(response);
                moveCircle(parseInt(xValue), parseFloat(yValue), parseInt(rValue));
            },
            error: function (jqXHR) {
                alert(jqXHR.text);
            }
        });
    }
}

function sendClearRequest() {
    $.ajax({
        type: "PUT",
        url: "./controller",
        data: {'cleanTable': true},
        success: function(data) {
            alert(data);
        },
        error: function(data) {
            alert(data);
        }
    });
}

function sendGetRequest() {
    $.ajax({
        type: "GET",
        url: "./controller",
        data: {"getTable": true},
        success: function(data) {
            document.querySelector('#table > tbody').innerHTML = parseJSON(data);
        },
        error: function(jqXHR) {
            alert(jqXHR.text);
        }
    });
}
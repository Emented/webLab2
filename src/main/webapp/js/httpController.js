function sendCheckRequest(xValue, yValue, rValue) {

    const date = new Date();
    const offset = date.getTimezoneOffset();

    if (validateValues(xValue, yValue, rValue)) {
        $.ajax({
            type: 'POST',
            url: './controller/check-point',
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

function sendClearRequest() {
    $.ajax({
        type: "DELETE",
        url: "./controller/clear-table",
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
        url: "./controller/get-table",
        async: false,
        success: function(data) {
            document.querySelector('#table > tbody').innerHTML = parseJSON(data);
        },
        error: function(jqXHR) {
            alert(jqXHR.text);
        }
    });
}
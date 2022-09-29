function receiveSubmit() {
    let xValue = document.querySelector('#x_value').value;
    let yValue = document.querySelector('#y_value').value;
    let rValue = document.querySelector("[name='r']:checked")?.value;
    sendCheckRequest(xValue, yValue, rValue);
}


function checkInput() {
    let yValue = document.querySelector('#y_value');
    yValue.classList.remove('error');
    if (yValue.value.includes(',')) {
        yValue.value = yValue.value.replace(',', '.');
    }
    if (yValue.value.indexOf('.') === -1) {
        return;
    }
    if (yValue.value.length -
        yValue.value.indexOf('.') > 11) {
        yValue.value = yValue.value.slice(0, yValue.value.indexOf('.') + 11);
        yValue.classList.add('error');
    }
}
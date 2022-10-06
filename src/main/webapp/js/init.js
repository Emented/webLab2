const buttons = document.querySelectorAll('.btn_group button');
const xInput = document.querySelector('#x_value');
const radioButtons = document.querySelectorAll('.r_value input');
const plot = document.querySelector('.plot svg');

function init() {
    sendGetRequest();
    hideDots();
    buttons.forEach(element => {
        element.onclick = selectX;
    });
    radioButtons.forEach(element => {
        element.addEventListener('change', function () {
            changeR(this.value);
        })
    });
    plot.addEventListener('click', function (event) {
        let rValue = document.querySelector("[name='r']:checked")?.value;
        if (!validateR(rValue)) {
            alert("Не выбрано значение R!");
            return;
        }

        let target = this.getBoundingClientRect();
        let x = Math.round(event.clientX - target.left - 22);
        let y = event.clientY - target.top - 21;
        let xValue = Math.round((x - 150) / (100 / rValue));
        let yValue = ((y - 150) / (-100 / rValue)).toFixed(3);
        sendCheckRequest(xValue, yValue, rValue);
    });
}

function selectX() {
    if (xInput.value === this.value) {
        this.classList.remove('selected');
        xInput.value = '';
    } else {
        let selectedElems = document.querySelectorAll('.selected');
        selectedElems.forEach(element => {
            element.classList.remove('selected');
        });
        xInput.value = this.value;
        this.classList.add('selected');
    }
}
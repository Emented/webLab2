const buttons = document.querySelectorAll('.btn_group button');
const xInput = document.querySelector('#x_value');
const radioButtons = document.querySelectorAll('.r_value input')

function init() {
    getTable();
    buttons.forEach(element => {
        element.onclick = selectX;
    });
    radioButtons.forEach(element => {
        element.addEventListener('change', function () {
            console.log(this.value);
            changeR(this.value);
        })
    })
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

function getTable() {
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
function cleanInput() {
    let selectedElems = document.querySelectorAll('.selected');
    selectedElems.forEach(element => {
        element.classList.remove('selected');
    });
    selectedElems = document.querySelectorAll('.error')
    selectedElems.forEach(element => {
        element.classList.remove('error');
    });
    document.querySelector('.validation_info').classList.remove('show');
    document.querySelector('.validation_info').innerHTML = '';
    xInput.value = '';
    changeR();
}

function cleanTable() {
    let cont = document.querySelector("svg");
    let tBody = document.querySelector('#table > tbody');
    tBody.innerHTML = '';
    for (let i = dots.length - 1; i >= 0; i--) {
        cont.removeChild(dots[i]);
        dots.pop();
    }
    sendClearRequest();
}
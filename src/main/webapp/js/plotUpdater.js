function changeR(value) {
    if (isNaN(value)) {
        document.querySelectorAll('#r').forEach(element => {
            element.innerHTML = 'R';
        })
        document.querySelectorAll('#-r').forEach(element => {
            element.innerHTML = '-R';
        })
        document.querySelectorAll('#r2').forEach(element => {
            element.innerHTML = 'R/2'
        })
        document.querySelectorAll('#-r2').forEach(element => {
            element.innerHTML = '-R/2'
        })
    } else {
        let rInt = parseInt(value);
        changeCircleR(rInt);
        document.querySelectorAll('#r').forEach(element => {
            element.innerHTML = rInt.toString();
        })
        document.querySelectorAll('#-r').forEach(element => {
            element.innerHTML = (-rInt).toString();
        })
        document.querySelectorAll('#r2').forEach(element => {
            element.innerHTML = (rInt / 2).toString();
        })
        document.querySelectorAll('#-r2').forEach(element => {
            element.innerHTML = (-rInt / 2).toString();
        })
    }
}

let prevX = 0;
let prevY = 0;

function moveCircle(xValue, yValue, rValue) {
    let circle = document.querySelector("#circle");
    prevX = xValue;
    prevY = yValue;
    circle.setAttribute("cx",150 + xValue * 100 / rValue);
    circle.setAttribute("cy",150 - yValue * 100 / rValue);
}

function changeCircleR(rValue) {
    let circle = document.querySelector("#circle");
    circle.setAttribute("cx",150 + prevX * 100 / rValue);
    circle.setAttribute("cy",150 - prevY * 100 / rValue);
}
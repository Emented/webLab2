const dots = [];
const cont = document.querySelector("svg");
let firstDrow = true;
let prevR = 1;

function changeR(value) {
    if (isNaN(value)) {
        document.querySelectorAll('#r').forEach(element => {
            element.innerHTML = 'R';
        });
        document.querySelectorAll('#-r').forEach(element => {
            element.innerHTML = '-R';
        });
        document.querySelectorAll('#r2').forEach(element => {
            element.innerHTML = 'R/2'
        });
        document.querySelectorAll('#-r2').forEach(element => {
            element.innerHTML = '-R/2'
        });
        hideDots();
    } else {
        let rInt = parseInt(value);
        changeDotsR(rInt);
        document.querySelectorAll('#r').forEach(element => {
            element.innerHTML = rInt.toString();
        });
        document.querySelectorAll('#-r').forEach(element => {
            element.innerHTML = (-rInt).toString();
        });
        document.querySelectorAll('#r2').forEach(element => {
            element.innerHTML = (rInt / 2).toString();
        });
        document.querySelectorAll('#-r2').forEach(element => {
            element.innerHTML = (-rInt / 2).toString();
        });
        prevR = rInt;
    }
}

function hideDots() {
    for (let i = 0; i < dots.length; i++) {
        let dot = dots[i];
        dot.setAttributeNS(null, 'style', "opacity: 0;");
    }
}

function removeDots() {
    for (let i = dots.length - 1; i >= 0; i--) {
        cont.removeChild(dots[i]);
        dots.pop();
    }
}

function changeDotsR(rValue) {
    for (let i = 0; i < dots.length; i++) {
        let dot = dots[i];
        dot.setAttributeNS(null, 'style', "opacity: 1;");
        let xCoordinate = (dot.getAttributeNS(null, 'cx') - 150) * prevR / rValue + 150;
        let yCoordinate = (dot.getAttributeNS(null, 'cy') - 150) * prevR / rValue + 150;
        dot.setAttributeNS(null, 'cx', xCoordinate);
        dot.setAttributeNS(null, 'cy', yCoordinate);
    }
}

function drawDot(xValue, yValue, rValue) {
    let svgns = "http://www.w3.org/2000/svg";

    let circle = document.createElementNS(svgns, 'circle');

    if (firstDrow) {
        rValue = 1;
        firstDrow = false;
    }

    circle.setAttributeNS(null, 'cx', 150 + xValue * 100 / rValue);
    circle.setAttributeNS(null, 'cy', 150 - yValue * 100 / rValue);
    circle.setAttributeNS(null, 'r', 4);
    circle.setAttributeNS(null, 'style', 'fill: black; stroke: black');
    dots.push(circle);
    cont.appendChild(circle);
}
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
function parseJSON(data) {
    let json = JSON.parse(data);
    let tableRows = json.tableElements;
    let result = "";
    tableRows.forEach(function (tableRow) {
        let date = new Date(tableRow.date * 1000);
        result += "<tr>" +
            "<td>" + date.toISOString().slice(0, 19).replace('T', ' ') + "</td>" +
            "<td>" + Number(tableRow.scriptTime).toFixed(2) + "</td>" +
            "<td>" + tableRow.x + "</td>" +
            "<td>" + tableRow.y + "</td>" +
            "<td>" + tableRow.r + "</td>" +
            "<td>" + (tableRow.hit === true ? 'HIT' : 'MISS') + "</td>" +
            "</tr>";
    });
    return result;
}
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>WebLab1</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

        <style>

            body {
                margin: 0;
                padding: 0;
                background-color: #dedede;
                height: 100%;
            }

            .wrapper {
                text-align: center;
                width: 100%;
                border-spacing: 0;
                table-layout: fixed;
                border-collapse: collapse;
                margin: 0;
                vertical-align: top;
            }

            .wrapper tr td {
                vertical-align: top;
            }

            .header {
                text-align: left;
                background-color: #ff9400;
                font-family: monospace;
                font-size: 200%;
                font-weight: 700;
                padding: 4px;
            }

            .horizontal-separator {
                height: 30px;
            }

            .plot {
                padding: 0 20px 20px 20px;
            }

            .plot svg {
                padding: 20px;
                border: 2px solid black;
                border-radius: 10px;
                background-color: white;
            }

            .plot line, path, polygon {
                stroke: rgba(0, 0, 0, 0.92);
                fill: #ff9400;
                font-size: 10px;
            }

            .plot text {
                opacity: 1;
                font-size: 16px;
                font-weight: 700;
            }

            .user_input form {
                padding: 20px;
                border: 2px solid black;
                border-radius: 10px;
                justify-content: center;
                text-align: center;
                background-color: white;
            }

            .values {
                margin: 0;
                width: 100%;
                font-size: 18px;
            }

            .values td {
                padding: 1%;
            }

            .btn_group {
                white-space: nowrap;
            }

            .btn_group button, [type="text"] {
                font-size: 16px;
                background-color: #c8cfd5;
                border-radius: 4px;
                border: 2px solid black;
            }

            .btn_group button:hover, [type="text"]:hover {
                background-color: #8399ae;
            }

            .validation_info {
                display: flex;
                flex-direction: column;
                justify-content: center;
                text-align: center;
                background: #ff9400;
                border-radius: 10px;
                border: 2px solid black;
                opacity: 0;
            }

            .validation_info.show {
                opacity: 1;
                transition: opacity 0.7s;
                margin-top: 8px;
            }

            .table {
                padding: 0 20px 20px 20px;
            }

            .table table {
                font-size: 18px;
                text-align: center;
                width: 100%;
                border: 2px solid;
                border-collapse: collapse;
                background-color: white;

            }


            .table table thead {
                background-color: #ff9400;
                border: 2px solid black;
                height: 50px;
            }

            .table table tfoot {
                text-align: right;
            }

            .reset-table {
                margin: 6px 4px 2px 0;
            }

            .selected {
                background-color: #ff9400 !important;
            }

            .selected:hover {
                background-color: #ff7a00 !important;
            }

            .error {
                border-radius: 4px;
                border: 2px solid black;
                background-color: #ff9400;
                position: relative;
                animation: shake .1s linear;
                animation-iteration-count: 5;
            }

            input[type="submit"] {
                font-size: 16px;
                background-color: #ff9400;
                border-radius: 4px;
                border: 2px solid black;
            }

            input[type="submit"]:hover {
                background-color: #ff7a00;
            }

            input[type="reset"] {
                font-size: 16px;
                background-color: #8399ae;
                border-radius: 4px;
                border: 2px solid black;
            }

            input[type="reset"]:hover {
                background-color: #6d8694;
            }

            @keyframes shake {
                0% { left: -1px; }
                100% { right: -1px; }
            }
        </style>
    </head>
    <body onload="init()">
    <table class="wrapper">
        <colgroup>
            <col span="1" style="width: 27%;">
            <col span="1" style="width: 33%;">
            <col span="1" style="width: 40%;">
        </colgroup>
        <tbody>
        <tr>
            <td class="header" colspan="3">
                emented
                1514
                P32121
            </td>
        </tr>
        <tr>
            <td class='horizontal-separator' colspan='3'></td>
        </tr>
        <tr>
            <td class="plot">
                <svg width="300" height="300">
                    <!--Координатные оси-->
                    <line x1="0" x2="300" y1="150" y2="150"></line>
                    <line x1="150" x2="150" y1="0" y2="300"></line>
                    <!--Стрелочки-->
                    <polygon points="150,0 145,15 155,15"></polygon>
                    <polygon points="300,150 285,145 285,155"></polygon>
                    <!--Прямоугольник в первой четверти-->
                    <polygon points="150,150 250,150 250,100 150,100"></polygon>
                    <!--Четверть круга в третьей четверти-->
                    <path d="M200,150 A50,50 90 0,1 150,200 L 150,150 Z"></path>
                    <!--Треугольник в четвертой четверти-->
                    <polygon points="150,150 50,150 150,100"></polygon>
                    <!-- Подписи к осям -->
                    <text x="285" y="135">X</text>
                    <text x="160" y="15">Y</text>
                    <!-- Метки для значений R на оси X -->
                    <line x1="50" x2="50" y1="140" y2="160"></line>
                    <line x1="100" x2="100" y1="140" y2="160"></line>
                    <line x1="200" x2="200" y1="140" y2="160"></line>
                    <line x1="250" x2="250" y1="140" y2="160"></line>
                    <!-- Метки для значений R на оси Y -->
                    <line x1="140" x2="160" y1="50" y2="50"></line>
                    <line x1="140" x2="160" y1="100" y2="100"></line>
                    <line x1="140" x2="160" y1="200" y2="200"></line>
                    <line x1="140" x2="160" y1="250" y2="250"></line>
                    <!-- Значения R на оси X -->
                    <text x="50" y="130" text-anchor="middle" id="-r">-R</text>
                    <text x="98" y="130" text-anchor="middle" id="-r2">-R/2</text>
                    <text x="200" y="130" text-anchor="middle" id="r2">R/2</text>
                    <text x="250" y="130" text-anchor="middle" id="r">R</text>
                    <!-- Значения R на оси Y -->
                    <text x="170" y="52.5" id="r">R</text>
                    <text x="170" y="102.5" id="r2">R/2</text>
                    <text x="170" y="202.5" id="-r2">-R/2</text>
                    <text x="170" y="252.5" id="-r">-R</text>
                </svg>
            </td>
            <td class="user_input">
                <form id="form" name="form" onsubmit="receiveSubmit(); return false;">
                    <table class="values">
                        <tr class="x_value">
                            <td class="btn_group">
                                <label for="x_value">Choose X:</label>

                                <button type="button" value="-5">-5</button>
                                <button type="button" value="-4">-4</button>
                                <button type="button" value="-3">-3</button>
                                <button type="button" value="-2">-2</button>
                                <button type="button" value="-1">-1</button>
                                <button type="button" value="0">0</button>
                                <button type="button" value="1">1</button>
                                <button type="button" value="2">2</button>
                                <button type="button" value="3">3</button>

                                <input type="hidden" name="x_value" id="x_value">
                            </td>
                        </tr>

                        <tr class="y_value">
                            <td>
                                <label for="y_value">Choose Y:</label>
                                <input type="text" id="y_value" name="y_value" onchange="checkInput()" oninput="checkInput()">
                            </td>
                        </tr>

                        <tr class="r_value">
                            <td>
                                <text>Choose R:</text>

                                <label>1<input name="r" type="radio" value="1"></label>
                                <label>2<input name="r" type="radio" value="2"></label>
                                <label>3<input name="r" type="radio" value="3"></label>
                                <label>4<input name="r" type="radio" value="4"></label>
                                <label>5<input name="r" type="radio" value="5"></label>
                            </td>
                        </tr>

                        <tr class="buttons">
                            <td>
                                <input id="reset-input" type="reset" value="Clean input" onclick="cleanInput()">
                                <input id="submit" type="submit" value="Check hit">
                            </td>
                        </tr>
                        <tr class="validation_info">

                        </tr>
                    </table>
                </form>
            </td>
            <td class="table">
                <table id="table">
                    <thead>
                    <tr>
                        <th scope="col">Current time</th>
                        <th scope="col">Computation time</th>
                        <th scope="col">X</th>
                        <th scope="col">Y</th>
                        <th scope="col">R</th>
                        <th scope="col">Result</th>
                    </tr>
                    </thead>
                    <tbody>

                    </tbody>
                    <tfoot>
                    <tr>
                        <td colspan="6">
                            <input class="reset-table" id="reset-table" type="reset" value="Clean table" onclick="cleanTable()">
                        </td>
                    </tr>
                    </tfoot>
                </table>
            </td>
        </tr>
        </tbody>
    </table>

    </body>
    <script src="./js/updater.js"></script>
    <script src="./js/validator.js"></script>
    <script src="./js/yInput.js"></script>
    <script src="./js/plotUpdater.js"></script>
    <script src="./js/cleaner.js"></script>
    <script src="./js/init.js"></script>
    <script src="js/jsonWorker.js"></script>
</html>
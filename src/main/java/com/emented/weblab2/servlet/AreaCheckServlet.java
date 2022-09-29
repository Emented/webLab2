package com.emented.weblab2.servlet;

import com.emented.weblab2.table.Table;
import com.emented.weblab2.table.TableRow;
import com.emented.weblab2.util.HitChecker;
import com.emented.weblab2.util.Validator;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;


@WebServlet(name = "AreaCheckServlet", value = "/table-controller")
public class AreaCheckServlet extends HttpServlet {

    private Validator validator;
    private HitChecker hitChecker;
    private Table table;

    private ObjectMapper objectMapper;

    @Override
    public void init() {
        validator = new Validator();
        hitChecker = new HitChecker();
        table = new Table();
        objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String xParam = request.getParameter("x");
        String yParam = request.getParameter("y");
        String rParam = request.getParameter("r");
        String offsetParam = request.getParameter("offset");

        double startTime = System.nanoTime();

        try {
            validator.validate(xParam, yParam, rParam, offsetParam);
        } catch (IllegalArgumentException e) {
            PrintWriter writer = response.getWriter();
            writer.println(e.getMessage());
            response.setStatus(400);
            writer.close();
        }

        TableRow tableRow = convertToTableRow(xParam, yParam, rParam, offsetParam, startTime);
        table.getTableElements().add(tableRow);
        PrintWriter writer = response.getWriter();
        String json = objectMapper.writeValueAsString(table);
        writer.println(json);

        writer.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        String json = objectMapper.writeValueAsString(table);
        writer.println(json);

        writer.close();
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        table.getTableElements().clear();
        PrintWriter writer = response.getWriter();
        writer.println("Table was cleared successfully!");

        writer.close();
    }

    private TableRow convertToTableRow(String x,
                                       String y,
                                       String r,
                                       String offset,
                                       double startTime) {
        int xNum = Integer.parseInt(x);
        double yNum = Double.parseDouble(y);
        int rNum = Integer.parseInt(r);
        Instant date = Instant.now().minusSeconds(Integer.parseInt(offset) * 60L);
        boolean hit = hitChecker.checkHit(xNum, yNum, rNum);

        return new TableRow(xNum,
                yNum,
                rNum,
                hit,
                date,
                (System.nanoTime() - startTime) / 1000000);
    }
}

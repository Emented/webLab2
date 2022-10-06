package com.emented.weblab2.servlet;


import com.emented.weblab2.table.Table;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ControllerServlet", urlPatterns = {"/controller/get-table",
        "/controller/clear-table",
        "/controller/check-point",
        "/controller/get-map-of-headers"})
public class ControllerServlet extends HttpServlet {

    private ObjectMapper objectMapper;
    @Override
    public void init() {
        objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
    }


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getMethod();
        String uri = request.getRequestURI();
        if (method.equals("POST") && uri.contains("/controller/check-point")) {
            getServletContext().getRequestDispatcher("/table-controller").forward(request, response);
        } else if (method.equals("GET") && uri.contains("/controller/get-table")) {
            getTable(request, response);
        } else if (method.equals("DELETE") && uri.contains("/controller/clear-table")) {
            clearTable(request, response);
        } else if (method.equals("GET") && uri.contains("/controller/get-map-of-headers")) {
            returnMapOfHeaders(request, response);
        } else {
            returnErrorMessage(request, response);
        }
    }

    private void clearTable(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Table table = (Table) request.getSession().getAttribute("table");
        if (table == null) {    // if we don't use browser
            table = new Table();
            request.getSession().setAttribute("table", table);
        }
        table.getTableElements().clear();
        PrintWriter writer = response.getWriter();
        writer.println("Table was cleared successfully!");

        writer.close();
    }

    private void getTable(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Table table = (Table) request.getSession().getAttribute("table");
        if (table == null) {    // if we don't use browser
            table = new Table();
            request.getSession().setAttribute("table", table);
        }
        PrintWriter writer = response.getWriter();
        String json = objectMapper.writeValueAsString(table);
        writer.println(json);

        writer.close();
    }

    private void returnErrorMessage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        response.setStatus(400);
        writer.println("Method not supported!");

        writer.close();
    }

    private void returnMapOfHeaders(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.println(getServletContext().getAttribute("headers"));

        writer.close();
    }
}

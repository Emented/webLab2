package com.emented.weblab2.servlet;


import com.emented.weblab2.util.Validator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ControllerServlet", value = "/controller")
public class ControllerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String xParam = request.getParameter("x");
        String yParam = request.getParameter("y");
        String rParam = request.getParameter("r");
        String dateParam = request.getParameter("offset");

        if (xParam == null || yParam == null || rParam == null || dateParam == null) {
            PrintWriter writer = response.getWriter();
            writer.println("Some of parameters are not set!");
            response.setStatus(400);
            writer.close();
        } else {
            getServletContext().getRequestDispatcher("/table-controller").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String getTableParam = request.getParameter("getTable");
        if (getTableParam == null) {
            PrintWriter writer = response.getWriter();
            writer.println("It's a strange GET request, what are you trying to get?");
            response.setStatus(400);
            writer.close();
        } else {
            getServletContext().getRequestDispatcher("/table-controller").forward(request, response);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String cleanTableParam = request.getParameter("cleanTable");
        if (cleanTableParam == null) {
            PrintWriter writer = response.getWriter();
            writer.println("It's a strange DELETE request, what are you trying to delete?");
            response.setStatus(400);
            writer.close();
        } else {
            getServletContext().getRequestDispatcher("/table-controller").forward(request, response);
        }
    }
}

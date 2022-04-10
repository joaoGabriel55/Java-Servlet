package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/json")
public class JSONServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("application/json");

    PrintWriter output = resp.getWriter();

    try {

      output.println("{\"name\":\"John\",\"age\":30,\"city\":\"New York\"}");

    } catch (Exception e) {
      System.out.println(e);
    } finally {
      output.close();
    }
  }

}

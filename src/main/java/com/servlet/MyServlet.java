package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api")
public class MyServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    PrintWriter output = resp.getWriter();

    try {

      output.println(req.getLocalAddr());
      output.println(req.getLocalName());
      output.println(req.getLocalPort());
      output.println("Cookies count: " + req.getCookies().length);

    } catch (Exception e) {
      System.out.println(e);
    } finally {
      output.close();
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String userName = req.getParameter("userName");

    Cookie cookie = new Cookie("Codeminer42", userName);

    resp.addCookie(cookie);
  }
}

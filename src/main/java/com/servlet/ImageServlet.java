package com.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/image")
public class ImageServlet extends HttpServlet {

  private void writeImageFile(OutputStream output, FileInputStream input) throws IOException {
    byte[] buffer = new byte[1024];
    int length = 0;

    while ((length = input.read(buffer)) >= 0)
      output.write(buffer, 0, length);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    ServletContext servletContext = req.getServletContext();

    String pathToWeb = getServletContext().getRealPath(File.separator);
    String filename = pathToWeb + "palmeiras_logo_escudo.jpg";
    String mimeType = servletContext.getMimeType(filename);

    if (mimeType == null) {
      resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
      return;
    }

    resp.setContentType(mimeType);

    File file = new File(filename);

    OutputStream output = resp.getOutputStream();
    FileInputStream input = new FileInputStream(file);

    resp.setContentLength((int) file.length());

    try {
      writeImageFile(output, input);
    } catch (Exception e) {
      System.out.println(e);
    } finally {
      input.close();
      output.close();
    }
  }

}

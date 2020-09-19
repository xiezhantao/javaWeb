package com.atguigu.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

/**
 * @author xzt
 * @create 2020-07-22 11:31
 */
public class Download extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String downloadFileName = "1.jpg";

        ServletContext servletContext = getServletContext();
        String mimeType = servletContext.getMimeType(downloadFileName);

        resp.setContentType(mimeType);
        resp.setHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode("小猫.jpg","UTF-8"));

        ServletOutputStream outputStream = resp.getOutputStream();

        InputStream resourceAsStream = servletContext.getResourceAsStream("/img/" + downloadFileName);
        resourceAsStream.transferTo(outputStream);


    }
}

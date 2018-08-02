package com.authorskn.servlets;

import com.authorskn.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestMirrorServlet extends HttpServlet {

    private static final String KEY = "key";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> data = new HashMap<>();
        data.put("value", request.getParameter(KEY));
        response.getWriter().println(PageGenerator.instance().getPage("page_mirror.html", data));
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        doGet(request, response);
    }
}

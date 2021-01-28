package com.qfedu.controller;

import com.qfedu.service.impl.UserServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        UserServiceImpl userService = new UserServiceImpl();
        int i = userService.fuzzyDeleteUser(id);
        if(i==1){
            System.out.println("删除成功");

        } else {
            System.out.println("删除失败");

        }
        request.getRequestDispatcher("/UserFuzzyServlet").forward(request,response);


    }
}

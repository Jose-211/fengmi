package com.qfedu.controller;

import com.qfedu.service.impl.UserServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/UserAddServlet")
public class UserAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String mail = request.getParameter("mail");
        UserServiceImpl userService = new UserServiceImpl();
        int i = userService.fuzzyAddUser(username, password, phone, mail);
        System.out.println(i);
        if(i==1){
            response.sendRedirect(servletContext.getContextPath()+"/UserFuzzyServlet");
        } else {
            response.sendRedirect(servletContext.getContextPath()+"/after/admin_adduser.jsp");
        }
        System.out.println(servletContext.getContextPath());



    }
}

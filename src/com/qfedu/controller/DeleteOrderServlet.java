package com.qfedu.controller;

import com.qfedu.service.impl.OrderServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/DeleteOrderServlet")
public class DeleteOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String sid = request.getParameter("ordersid");
        System.out.println("test:"+sid);
        int id = Integer.parseInt(sid);
        System.out.println("test:"+id);
        OrderServiceImpl orderService = new OrderServiceImpl();
        orderService.deleteOrderById(id);
       /* response.sendRedirect(servletContext.getContextPath()+"/OrderFuzzySelectServlet");*/
        request.getRequestDispatcher("/OrderFuzzySelectServlet").forward(request,response);
    }
}

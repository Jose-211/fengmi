package com.qfedu.controller;

import com.qfedu.entity.Order;
import com.qfedu.entity.OrderStatus;
import com.qfedu.service.OrderService;
import com.qfedu.service.impl.OrderServiceImpl;
import com.qfedu.util.PageUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet( "/OrderFuzzySelectServlet")
public class OrderFuzzySelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        StringBuffer condition = new StringBuffer();
        String pNo = request.getParameter("pageNo");
        String username = request.getParameter("username");
        String status = request.getParameter("status");
        //request.getParameter("");
        if(username!=null && !"".equals(username)){
            condition.append(" and username like '%"+username+"%'");
        }
        if(status !=null && !"".equals(status)){
            condition.append(" and status='"+status+"'");
        }

        int pageSize=3;
        if(pNo==null){
            pNo="1";
        }
        int pageNo = Integer.parseInt(pNo);
        OrderServiceImpl orderService = new OrderServiceImpl();
        PageUtil pageUtil = new PageUtil();
        int dataCount = orderService.selectOrderCount(condition.toString());
        pageUtil.setPageNo(pageNo);
        pageUtil.setPageSize(pageSize);
        pageUtil.setDataCount(dataCount);
        int pageCount = pageUtil.getPageCount();
        List<OrderStatus> list1 = orderService.selectOrderType();
        List<Order> orders = orderService.SelectOrder(pageNo, pageSize,condition.toString());
        request.setAttribute("type",list1);
        request.setAttribute("pageNo",pageNo);
        request.setAttribute("list",orders);
        request.setAttribute("pageSize",pageSize);
        request.setAttribute("pageCount",pageCount);
        request.getRequestDispatcher("/after/order_processing_list.jsp").forward(request,response);


    }
}

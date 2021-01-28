package com.qfedu.controller;

import com.qfedu.entity.GoodsType;
import com.qfedu.service.impl.GoodsTypeServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet( "/GoodsTypeDeleteServlet")
public class GoodsTypeDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        //删除
        GoodsTypeServiceImpl goodsTypeService = new GoodsTypeServiceImpl();
        List<GoodsType> typeList = goodsTypeService.TypeSelect();
        request.setAttribute("typeList",typeList);
        System.out.println(typeList);
        int i = goodsTypeService.goodsTypeDelete(id);
        System.out.println(i);
        response.sendRedirect(servletContext.getContextPath()+"/GoodsTypeSelectServlet");
    }
}

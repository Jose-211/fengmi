package com.qfedu.controller;

import com.qfedu.dao.impl.GoodsTypeDaoImpl;
import com.qfedu.service.GoodsTypeService;
import com.qfedu.service.impl.GoodsTypeServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/GoodsTypeUpdateServlet")
public class GoodsTypeUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // ServletContext servletContext = request.getServletContext();

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        ServletContext servletContext = request.getServletContext();
        GoodsTypeService goodsTypeService = new GoodsTypeServiceImpl();

        String  strId = request.getParameter("id");
        System.out.println(strId);
        if(strId!=null && !"".equals(strId)) {
            int id = Integer.parseInt(strId);
            String typename = request.getParameter("typename");
            int i = goodsTypeService.updateGoodsType(typename, id);
        }else{
            String typename = request.getParameter("typename");
            int i = goodsTypeService.addGoodsType(typename);
        }

        response.sendRedirect(request.getContextPath() + "/GoodsTypeSelectServlet");


       /* request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String typename = request.getParameter("typename");
        String sid = request.getParameter("id");
      *//*  int id = Integer.parseInt(sid);*//*
        int i=0;
        System.out.println(sid);
        System.out.println(typename);
        GoodsTypeService goodsTypeService = new GoodsTypeServiceImpl();
        if(sid !="" || sid !=null){
            int id = Integer.parseInt(sid);
             i = goodsTypeService.updateGoodsType(typename, id);
             response.sendRedirect(servletContext.getContextPath() + "/GoodsTypeSelectServlet");
// //           request.getRequestDispatcher("/GoodsTypeSelectServlet").forward(request,response);
           *//* GoodsTypeDaoImpl goodsTypeDao = new GoodsTypeDaoImpl();
             i = goodsTypeDao.addGoodsType(typename);*//*
        } else {
            int id = Integer.parseInt(sid);
           i = goodsTypeService.addGoodsType(typename);
            response.sendRedirect(servletContext.getContextPath() + "/GoodsTypeSelectServlet");
// //           request.getRequestDispatcher("/GoodsTypeSelectServlet").forward(request,response);
        }*/

    }
}

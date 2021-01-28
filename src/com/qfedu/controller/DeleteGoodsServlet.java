package com.qfedu.controller;

import com.qfedu.service.impl.GoodsServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteGoodsServlet")
public class DeleteGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String sid = request.getParameter("goodsid");
        String[] split = sid.split(",,");
        GoodsServiceImpl goodsService = new GoodsServiceImpl();
        for (int i = 0; i <split.length ; i++) {
            if(split[i] !=null && !"".equals(split[i])){
                int i1 = goodsService.goodsDeleteById(Integer.parseInt(split[i]));
                System.out.println(i1);
            }

        }

     /*   System.out.println(sid);
        int id = Integer.parseInt(sid);
        System.out.println(id);
        GoodsServiceImpl goodsService = new GoodsServiceImpl();
        goodsService.goodsDeleteById(id);*/
        response.sendRedirect(servletContext.getContextPath()+"/FuzzySelectGoods");


    }
}

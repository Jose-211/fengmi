package com.qfedu.controller;

import com.qfedu.entity.Goods;
import com.qfedu.service.impl.GoodsServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/AddGoodsServlet")
public class AddGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
      /*  request.getRequestDispatcher("/after/add_goods.jsp").forward(request,response);*/
        String sid = request.getParameter("id");
        Goods gd = new Goods();
        GoodsServiceImpl gs = new GoodsServiceImpl();
        String goodsname = request.getParameter("goodsName");
        double price = Double.parseDouble(request.getParameter("price"));
        int typeId = Integer.parseInt(request.getParameter("typeId"));
        String comment = request.getParameter("comment");
        if(sid !=null && !"".equals(sid)){
            int id = Integer.parseInt(sid);
            Object[] obj={goodsname,price,typeId,comment,id};
            for (Object o : obj) {
                System.out.println(o);
            }
            int i = gs.goodsUpdateById(obj);
            System.out.println(i);
            request.getRequestDispatcher("/FuzzySelectGoods").forward(request,response);

        } else {
            Object[] obj={goodsname,price,typeId,comment};
            gs.addGoods(obj);
            response.sendRedirect(servletContext.getContextPath()+"/FuzzySelectGoods");
        }

    }
}

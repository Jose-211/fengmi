package com.qfedu.controller;

import com.qfedu.entity.GoodsType;
import com.qfedu.service.impl.GoodsTypeServiceImpl;
import com.qfedu.util.PageUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet( "/GoodsTypeSelectServlet")
public class GoodsTypeSelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String pNo = request.getParameter("pageNo");


        if(pNo==null){
            pNo="1";
        }
        int pageNo = Integer.parseInt(pNo);
        int pageSize=5;
        GoodsTypeServiceImpl goodsTypeService = new GoodsTypeServiceImpl();
        int count = goodsTypeService.fuzzyDataCount();
        PageUtil pageUtil = new PageUtil();
        pageUtil.setPageNo(pageNo);
        pageUtil.setPageSize(pageSize);
        pageUtil.setDataCount(count);
        int pageCount = pageUtil.getPageCount();
        List<GoodsType> list = goodsTypeService.selectGoodsType(pageNo, pageSize);
        request.setAttribute("list",list);
        request.setAttribute("pageNo",pageNo);
        request.setAttribute("pageCount",pageCount);
        request.getRequestDispatcher("/after/goods_type_list.jsp").forward(request,response);


    }
}

package com.qfedu.controller;

import com.qfedu.entity.Goods;
import com.qfedu.service.impl.GoodsServiceImpl;
import com.qfedu.util.PageUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/FuzzySelectGoods")
public class FuzzySelectGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String pNo = request.getParameter("pageNo");
        String goodsName = request.getParameter("goodsname");
        String deployDate = request.getParameter("deployDate");
        String typeId = request.getParameter("typeId");
        StringBuffer condition = new StringBuffer();

        /*if(goodsName!=null && !"".equals(goodsName) && typeId !=null && !"".equals(typeId)){
            request.setAttribute("goodsName",goodsName);
           // int typeId1 = Integer.parseInt(typeId);
            condition=condition.append("and goodsName like '%"+goodsName+"%'"+ "and typeId='"+typeId+"'");
        } else if (goodsName!=null && !"".equals(goodsName)){
            condition=condition.append("and goodsName like '%"+goodsName+"%'");
        } else if (typeId !=null && !"".equals(typeId)){
            //int typeId1 = Integer.parseInt(typeId);
            condition=condition.append( "and typename='"+typeId+"'");
            request.setAttribute("typeId",typeId);
        }*/
        if(goodsName!=null && !"".equals(goodsName)){
            condition=condition.append("and goodsName like '%"+goodsName+"%' ");
            request.setAttribute("goodsName",goodsName);
        }
        if(typeId!=null && !"".equals(typeId)){
            condition=condition.append("and typeId= "+typeId);
            request.setAttribute("typeId",typeId);
        }
        if (deployDate !=null && !"".equals(deployDate)){
            condition.append(" and deployDate='"+deployDate+"'");
        }
        if(pNo==null){
            pNo="1";
        }
        int pageNo = Integer.parseInt(pNo);
        int pageSize=3;
        GoodsServiceImpl goodsService = new GoodsServiceImpl();
        PageUtil pageUtil = new PageUtil();
        int count = goodsService.fuzzyDataCount(condition.toString());
        pageUtil.setPageNo(pageNo);
        pageUtil.setPageSize(pageSize);
        pageUtil.setDataCount(count);
        int pageCount = pageUtil.getPageCount();
        List<Goods> list = goodsService.fuzzySelectGoods(pageNo, pageSize,condition.toString());
        request.setAttribute("list",list);
        request.setAttribute("pageNo",pageNo);
        request.setAttribute("pageCount",pageCount);
        request.getRequestDispatcher("/after/goods_list.jsp").forward(request,response);


    }
}

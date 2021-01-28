package com.qfedu.controller;

import com.qfedu.entity.User;
import com.qfedu.service.impl.UserServiceImpl;
import com.qfedu.util.PageUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/UserFuzzyServlet")
public class UserFuzzyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = request.getServletContext();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        UserServiceImpl userService = new UserServiceImpl();
        StringBuffer condition = new StringBuffer();
        String username =  request.getParameter("username");
        String sex = request.getParameter("sex");
        System.out.println(username+"--->"+sex);

        if(username !=null && !"".equals(username)){
            request.setAttribute("username",username);
            condition.append("and username like '%"+username+"%'");
        }
        if (sex !=null && !"".equals(sex)){
            request.setAttribute("sex",sex);
            condition.append("and sex='"+sex+"'");
        }
        System.out.println(sex);
        System.out.println(username);
        String pNo = request.getParameter("pageNo");
        if(pNo==null){
            pNo="1";
        }
        int pageNo = Integer.parseInt(pNo);
        int pageSize=3;
        int dataCount = userService.userFuzzyDataCount(condition.toString());
        PageUtil pageUtil = new PageUtil();
        pageUtil.setPageNo(pageNo);
        pageUtil.setPageSize(pageSize);
        pageUtil.setDataCount(dataCount);
        int pageCount = pageUtil.getPageCount();
        List<User> list = userService.fuzzySelectUser(pageNo, pageSize,condition.toString());
        request.setAttribute("list",list);
        request.setAttribute("pageNo",pageNo);
        request.setAttribute("pageCount",pageCount);
        request.getRequestDispatcher("/after/user.jsp").forward(request,response);



    }
}

package com.qfedu.test;


import com.qfedu.dao.impl.UserDaoImpl;
import com.qfedu.service.impl.GoodsTypeServiceImpl;
import com.qfedu.util.BaseDao;

import java.sql.Connection;

public class Demo1 {
    public static void main(String[] args) {
//
        GoodsTypeServiceImpl goodsTypeService = new GoodsTypeServiceImpl();
        int i = goodsTypeService.updateGoodsType("手机", 1);
        System.out.println(i);
       /* int type = goodsTypeService.addGoodsType("运动");
        System.out.println(type);*/

    }

}

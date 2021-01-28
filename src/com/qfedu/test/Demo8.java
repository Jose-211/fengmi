package com.qfedu.test;

import com.qfedu.dao.impl.GoodsDaoImpl;
import com.qfedu.entity.Goods;

import java.util.List;

public class Demo8 {
    public static void main(String[] args) {
        GoodsDaoImpl goodsDao = new GoodsDaoImpl();
        String condition = "and goodsName like %54%";
        //List<Goods> list = goodsDao.fuzzySelectGoods(0, 3, condition);
        List<Goods> list = goodsDao.fuzzySelectGoods(0, 3, condition);
        System.out.println(list);
    }
}

package com.qfedu.test;

import com.qfedu.dao.impl.GoodsDaoImpl;
import com.qfedu.service.impl.GoodsServiceImpl;

public class Demo6 {
    public static void main(String[] args) {
        GoodsServiceImpl goodsService = new GoodsServiceImpl();
        Object[] obj={"1",4,5,"5",55};
        int i = goodsService.goodsUpdateById(obj);
        System.out.println(i);
    }
}

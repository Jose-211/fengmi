package com.qfedu.test;

import com.qfedu.service.impl.GoodsServiceImpl;

public class Demo3 {
    public static void main(String[] args) {
        GoodsServiceImpl goodsService = new GoodsServiceImpl();
        int i = goodsService.goodsDeleteById(48);
        System.out.println(i);


    }
}

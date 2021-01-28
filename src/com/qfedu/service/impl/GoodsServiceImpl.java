package com.qfedu.service.impl;

import com.qfedu.dao.impl.GoodsDaoImpl;
import com.qfedu.entity.Goods;
import com.qfedu.service.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    @Override
    public List<Goods> fuzzySelectGoods(int pageNo, int pageSize,String condition) {
        GoodsDaoImpl goodsDao = new GoodsDaoImpl();
        List<Goods> list = goodsDao.fuzzySelectGoods(pageNo, pageSize,condition);
        return list;
    }

    @Override
    public int fuzzyDataCount(String condition) {
        GoodsDaoImpl goodsDao = new GoodsDaoImpl();
        int count = goodsDao.fuzzyDataCount(condition);
        return count;
    }

    @Override
    public int goodsDeleteById(int id) {
        GoodsDaoImpl goodsDao = new GoodsDaoImpl();
        int i = goodsDao.goodsDeleteById(id);

        return i;
    }

    @Override
    public int goodsUpdateById(Object[] obj) {
        GoodsDaoImpl goodsDao = new GoodsDaoImpl();
        int i = goodsDao.goodsUpdateById(obj);

        return i;
    }

    @Override
    public Goods getGoodsById(int id) {
        Goods goods = new GoodsDaoImpl().getGoodsById(id);
        return goods ;
    }

    @Override
    public int addGoods(Object[] obj) {
        GoodsDaoImpl goodsDao = new GoodsDaoImpl();
        int i = goodsDao.addGoods(obj);
        return i;
    }

}

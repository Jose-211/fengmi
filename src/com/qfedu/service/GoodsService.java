package com.qfedu.service;

import com.qfedu.entity.Goods;

import java.util.List;

public interface GoodsService {
    public List<Goods> fuzzySelectGoods(int pageNo, int pageSize,String condition );
    public int fuzzyDataCount(String condition);
    public int goodsDeleteById(int id);
    public int goodsUpdateById(Object[] obj);
    public Goods getGoodsById(int id);
    public int addGoods(Object[] obj);


}

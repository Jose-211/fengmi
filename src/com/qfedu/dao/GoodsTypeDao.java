package com.qfedu.dao;

import com.qfedu.entity.GoodsType;

import java.util.List;

public interface GoodsTypeDao {
    public List<GoodsType> selectGoodsType(int pageNo, int pageSize);
    public int fuzzyDataCount();
    public List<GoodsType> goodsTypeSelect();
    public int goodsTypeDelete(int id);
    public GoodsType getGoodsTypeById(int id);
    public int addGoodsType(String typename);
    public int updateGoodsType(String typename, int id);
    public List<GoodsType> TypeSelect();
}

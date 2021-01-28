package com.qfedu.service;

import com.qfedu.entity.GoodsType;

import java.util.List;

public interface GoodsTypeService {
    public List<GoodsType> selectGoodsType(int pageNo, int pageSize);
    public int fuzzyDataCount();
    public List<GoodsType> goodsTypeSelect();
    public int goodsTypeDelete(int id);
    public GoodsType getGoodsTypeById(int id);
    public int updateGoodsType(String typename, int id);
    public int addGoodsType(String typename);
    public List<GoodsType> TypeSelect();

}

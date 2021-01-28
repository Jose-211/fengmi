package com.qfedu.service.impl;

import com.qfedu.dao.GoodsTypeDao;
import com.qfedu.dao.impl.GoodsDaoImpl;
import com.qfedu.dao.impl.GoodsTypeDaoImpl;
import com.qfedu.entity.GoodsType;
import com.qfedu.service.GoodsTypeService;

import java.util.List;

public class GoodsTypeServiceImpl implements GoodsTypeService {
    @Override
    public List<GoodsType> selectGoodsType(int pageNo, int pageSize) {
        GoodsTypeDaoImpl goodsTypeDao = new GoodsTypeDaoImpl();
        List<GoodsType> list = goodsTypeDao.selectGoodsType(pageNo, pageSize);

        return list;
    }

    @Override
    public int fuzzyDataCount() {
        GoodsTypeDaoImpl goodsTypeDao = new GoodsTypeDaoImpl();
        int count = goodsTypeDao.fuzzyDataCount();
        return count;
    }

    @Override
    public List<GoodsType> goodsTypeSelect() {
        GoodsTypeDaoImpl goodsTypeDao = new GoodsTypeDaoImpl();
        List<GoodsType> list = goodsTypeDao.goodsTypeSelect();
        return list;

    }

    @Override
    public int goodsTypeDelete(int id) {
        GoodsTypeDaoImpl goodsTypeDao = new GoodsTypeDaoImpl();
        int i = goodsTypeDao.goodsTypeDelete(id);
        return i;
    }

    @Override
    public GoodsType getGoodsTypeById(int id) {
        GoodsTypeDao gs=new GoodsTypeDaoImpl();
        GoodsType gp=gs.getGoodsTypeById(id);
        return gp;
    }
    @Override
    public int addGoodsType(String typename){
        GoodsTypeDaoImpl goodsTypeDao = new GoodsTypeDaoImpl();
        int i = goodsTypeDao.addGoodsType(typename);
        return i;
    }

    @Override
    public List<GoodsType> TypeSelect() {
        GoodsTypeDaoImpl goodsTypeDao = new GoodsTypeDaoImpl();
        List<GoodsType> list = goodsTypeDao.TypeSelect();

        return list;
    }

    @Override
    public int updateGoodsType(String typename, int id){
        GoodsTypeDaoImpl goodsTypeDao = new GoodsTypeDaoImpl();
        int i = goodsTypeDao.updateGoodsType(typename, id);
        return i;

    }


}

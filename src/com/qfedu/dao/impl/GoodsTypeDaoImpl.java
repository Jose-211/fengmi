package com.qfedu.dao.impl;

import com.qfedu.dao.GoodsDao;
import com.qfedu.dao.GoodsTypeDao;
import com.qfedu.entity.Goods;
import com.qfedu.entity.GoodsType;
import com.qfedu.util.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GoodsTypeDaoImpl extends BaseDao implements GoodsTypeDao {

    @Override
    public List<GoodsType> selectGoodsType(int pageNo, int pageSize) {
        String sql = "select * from t_goodstype limit ?,?";
        Object[] obj = {(pageNo - 1) * pageSize, pageSize};
        List<GoodsType> list = new ArrayList<>();
        try {
            ResultSet resultSet = this.select(sql, obj);
            while (resultSet.next()) {
                GoodsType goodsType = new GoodsType();
                goodsType.setId(resultSet.getInt("id"));
                goodsType.setTypename(resultSet.getString("typename"));
                list.add(goodsType);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int fuzzyDataCount() {
        String sql = "select count(1) from t_goodstype";
        Object[] obj = {};
        int count = 0;
        try {
            ResultSet resultSet = this.select(sql, obj);
            while (resultSet.next()) {
                count = resultSet.getInt("count(1)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return count;
    }

    @Override
    public List<GoodsType> goodsTypeSelect() {
        String sql = "select * from t_goodstype";
        Object[] obj = {};
        List<GoodsType> list = new ArrayList<>();
        try {
            ResultSet resultSet = this.select(sql, obj);
            while (resultSet.next()) {
                GoodsType goodsType = new GoodsType();
                goodsType.setId(resultSet.getInt("id"));
                goodsType.setTypename(resultSet.getString("typename"));
                list.add(goodsType);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int goodsTypeDelete(int id) {
        String sql="delete from t_goodstype where id= ?";
        Object[] obj={id};
        int i = this.setUpdate(sql, obj);
        return i;
    }

    @Override
    public GoodsType getGoodsTypeById(int id) {
        String sql = "select * from t_goodstype where id=?";
        Object[] obj = {id};
        GoodsType goodsType = new GoodsType();
        try {
            ResultSet resultSet = this.select(sql, obj);
            while (resultSet.next()) {
                goodsType.setId(resultSet.getInt("id"));
                goodsType.setTypename(resultSet.getString("typename"));
                return goodsType;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return goodsType;
    }

    @Override
    public int addGoodsType(String typename) {
        String sql="insert into t_goodstype(typename) values(?)";
        Object[] obj={typename};
        int i = this.setUpdate(sql, obj);
        return i;
    }
    @Override
    public int updateGoodsType(String typename, int id) {
        String sql="update t_goodstype set typename=? where id=?";
        Object[] obj={typename,id};
        int i = this.setUpdate(sql, obj);
        return i;
    }

    @Override
    public List<GoodsType> TypeSelect() {
        String sql="select * from t_goodstype ";
        Object[] obj={};
      List<GoodsType> list = new ArrayList<>();

        try {
            ResultSet resultSet = this.select(sql, obj);

            while (resultSet.next()){
                GoodsType gt= new GoodsType();
                gt.setId(resultSet.getInt("id"));
                gt.setTypename(resultSet.getString("typename"));
                list.add(gt);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}

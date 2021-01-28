package com.qfedu.dao.impl;

import com.qfedu.dao.GoodsDao;
import com.qfedu.entity.Goods;
import com.qfedu.entity.GoodsType;
import com.qfedu.util.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl extends BaseDao implements GoodsDao {
    @Override
    public List<Goods> fuzzySelectGoods(int pageNo, int pageSize,String condition) {
       /* String sql = "select * from t_goods ,t_goodstype where t_goods.typeId = t_goodstype.id limit ?,?";*/
        String sql = "select * from t_goods inner join t_goodstype on t_goods.typeId = t_goodstype.id where 1=1 "+condition+" limit ?,?";
        Object[] obj = {(pageNo - 1) * pageSize, pageSize};
        List<Goods> list = new ArrayList<>();
        try {
            ResultSet resulSet = this.select(sql, obj);
            while (resulSet.next()) {
                Goods goods = new Goods();
                GoodsType goodsType = new GoodsType();
                goods.setId(resulSet.getInt("id"));
                goods.setGoodsName(resulSet.getString("goodsName"));
                goods.setPrice(resulSet.getDouble("price"));
                goods.setScore(resulSet.getInt("score"));
                goods.setDeployDate(resulSet.getString("deployDate"));
                goods.setImgPath(resulSet.getString("imgPath"));
                goods.setComment(resulSet.getString("comment"));
                goods.setTypeId(resulSet.getInt("typeId"));
                /*goods.setGoodsType(resulSet.getString("goodsType"));*/

                goodsType.setTypename(resulSet.getString("typename"));
                goods.setGoodstype(goodsType);
                list.add(goods);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int fuzzyDataCount(String condition) {
        String sql = "select count(1) from t_goods inner join t_goodstype on t_goods.typeId = t_goodstype.id where 1=1 "+condition;
       /* String sql = "select count(1) from t_goods where 1=1 "+condition;*/
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
    public int goodsDeleteById(int id) {
        String sql = "delete from t_goods where id=?";
        Object[] obj = {id};
        int i = this.setUpdate(sql, obj);
        return i;
    }

    @Override
    public int goodsUpdateById(Object[] obj) {
        String sql = "update t_goods  set goodsName=?,price=?,typeId=?,comment=? where id=?";
        int i = this.setUpdate(sql,obj);
        return i;
    }

    @Override
    public Goods getGoodsById(int id) {
        String sql = "select * from t_goods ,t_goodstype where t_goods.typeId = t_goodstype.id and t_goods.id=?";
        Object[] obj = {id};
        Goods goods = new Goods();
        GoodsType goodsType = new GoodsType();
        try {
            ResultSet resulSet = this.select(sql, obj);
            while (resulSet.next()) {

                goods.setId(resulSet.getInt("id"));
                goods.setGoodsName(resulSet.getString("goodsName"));
                goods.setPrice(resulSet.getDouble("price"));
                goods.setScore(resulSet.getInt("score"));
                goods.setDeployDate(resulSet.getString("deployDate"));
                goods.setImgPath(resulSet.getString("imgPath"));
                goods.setComment(resulSet.getString("comment"));
                goods.setTypeId(resulSet.getInt("typeId"));
                /*goods.setGoodsType(resulSet.getString("goodsType"));*/

                goodsType.setTypename(resulSet.getString("typename"));
                goods.setGoodstype(goodsType);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return goods;

    }

    @Override
    public int addGoods(Object[] obj) {
        String sql="insert into t_goods (goodsName,price,typeId,comment) values (?,?,?,?)";
        int i = this.setUpdate(sql, obj);
        return i;
    }
}

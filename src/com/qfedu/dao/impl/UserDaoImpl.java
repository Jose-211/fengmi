package com.qfedu.dao.impl;

import com.qfedu.dao.UserDao;
import com.qfedu.entity.User;
import com.qfedu.util.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public List<User> fuzzySelectUser(int pageNo, int pageSize, String condition) {
       List<User> list = new ArrayList<>();
        String sql="select * from t_user where 1=1 "+condition+" limit ?,?";
        Object[] obj={(pageNo-1)*pageSize,pageSize};
        try {
            ResultSet resultSet = this.select(sql, obj);
            while(resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setPhone(resultSet.getString("phone"));
                user.setSex(resultSet.getString("sex"));
                user.setMail(resultSet.getString("mail"));
                list.add(user);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int  userFuzzyDataCount(String condition) {
        String sql="select count(1) from t_user where 1=1 "+ condition;
        Object[] obj={};
        int count=0;
        try {
            ResultSet resultSet = super.select(sql, obj);
            while(resultSet.next()){
                count = resultSet.getInt("count(1)");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return count ;
    }

    @Override
    public int fuzzyDeleteUser(int id) {
        String sql="delete from t_user where id=?";
        Object[] obj={id};
        int i = this.setUpdate(sql, obj);
        return i;
    }

    @Override
    public int fuzzyResetUser(int id) {
        String sql="update t_user set password='123456' where id=?";
        Object[] obj={id};
        int i = this.setUpdate(sql, obj);
        return i;
    }

    @Override
    public int fuzzyAddUser(String username, String password, String phone, String mail) {
        String sql="insert into t_user (username,password,phone,mail) values(?,?,?,?)";
        Object[] obj={username,password,phone,mail};
        int i = this.setUpdate(sql, obj);
        return i;
    }
}

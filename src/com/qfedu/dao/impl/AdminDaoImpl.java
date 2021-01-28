package com.qfedu.dao.impl;

import com.qfedu.dao.AdminDao;
import com.qfedu.entity.Admin;
import com.qfedu.util.BaseDao;

import java.sql.ResultSet;

public class AdminDaoImpl extends BaseDao implements AdminDao {
    @Override
    public boolean login(Admin ad) {
        boolean flag=false;
        String sql="select * from admin where username=? and password=?";
        Object[] obj ={ad.getUsername(),ad.getPassword()};
        try {
            ResultSet select = this.select(sql, obj);

           while(select.next()){
                flag=true;
           }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;

    }
}

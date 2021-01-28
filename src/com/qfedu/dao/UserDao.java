package com.qfedu.dao;

import com.qfedu.entity.User;

import java.util.List;

public interface UserDao {
    public List<User> fuzzySelectUser(int pageNo, int pageSize, String condition);
    public int userFuzzyDataCount(String condition);
    public int fuzzyDeleteUser(int id);
    public int fuzzyResetUser(int id);
    public int fuzzyAddUser(String username, String password,String phone, String mail);

}

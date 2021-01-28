package com.qfedu.service.impl;

import com.qfedu.dao.UserDao;
import com.qfedu.dao.impl.UserDaoImpl;
import com.qfedu.entity.User;
import com.qfedu.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public List<User> fuzzySelectUser(int pageNo, int pageSize, String condition) {
        UserDao userDao = new UserDaoImpl();
        List<User> list = userDao.fuzzySelectUser(pageNo, pageSize, condition);

        return list;
    }

    @Override
    public int userFuzzyDataCount(String condition) {
        UserDaoImpl userDao = new UserDaoImpl();
        int count = userDao.userFuzzyDataCount(condition);

        return count;
    }

    @Override
    public int fuzzyDeleteUser(int id) {
        UserDaoImpl userDao = new UserDaoImpl();
        int i = userDao.fuzzyDeleteUser(id);

        return i;
    }

    @Override
    public int fuzzyResetUser(int id) {
        UserDaoImpl userDao = new UserDaoImpl();
        int i = userDao.fuzzyResetUser(id);

        return i;
    }

    @Override
    public int fuzzyAddUser(String username, String password, String phone, String mail) {
        UserDaoImpl userDao = new UserDaoImpl();
        int i = userDao.fuzzyAddUser(username, password, phone, mail);

        return i;
    }

}

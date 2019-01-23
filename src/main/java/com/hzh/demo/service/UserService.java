package com.hzh.demo.service;

import com.hzh.demo.mapper.UserDao;
import com.hzh.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public User GetUserByID(String id){
        User user = userDao.GetUserByID(id);
        return user;
    }
}

package com.hzh.service;

import com.hzh.mapper.UserDao;
import com.hzh.model.User;
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

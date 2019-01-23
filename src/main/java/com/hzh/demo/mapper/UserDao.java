package com.hzh.demo.mapper;

import com.hzh.demo.model.User;

public interface UserDao {
    User GetUserByID(String id);
}

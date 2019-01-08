package com.hzh.mapper;

import com.hzh.model.User;

public interface UserDao {
    User GetUserByID(String id);
}

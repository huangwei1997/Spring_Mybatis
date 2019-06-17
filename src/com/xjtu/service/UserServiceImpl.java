package com.xjtu.service;

import com.xjtu.mapper.UserMapper;
import com.xjtu.pojo.User;

public class UserServiceImpl implements UserService {
    private UserMapper userMapper;
    @Override
    public User checkUserInfoService(String uname, String pwd) {
        //使用对象完成数据库操作
        return userMapper.selectUser(uname,pwd);
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}

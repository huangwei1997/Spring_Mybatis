package com.xjtu.mapper;

import com.xjtu.pojo.User;

public interface UserMapper {
    //用户登录
    User selectUser(String uname, String pwd);
}

package com.spring.service.impl;

import com.spring.mapper.UserMapper;
import com.spring.service.UserService;

/**
 * @author Wang Hao
 * @date 2022/9/25 22:19
 * @description 业务逻辑层实现类
 */
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    public UserServiceImpl() {
        System.out.println("UserService被创建了");
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void add() {
        System.out.println("UserService...");
        userMapper.add();
    }
}

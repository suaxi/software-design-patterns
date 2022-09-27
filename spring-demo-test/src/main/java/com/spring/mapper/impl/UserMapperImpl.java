package com.spring.mapper.impl;

import com.spring.mapper.UserMapper;

/**
 * @author Wang Hao
 * @date 2022/9/25 22:17
 * @description 数据访问层实现类
 */
public class UserMapperImpl implements UserMapper {

    private String name;
    private String password;

    public UserMapperImpl() {
        System.out.println("UserMapper被创建了");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void add() {
        System.out.println("UserMapper..." + "name: " + name + ",password: " + password);
    }
}

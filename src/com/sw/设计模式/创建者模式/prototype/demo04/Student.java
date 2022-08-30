package com.sw.设计模式.创建者模式.prototype.demo04;

import java.io.Serializable;

/**
 * @author Wang Hao
 * @date 2022/8/30 22:28
 * @description 学生类
 */
public class Student implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}

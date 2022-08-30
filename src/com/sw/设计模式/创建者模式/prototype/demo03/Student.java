package com.sw.设计模式.创建者模式.prototype.demo03;

/**
 * @author Wang Hao
 * @date 2022/8/30 22:28
 * @description 学生类
 */
public class Student {

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

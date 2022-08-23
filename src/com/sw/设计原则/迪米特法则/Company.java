package com.sw.设计原则.迪米特法则;

/**
 * @author Wang Hao
 * @date 2022/8/23 21:33
 * @description 媒体公司类
 */
public class Company {

    private String name;

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

package com.sw.设计原则.迪米特法则;

/**
 * @author Wang Hao
 * @date 2022/8/23 21:33
 * @description 粉丝类
 */
public class Fans {

    private String name;

    public Fans(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

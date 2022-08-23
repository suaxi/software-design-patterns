package com.sw.设计原则.迪米特法则;

/**
 * @author Wang Hao
 * @date 2022/8/23 21:33
 * @description 明星类
 */
public class Star {

    private String name;

    public Star(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

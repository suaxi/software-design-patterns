package com.sw.设计模式.singleton.hungry.demo02;

/**
 * @author Wang Hao
 * @date 2022/8/24 21:56
 * @description 饿汉式（静态代码块）
 */
public class Singleton {

    private Singleton() {

    }

    private static Singleton instance;

    static {
        instance = new Singleton();
    }

    public static Singleton getInstance() {
        return instance;
    }
}

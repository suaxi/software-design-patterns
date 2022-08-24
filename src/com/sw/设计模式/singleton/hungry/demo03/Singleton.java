package com.sw.设计模式.singleton.hungry.demo03;

/**
 * @author Wang Hao
 * @date 2022/8/24 22:10
 * @description 懒汉式（线程不安全）
 */
public class Singleton {

    private Singleton() {

    }

    private static Singleton instance;

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

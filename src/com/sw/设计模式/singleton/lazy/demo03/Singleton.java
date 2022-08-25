package com.sw.设计模式.singleton.lazy.demo03;

/**
 * @author Wang Hao
 * @date 2022/8/24 22:33
 * @description 懒汉式（静态内部类）
 */
public class Singleton {

    private Singleton() {

    }

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

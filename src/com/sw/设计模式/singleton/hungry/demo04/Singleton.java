package com.sw.设计模式.singleton.hungry.demo04;

/**
 * @author Wang Hao
 * @date 2022/8/24 22:21
 * @description 懒汉式（双重检测锁）
 */
public class Singleton {

    private Singleton() {

    }

    //volatile保证可见性和防止指令重排
    private static volatile Singleton instance;

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

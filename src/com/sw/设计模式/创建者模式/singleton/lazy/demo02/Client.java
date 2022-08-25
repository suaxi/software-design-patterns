package com.sw.设计模式.创建者模式.singleton.lazy.demo02;

/**
 * @author Wang Hao
 * @date 2022/8/24 22:24
 */
public class Client {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();

        System.out.println(instance == instance1);
    }
}

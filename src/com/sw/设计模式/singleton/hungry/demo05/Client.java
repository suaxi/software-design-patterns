package com.sw.设计模式.singleton.hungry.demo05;

/**
 * @author Wang Hao
 * @date 2022/8/24 22:36
 */
public class Client {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();

        System.out.println(instance == instance1);
    }
}

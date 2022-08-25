package com.sw.设计模式.singleton.lazy.demo01;

/**
 * @author Wang Hao
 * @date 2022/8/24 22:13
 */
public class Client {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();

        //多线程操作时，存在线程不安全的问题
        System.out.println(instance == instance1);
    }
}

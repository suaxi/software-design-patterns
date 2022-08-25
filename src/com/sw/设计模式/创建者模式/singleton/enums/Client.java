package com.sw.设计模式.创建者模式.singleton.enums;

/**
 * @author Wang Hao
 * @date 2022/8/25 21:46
 */
public class Client {
    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;
        Singleton instance1 = Singleton.INSTANCE;

        //true
        System.out.println(instance == instance1);
    }
}

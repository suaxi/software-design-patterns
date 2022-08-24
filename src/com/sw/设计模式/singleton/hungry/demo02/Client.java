package com.sw.设计模式.singleton.hungry.demo02;

/**
 * @author Wang Hao
 * @date 2022/8/24 21:58
 */
public class Client {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();

        //true
        System.out.println(instance == instance1);
    }
}

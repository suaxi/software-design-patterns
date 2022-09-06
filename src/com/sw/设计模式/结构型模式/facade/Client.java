package com.sw.设计模式.结构型模式.facade;

/**
 * @author Wang Hao
 * @date 2022/9/6 22:39
 */
public class Client {
    public static void main(String[] args) {
        SmartApplicationFacade smartApplicationFacade = new SmartApplicationFacade();
        smartApplicationFacade.say("开灯");
        System.out.println("==========================");
        smartApplicationFacade.say("关电视");
    }
}

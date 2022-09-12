package com.sw.设计模式.行为型模式.strategy;

/**
 * @author Wang Hao
 * @date 2022/9/12 22:06
 */
public class Client {
    public static void main(String[] args) {
        //促销活动A
        SalesMan salesMan = new SalesMan(new StrategyA());
        salesMan.salesManShow();

        System.out.println("=======================");
        //促销活动B
        salesMan.setStrategy(new StrategyB());
        salesMan.salesManShow();

        System.out.println("=======================");
        //促销活动C
        salesMan.setStrategy(new StrategyC());
        salesMan.salesManShow();
    }
}

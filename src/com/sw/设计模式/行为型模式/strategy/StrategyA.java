package com.sw.设计模式.行为型模式.strategy;

/**
 * @author Wang Hao
 * @date 2022/9/12 22:03
 * @description 具体策略类
 */
public class StrategyA implements Strategy {

    @Override
    public void show() {
        System.out.println("促销活动A");
    }
}

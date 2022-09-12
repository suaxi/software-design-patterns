package com.sw.设计模式.行为型模式.strategy;

/**
 * @author Wang Hao
 * @date 2022/9/12 22:04
 * @description 促销员（环境类）
 */
public class SalesMan {

    private Strategy strategy;

    public SalesMan(Strategy strategy) {
        this.strategy = strategy;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 促销员展示促销活动
     */
    public void salesManShow() {
        strategy.show();
    }
}

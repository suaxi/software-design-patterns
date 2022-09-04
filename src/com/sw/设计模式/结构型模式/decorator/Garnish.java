package com.sw.设计模式.结构型模式.decorator;

/**
 * @author Wang Hao
 * @date 2022/9/4 21:09
 * @description 装饰者（抽象装饰者角色）
 */
public abstract class Garnish extends FastFood {

    private FastFood fastFood;

    public Garnish(FastFood fastFood, float price, String desc) {
        super(price, desc);
        this.fastFood = fastFood;
    }

    public FastFood getFastFood() {
        return fastFood;
    }

    public void setFastFood(FastFood fastFood) {
        this.fastFood = fastFood;
    }
}

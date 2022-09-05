package com.sw.设计模式.结构型模式.decorator;

/**
 * @author Wang Hao
 * @date 2022/9/4 21:11
 * @description 鸡蛋（具体装饰者角色）
 */
public class Egg extends Garnish {

    public Egg(FastFood fastFood) {
        super(fastFood, 1, "鸡蛋");
    }

    @Override
    public float cost() {
        //价格：鸡蛋 + 快餐的价格
        return getPrice() + getFastFood().cost();
    }

    @Override
    public String getDesc() {
        //描述：鸡蛋 + 具体的快餐
        return getDesc() + getFastFood().getDesc();
    }
}

package com.sw.设计模式.结构型模式.decorator;

/**
 * @author Wang Hao
 * @date 2022/9/4 21:11
 * @description 培根（具体装饰者角色）
 */
public class Bacon extends Garnish {

    public Bacon(FastFood fastFood) {
        super(fastFood, 2, "培根");
    }

    @Override
    public float cost() {
        //价格：培根 + 快餐的价格
        return super.getPrice() + super.getFastFood().cost();
    }

    @Override
    public String getDesc() {
        //描述：培根 + 具体的快餐
        return super.getDesc() + super.getFastFood().getDesc();
    }
}

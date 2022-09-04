package com.sw.设计模式.结构型模式.decorator;

/**
 * @author Wang Hao
 * @date 2022/9/4 21:07
 * @description 炒面（具体构建角色）
 */
public class FriedNoodles extends FastFood {

    public FriedNoodles() {
        super(8, "炒面");
    }

    @Override
    public float cost() {
        return super.getPrice();
    }
}

package com.sw.设计模式.创建者模式.factory.abstractFactory;

/**
 * @author Wang Hao
 * @date 2022/8/28 21:20
 * @description 美式甜品工厂，可以生产美式咖啡、抹茶慕斯
 */
public class AmericanDessertFactory implements DessertFactory {

    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new MatchaMousse();
    }
}

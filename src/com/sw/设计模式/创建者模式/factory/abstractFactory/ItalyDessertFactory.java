package com.sw.设计模式.创建者模式.factory.abstractFactory;

/**
 * @author Wang Hao
 * @date 2022/8/28 21:20
 * @description 意大利风味甜品工厂，可以生产拿铁咖啡、提拉米苏
 */
public class ItalyDessertFactory implements DessertFactory {

    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new Tiramisu();
    }
}

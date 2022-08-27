package com.sw.设计模式.创建者模式.factory.factoryMethod;

/**
 * @author Wang Hao
 * @date 2022/8/27 20:48
 */
public class CoffeeStore {

    private CoffeeFactory factory;

    public void setFactory(CoffeeFactory factory) {
        this.factory = factory;
    }

    public Coffee orderCoffee() {
        Coffee coffee = factory.createCoffee();
        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}

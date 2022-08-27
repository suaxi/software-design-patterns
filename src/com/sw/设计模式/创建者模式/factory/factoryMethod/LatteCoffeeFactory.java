package com.sw.设计模式.创建者模式.factory.factoryMethod;

/**
 * @author Wang Hao
 * @date 2022/8/27 22:22
 * @description 拿铁咖啡工厂
 */
public class LatteCoffeeFactory implements CoffeeFactory {

    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }
}

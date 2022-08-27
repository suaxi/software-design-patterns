package com.sw.设计模式.创建者模式.factory.simpleFactory;

/**
 * @author Wang Hao
 * @date 2022/8/27 21:16
 * @description 简单咖啡工厂类
 */
public class SimpleCoffeeFactory {

    public Coffee createCoffee(String type) {
        //声明coffee类型的变量，根据不同类型创建不同的coffee子类
        Coffee coffee = null;
        if ("american".equals(type)) {
            coffee = new AmericanCoffee();
        } else if ("latte".equals(type)) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("该类型的咖啡暂未上架");
        }
        return coffee;
    }
}

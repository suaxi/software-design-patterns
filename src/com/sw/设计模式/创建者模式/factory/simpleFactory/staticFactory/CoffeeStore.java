package com.sw.设计模式.创建者模式.factory.simpleFactory.staticFactory;

/**
 * @author Wang Hao
 * @date 2022/8/27 20:48
 */
public class CoffeeStore {

    public Coffee orderCoffee(String type) {
        //通过简单工厂生产咖啡
        Coffee coffee = SimpleCoffeeFactory.createCoffee(type);

        //加配料
        coffee.addSugar();
        coffee.addMilk();
        return coffee;
    }
}

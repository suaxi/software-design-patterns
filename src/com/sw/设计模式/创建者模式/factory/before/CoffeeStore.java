package com.sw.设计模式.创建者模式.factory.before;

/**
 * @author Wang Hao
 * @date 2022/8/27 20:48
 */
public class CoffeeStore {

    public Coffee orderCoffee(String type) {
        //声明coffee类型的变量，根据不同类型创建不同的coffee子类
        Coffee coffee = null;
        if ("american".equals(type)) {
            coffee = new AmericanCoffee();
        } else if ("latte".equals(type)) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("该类型的咖啡暂未上架");
        }

        //加配料
        coffee.addSugar();
        coffee.addMilk();
        return coffee;
    }
}

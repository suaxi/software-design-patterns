package com.sw.设计模式.创建者模式.factory.simpleFactory;

/**
 * @author Wang Hao
 * @date 2022/8/27 21:24
 */
public class Client {
    public static void main(String[] args) {
        CoffeeStore coffeeStore = new CoffeeStore();
        Coffee coffee = coffeeStore.orderCoffee("american");
        System.out.println(coffee.getName());
    }
}

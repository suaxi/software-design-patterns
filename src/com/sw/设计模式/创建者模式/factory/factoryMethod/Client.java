package com.sw.设计模式.创建者模式.factory.factoryMethod;

/**
 * @author Wang Hao
 * @date 2022/8/27 22:26
 */
public class Client {
    public static void main(String[] args) {
        //咖啡店
        CoffeeStore store = new CoffeeStore();
        //咖啡工厂
        //AmericanCoffeeFactory factory = new AmericanCoffeeFactory();
        LatteCoffeeFactory factory = new LatteCoffeeFactory();
        store.setFactory(factory);
        //点咖啡
        Coffee coffee = store.orderCoffee();
        System.out.println(coffee.getName());
    }
}

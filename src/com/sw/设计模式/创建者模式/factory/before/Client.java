package com.sw.设计模式.创建者模式.factory.before;

/**
 * @author Wang Hao
 * @date 2022/8/27 20:51
 */
public class Client {
    public static void main(String[] args) {
        //咖啡店
        CoffeeStore coffeeStore = new CoffeeStore();
        //点咖啡
        Coffee coffee = coffeeStore.orderCoffee("latte");
        System.out.println(coffee.getName());
    }
}

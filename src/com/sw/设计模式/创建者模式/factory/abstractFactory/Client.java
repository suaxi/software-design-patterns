package com.sw.设计模式.创建者模式.factory.abstractFactory;

/**
 * @author Wang Hao
 * @date 2022/8/28 21:23
 */
public class Client {
    public static void main(String[] args) {
        //意大利风味甜品工厂
        ItalyDessertFactory factory = new ItalyDessertFactory();
        //拿铁
        Coffee coffee = factory.createCoffee();
        //提拉米苏
        Dessert dessert = factory.createDessert();

        System.out.println(coffee.getName());
        dessert.show();
    }
}

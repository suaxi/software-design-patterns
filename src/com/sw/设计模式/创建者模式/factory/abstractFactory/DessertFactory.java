package com.sw.设计模式.创建者模式.factory.abstractFactory;

/**
 * @author Wang Hao
 * @date 2022/8/28 21:18
 * @description 甜品工厂
 */
public interface DessertFactory {

    /**
     * 生产咖啡
     *
     * @return
     */
    Coffee createCoffee();

    /**
     * 生产甜品
     *
     * @return
     */
    Dessert createDessert();
}

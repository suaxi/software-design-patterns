package com.sw.设计模式.创建者模式.factory.factoryMethod;

/**
 * @author Wang Hao
 * @date 2022/8/27 22:21
 * @description 抽象工厂
 */
public interface CoffeeFactory {

    /**
     * 创建咖啡对象
     *
     * @return
     */
    Coffee createCoffee();
}

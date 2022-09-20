package com.sw.设计模式.行为型模式.visitor;

/**
 * @author Wang Hao
 * @date 2022/9/20 22:03
 * @description 抽象访问者
 */
public interface Person {

    /**
     * 喂猫
     *
     * @param cat 猫
     */
    void feed(Cat cat);


    /**
     * 喂狗
     *
     * @param dog 狗
     */
    void feed(Dog dog);
}

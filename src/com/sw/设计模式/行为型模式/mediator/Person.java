package com.sw.设计模式.行为型模式.mediator;

/**
 * @author Wang Hao
 * @date 2022/9/18 22:02
 * @description 抽象同事类
 */
public abstract class Person {

    protected String name;
    protected Mediator mediator;

    public Person(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }
}

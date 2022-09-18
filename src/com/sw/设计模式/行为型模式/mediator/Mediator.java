package com.sw.设计模式.行为型模式.mediator;

/**
 * @author Wang Hao
 * @date 2022/9/18 22:01
 * @description 抽象中介者
 */
public abstract class Mediator {

    /**
     * 交流
     *
     * @param message 信息
     * @param person  抽象同事类
     */
    public abstract void contact(String message, Person person);
}

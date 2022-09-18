package com.sw.设计模式.行为型模式.mediator;

/**
 * @author Wang Hao
 * @date 2022/9/18 22:03
 * @description 租房者（具体同事类）
 */
public class Tenant extends Person {

    public Tenant(String name, Mediator mediator) {
        super(name, mediator);
    }

    /**
     * 与中介沟通
     *
     * @param message 信息
     */
    public void contact(String message) {
        mediator.contact(message, this);
    }

    /**
     * 获取信息
     *
     * @param message 信息
     */
    public void getMessage(String message) {
        System.out.println("租房者获取到的信息：" + message);
    }
}

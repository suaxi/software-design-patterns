package com.sw.设计模式.行为型模式.mediator;

/**
 * @author Wang Hao
 * @date 2022/9/18 22:03
 * @description 房东（具体同事类）
 */
public class HouseOwner extends Person {

    public HouseOwner(String name, Mediator mediator) {
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
        System.out.println("房东获取到的信息：" + message);
    }
}

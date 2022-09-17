package com.sw.设计模式.行为型模式.observer;

/**
 * @author Wang Hao
 * @date 2022/9/17 23:21
 * @description 具体观察者
 */
public class User implements Observer {

    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "接收到消息：" + message);
    }
}

package com.sw.设计模式.结构型模式.facade;

/**
 * @author Wang Hao
 * @date 2022/9/6 22:33
 * @description 智能音箱（外观角色）
 */
public class SmartApplicationFacade {

    private Light light;
    private TV tv;
    private AirCondition airCondition;

    public SmartApplicationFacade() {
        light = new Light();
        tv = new TV();
        airCondition = new AirCondition();
    }

    public void say(String message) {
        if (message.contains("开")) {
            on();
        } else if (message.contains("关")) {
            off();
        } else {
            System.out.println("主人，你在说什么？");
        }
    }

    private void on() {
        //一键打开
        light.on();
        tv.on();
        airCondition.on();
    }

    private void off() {
        light.off();
        tv.off();
        airCondition.off();
    }
}

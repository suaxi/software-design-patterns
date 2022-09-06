package com.sw.设计模式.结构型模式.facade;

/**
 * @author Wang Hao
 * @date 2022/9/6 22:32
 * @description 电灯（子系统角色）
 */
public class Light {

    public void on() {
        System.out.println("开灯");
    }

    public void off() {
        System.out.println("关灯");
    }
}

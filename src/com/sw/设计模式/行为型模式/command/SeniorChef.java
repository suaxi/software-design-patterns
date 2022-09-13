package com.sw.设计模式.行为型模式.command;

/**
 * @author Wang Hao
 * @date 2022/9/13 22:33
 * @description 厨师（实现者/接收者）
 */
public class SeniorChef {

    public void makeFood(String foodName, int num) {
        System.out.println("制作了" + num + "份 " + foodName);
    }
}

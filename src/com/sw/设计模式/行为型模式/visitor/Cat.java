package com.sw.设计模式.行为型模式.visitor;

/**
 * @author Wang Hao
 * @date 2022/9/20 22:04
 * @description 猫（具体元素）
 */
public class Cat implements Animal {

    @Override
    public void accept(Person person) {
        person.feed(this);
        System.out.println("喂猫吃猫粮");
    }
}

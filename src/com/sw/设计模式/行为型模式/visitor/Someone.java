package com.sw.设计模式.行为型模式.visitor;

/**
 * @author Wang Hao
 * @date 2022/9/20 22:08
 * @description 具体访问者
 */
public class Someone implements Person {

    @Override
    public void feed(Cat cat) {
        System.out.println("客人喂猫");
    }

    @Override
    public void feed(Dog dog) {
        System.out.println("客人喂狗");
    }
}

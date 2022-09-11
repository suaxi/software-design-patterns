package com.sw.设计模式.行为型模式.template;

/**
 * @author Wang Hao
 * @date 2022/9/11 22:52
 * @description 炒菜心（具体类）
 */
public class ConcreteClass_CaiXin extends AbstractClass {

    @Override
    public void pourVegetable() {
        System.out.println("放入菜心");
    }

    @Override
    public void pourSauce() {
        System.out.println("放入蒜瓣");
    }
}

package com.sw.设计模式.行为型模式.template;

/**
 * @author Wang Hao
 * @date 2022/9/11 22:52
 * @description 炒包菜（具体类）
 */
public class ConcreteClass_BaoCai extends AbstractClass {

    @Override
    public void pourVegetable() {
        System.out.println("放入包菜");
    }

    @Override
    public void pourSauce() {
        System.out.println("放入辣椒");
    }
}

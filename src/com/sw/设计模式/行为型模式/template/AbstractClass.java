package com.sw.设计模式.行为型模式.template;

/**
 * @author Wang Hao
 * @date 2022/9/11 22:47
 * @description 抽象类（定义模板方法、抽象方法）
 */
public abstract class AbstractClass {

    /**
     * 模板方法
     */
    public final void cookProcess() {
        pourOil();
        heatOil();
        pourVegetable();
        pourSauce();
        fry();
    }

    public void pourOil() {
        System.out.println("倒油");
    }

    public void heatOil() {
        System.out.println("热油");
    }

    /**
     * 倒蔬菜
     */
    public abstract void pourVegetable();

    /**
     * 放调料
     */
    public abstract void pourSauce();

    public void fry() {
        System.out.println("准备完毕，开始炒菜");
    }
}

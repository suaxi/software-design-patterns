package com.sw.设计模式.创建者模式.factory.abstractFactory;

/**
 * @author Wang Hao
 * @date 2022/8/27 20:44
 * @description 咖啡类
 */
public abstract class Coffee {

    /**
     * 获取咖啡名字
     *
     * @return
     */
    public abstract String getName();

    public void addSugar() {
        System.out.println("加糖");
    }

    public void addMilk() {
        System.out.println("加奶");
    }
}

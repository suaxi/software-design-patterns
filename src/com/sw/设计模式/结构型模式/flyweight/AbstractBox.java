package com.sw.设计模式.结构型模式.flyweight;

/**
 * @author Wang Hao
 * @date 2022/9/8 22:09
 * @description 抽象盒子（抽象享元角色）
 */
public abstract class AbstractBox {

    /**
     * 获取图像
     *
     * @return
     */
    public abstract String getShape();

    public void display(String color) {
        System.out.println("方块形状：" + getShape() + "，颜色：" + color);
    }
}

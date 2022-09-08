package com.sw.设计模式.结构型模式.flyweight;

/**
 * @author Wang Hao
 * @date 2022/9/8 22:17
 */
public class Client {
    public static void main(String[] args) {
        //获取I型盒子
        AbstractBox boxI = BoxFactory.getInstance().getShape("I");
        boxI.display("灰色");

        //获取L型盒子
        AbstractBox boxL = BoxFactory.getInstance().getShape("L");
        boxL.display("蓝色");

        //获取O型盒子
        AbstractBox boxO1 = BoxFactory.getInstance().getShape("O");
        boxO1.display("绿色");

        //获取O图形
        AbstractBox boxO2 = BoxFactory.getInstance().getShape("O");
        boxO2.display("红色");

        //验证两个O型盒子是否为同一对象
        System.out.println("两个O型盒子是否为同一对象:" + (boxO1 == boxO2));
    }
}

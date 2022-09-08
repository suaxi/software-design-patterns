package com.sw.设计模式.结构型模式.flyweight;

/**
 * @author Wang Hao
 * @date 2022/9/8 22:12
 * @description O型盒子（具体享元角色）
 */
public class OBox extends AbstractBox {
    @Override
    public String getShape() {
        return "O";
    }
}

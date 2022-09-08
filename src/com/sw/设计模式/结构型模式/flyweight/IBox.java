package com.sw.设计模式.结构型模式.flyweight;

/**
 * @author Wang Hao
 * @date 2022/9/8 22:12
 * @description I型盒子（具体享元角色）
 */
public class IBox extends AbstractBox {
    @Override
    public String getShape() {
        return "I";
    }
}

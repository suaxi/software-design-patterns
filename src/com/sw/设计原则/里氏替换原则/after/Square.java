package com.sw.设计原则.里氏替换原则.after;

/**
 * @author Wang Hao
 * @date 2022/8/20 22:14
 * @description 正方形类
 */
public class Square implements Quadrilateral {

    private double side;

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getLength() {
        return side;
    }

    @Override
    public double getWidth() {
        return side;
    }
}

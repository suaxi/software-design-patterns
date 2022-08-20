package com.sw.设计原则.里氏替换原则.after;

/**
 * @author Wang Hao
 * @date 2022/8/20 22:15
 * @description 长方形类
 */
public class Rectangle implements Quadrilateral {

    private double length;
    private double width;

    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double getLength() {
        return length;
    }

    @Override
    public double getWidth() {
        return width;
    }
}

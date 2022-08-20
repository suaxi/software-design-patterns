package com.sw.设计原则.里氏替换原则.before;

/**
 * @author Wang Hao
 * @date 2022/8/20 21:46
 * @description 正方形类
 */
public class Square extends Rectangle {
    @Override
    public void setLength(double length) {
        super.setLength(length);
        super.setWidth(length);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        super.setLength(width);
    }
}

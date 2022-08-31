package com.sw.设计模式.创建者模式.Builder.demo01;

/**
 * @author Wang Hao
 * @date 2022/8/31 22:20
 * @description 单车（具体产品）
 */
public class Bike {

    private String frame;

    private String seat;

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
}

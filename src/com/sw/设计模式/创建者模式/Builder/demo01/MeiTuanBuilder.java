package com.sw.设计模式.创建者模式.Builder.demo01;

/**
 * @author Wang Hao
 * @date 2022/8/31 22:23
 * @description 具体构建者，生产美团牌单车
 */
public class MeiTuanBuilder extends Builder {

    @Override
    public void buildFrame() {
        bike.setFrame("美团牌车架");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("美团牌车座");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}

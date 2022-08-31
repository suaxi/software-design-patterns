package com.sw.设计模式.创建者模式.Builder.demo01;

/**
 * @author Wang Hao
 * @date 2022/8/31 22:27
 * @description 指导者类
 */
public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    /**
     * 组装自行车
     */
    public Bike construct() {
        builder.buildFrame();
        builder.buildSeat();
        return builder.createBike();
    }
}

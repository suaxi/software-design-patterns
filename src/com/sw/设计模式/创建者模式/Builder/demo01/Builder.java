package com.sw.设计模式.创建者模式.Builder.demo01;

/**
 * @author Wang Hao
 * @date 2022/8/31 22:21
 */
public abstract class Builder {

    protected Bike bike = new Bike();

    /**
     * 生产车架
     */
    public abstract void buildFrame();

    /**
     * 生产车座
     */
    public abstract void buildSeat();

    /**
     * 生产自行车
     *
     * @return
     */
    public abstract Bike createBike();

    public Bike construct() {
        this.buildFrame();
        this.buildSeat();
        return this.createBike();
    }
}

package com.sw.设计模式.结构型模式.decorator;

/**
 * @author Wang Hao
 * @date 2022/9/4 21:05
 * @description 抽象快餐类（抽象构建角色）
 */
public abstract class FastFood {

    private float price;
    private String desc;

    public FastFood() {
    }

    public FastFood(float price, String desc) {
        this.price = price;
        this.desc = desc;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * 计算价格
     *
     * @return
     */
    public abstract float cost();
}

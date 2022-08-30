package com.sw.设计模式.创建者模式.prototype.demo01;

/**
 * @author Wang Hao
 * @date 2022/8/30 22:07
 * @description 具体原型类
 */
public class Realizetype implements Cloneable {

    public Realizetype() {
        System.out.println("具体原型对象创建完成");
    }

    @Override
    public Realizetype clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制成功");
        return (Realizetype) super.clone();
    }
}

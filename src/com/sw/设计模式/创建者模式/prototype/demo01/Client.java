package com.sw.设计模式.创建者模式.prototype.demo01;

/**
 * @author Wang Hao
 * @date 2022/8/30 22:09
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        //创建原型对象
        Realizetype realizetype = new Realizetype();
        //调用clone方法进行对象的克隆
        Realizetype realizetype1 = realizetype.clone();

        //具体原型对象创建完成
        //具体原型复制成功
        //false
        System.out.println(realizetype == realizetype1);
    }
}

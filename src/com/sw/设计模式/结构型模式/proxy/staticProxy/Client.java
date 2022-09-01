package com.sw.设计模式.结构型模式.proxy.staticProxy;

/**
 * @author Wang Hao
 * @date 2022/9/1 22:46
 * @description 访问对象
 */
public class Client {
    public static void main(String[] args) {
        //创建代售点
        ProxyPoint proxyPoint = new ProxyPoint();
        //顾客从代售点买票
        proxyPoint.sell();
    }
}

package com.sw.设计模式.结构型模式.proxy.CGLibProxy;

/**
 * @author Wang Hao
 * @date 2022/9/2 23:39
 */
public class Client {
    public static void main(String[] args) {
        //代理工厂
        ProxyFactory proxyFactory = new ProxyFactory();
        //获取代理对象
        TrainStation proxyObject = proxyFactory.getProxyObject();
        //调用sell
        proxyObject.sell();
    }
}

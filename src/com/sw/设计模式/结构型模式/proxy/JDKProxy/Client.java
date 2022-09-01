package com.sw.设计模式.结构型模式.proxy.JDKProxy;

import com.sw.设计模式.结构型模式.proxy.staticProxy.SellTickets;

/**
 * @author Wang Hao
 * @date 2022/9/1 22:59
 */
public class Client {
    public static void main(String[] args) {
        //获取代理对象
        //1.创建代理工厂对象
        ProxyFactory proxyFactory = new ProxyFactory();
        //2.使用proxyFactory对象的方法获取代理对象
        SellTickets proxyObject = proxyFactory.getProxyInstance();
        //3.调用卖票的方法
        proxyObject.sell();
    }
}

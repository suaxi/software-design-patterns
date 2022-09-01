package com.sw.设计模式.结构型模式.proxy.JDKProxy;

/**
 * @author Wang Hao
 * @date 2022/9/1 22:42
 * @description 火车站（真实主题类）
 */
public class TrainStation implements SellTickets {

    @Override
    public void sell() {
        System.out.println("火车站卖票");
    }
}

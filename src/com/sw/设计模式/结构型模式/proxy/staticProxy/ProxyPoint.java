package com.sw.设计模式.结构型模式.proxy.staticProxy;

/**
 * @author Wang Hao
 * @date 2022/9/1 22:42
 * @description 代售点（代理类）
 */
public class ProxyPoint implements SellTickets {

    /**
     * 聚合火车站对象
     */
    private TrainStation trainStation = new TrainStation();

    @Override
    public void sell() {
        System.out.println("代售点收取5元手续费");
        trainStation.sell();
    }
}

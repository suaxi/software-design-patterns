package com.sw.设计模式.结构型模式.adapter.objectAdapter;

/**
 * @author Wang Hao
 * @date 2022/9/4 11:26
 * @description 具体的SD卡
 */
public class SDCardImpl implements SDCard {

    @Override
    public String readSD() {
        return "Read data from SDCard: Hello World";
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("Write data to SDCard:" + msg);
    }
}

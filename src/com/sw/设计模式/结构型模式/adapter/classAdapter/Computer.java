package com.sw.设计模式.结构型模式.adapter.classAdapter;

/**
 * @author Wang Hao
 * @date 2022/9/4 11:32
 * @description 计算机类
 */
public class Computer {

    public String readSD(SDCard sdCard) {
        if (sdCard == null) {
            throw new NullPointerException("SDCard can not be null");
        }
        return sdCard.readSD();
    }
}

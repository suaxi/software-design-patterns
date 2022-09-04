package com.sw.设计模式.结构型模式.adapter.objectAdapter;

/**
 * @author Wang Hao
 * @date 2022/9/4 11:28
 * @description 目标接口
 */
public interface SDCard {

    /**
     * 读数据
     *
     * @return
     */
    String readSD();

    /**
     * 写数据
     *
     * @param msg
     */
    void writeSD(String msg);
}

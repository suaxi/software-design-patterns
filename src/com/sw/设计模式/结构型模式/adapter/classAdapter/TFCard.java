package com.sw.设计模式.结构型模式.adapter.classAdapter;

/**
 * @author Wang Hao
 * @date 2022/9/4 11:24
 * @description 适配者类接口
 */
public interface TFCard {

    /**
     * 读数据
     *
     * @return
     */
    String readTF();

    /**
     * 写数据
     *
     * @param msg
     */
    void writeTF(String msg);
}

package com.sw.设计模式.结构型模式.adapter.classAdapter;

/**
 * @author Wang Hao
 * @date 2022/9/4 11:26
 * @description 适配者类
 */
public class TFCardImpl implements TFCard {

    @Override
    public String readTF() {
        return "Read data from TFCard: Hello World";
    }

    @Override
    public void writeTF(String msg) {
        System.out.println("Write data to TFCard:" + msg);
    }
}

package com.sw.设计模式.结构型模式.adapter.classAdapter;

/**
 * @author Wang Hao
 * @date 2022/9/4 11:36
 * @description 适配器类
 */
public class SDAdapterTF extends TFCardImpl implements SDCard {

    @Override
    public String readSD() {
        System.out.println("Adapter read from TFCard");
        return super.readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("Adapter write to TFCard");
        super.writeTF(msg);
    }
}

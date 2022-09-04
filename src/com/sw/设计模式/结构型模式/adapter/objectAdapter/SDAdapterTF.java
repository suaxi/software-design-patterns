package com.sw.设计模式.结构型模式.adapter.objectAdapter;

import com.sw.设计模式.结构型模式.adapter.classAdapter.TFCard;

/**
 * @author Wang Hao
 * @date 2022/9/4 11:36
 * @description 适配器类
 */
public class SDAdapterTF implements SDCard {

    //适配者类
    private TFCard tfCard;

    public SDAdapterTF(TFCard tfCard) {
        this.tfCard = tfCard;
    }

    @Override
    public String readSD() {
        System.out.println("Adapter read from TFCard");
        return tfCard.readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("Adapter write to TFCard");
        tfCard.writeTF(msg);
    }
}

package com.sw.设计模式.结构型模式.adapter.objectAdapter;

/**
 * @author Wang Hao
 * @date 2022/9/4 11:34
 */
public class Client {
    public static void main(String[] args) {
        //计算机
        Computer computer = new Computer();
        //读取SDCard中的数据
        String msg = computer.readSD(new SDCardImpl());
        System.out.println(msg);

        System.out.println("====================================");
        //使用该电脑读取TFCard中的数据
        String msg1 = computer.readSD(new SDAdapterTF(new TFCardImpl()));
        System.out.println(msg1);
    }
}

package com.sw.设计模式.创建者模式.Builder.demo01;

/**
 * @author Wang Hao
 * @date 2022/8/31 22:30
 */
public class Client {
    public static void main(String[] args) {
        //指导者
        Director director = new Director(new QingJuBuilder());

        //指导者指导生产自行车
        Bike bike = director.construct();

        System.out.println(bike.getFrame());
        System.out.println(bike.getSeat());
    }
}

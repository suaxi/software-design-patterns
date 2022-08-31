package com.sw.设计模式.创建者模式.Builder.demo02;

/**
 * @author Wang Hao
 * @date 2022/8/31 23:03
 */
public class Client {
    public static void main(String[] args) {
        //通过建造者对象获取手机对象
        Phone phone = new Phone.Builder()
                .cpu("高通骁龙888")
                .memory("三星")
                .screen("三星oled")
                .mainBoard("主板")
                .build();

        System.out.println(phone);
    }
}

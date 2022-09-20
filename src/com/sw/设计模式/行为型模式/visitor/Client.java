package com.sw.设计模式.行为型模式.visitor;

/**
 * @author Wang Hao
 * @date 2022/9/20 22:11
 */
public class Client {
    public static void main(String[] args) {
        //创建Home
        Home home = new Home();

        //添加元素
        home.add(new Dog());
        home.add(new Cat());

        //创建主人对象
        Owner owner = new Owner();

        //主人喂宠物
        home.action(owner);
    }
}

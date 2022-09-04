package com.sw.设计模式.结构型模式.decorator;

/**
 * @author Wang Hao
 * @date 2022/9/4 21:17
 */
public class Client {
    public static void main(String[] args) {
        //炒饭
        FastFood food = new FriedRice();
        System.out.println(food.getDesc() + "  " + food.cost() + "元");

        //再加一个鸡蛋
        food = new Egg(food);
        //System.out.println(food.getDesc() + "  " + food.cost() + "元");

        //加培根
        food = new Bacon(food);
        System.out.println(food.getDesc() + "  " + food.cost() + "元");
    }
}

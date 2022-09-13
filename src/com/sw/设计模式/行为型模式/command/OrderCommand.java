package com.sw.设计模式.行为型模式.command;

import java.util.Map;

/**
 * @author Wang Hao
 * @date 2022/9/13 22:36
 * @description 具体命令类
 */
public class OrderCommand implements Command {

    //持有接收者对象
    private SeniorChef receiver;

    //持有订单对象
    private Order order;

    public OrderCommand(SeniorChef receiver, Order order) {
        this.receiver = receiver;
        this.order = order;
    }

    @Override
    public void execute() {
        System.out.println(order.getDiningTable() + "号桌的订单：");

        Map<String, Integer> foodDic = order.getFoodDic();
        for (String foodName : foodDic.keySet()) {
            receiver.makeFood(foodName, foodDic.get(foodName));
        }

        System.out.println(order.getDiningTable() + "号桌的菜品已准备完毕！");
    }
}

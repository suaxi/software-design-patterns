package com.sw.设计模式.行为型模式.command;

/**
 * @author Wang Hao
 * @date 2022/9/13 22:43
 */
public class Client {
    public static void main(String[] args) {
        //创建订单
        Order order1 = new Order();
        order1.setDiningTable(1);
        order1.setFood("小混沌", 1);
        order1.setFood("煎饼", 1);

        Order order2 = new Order();
        order2.setDiningTable(2);
        order2.setFood("小炒肉盖饭", 1);
        order2.setFood("酸梅汤", 1);

        //创建厨师
        SeniorChef receiver = new SeniorChef();

        //创建命令对象
        OrderCommand command1 = new OrderCommand(receiver, order1);
        OrderCommand command2 = new OrderCommand(receiver, order2);

        //创建服务员（调用者）
        Waiter waiter = new Waiter();
        waiter.command(command1);
        waiter.command(command2);

        //发起命令
        waiter.orderUp();
    }
}

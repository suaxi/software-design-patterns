package com.sw.设计模式.行为型模式.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wang Hao
 * @date 2022/9/13 22:40
 * @description 服务员（请求者类）
 */
public class Waiter {

    //持有多个命令对象
    private List<Command> commands = new ArrayList<>();

    public void command(Command command) {
        commands.add(command);
    }

    public void orderUp() {
        System.out.println("新订单来了");
        for (Command command : commands) {
            if (command != null) {
                command.execute();
            }
        }
    }
}

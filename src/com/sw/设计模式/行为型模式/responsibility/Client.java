package com.sw.设计模式.行为型模式.responsibility;

/**
 * @author Wang Hao
 * @date 2022/9/14 22:44
 */
public class Client {
    public static void main(String[] args) {
        //创建请假条
        LeaveRequest leaveRequest = new LeaveRequest("孙笑川", 2, "感冒");

        //各级领导对象
        GroupLeader groupLeader = new GroupLeader();
        Manager manager = new Manager();
        GeneralManager generalManager = new GeneralManager();

        //设置处理者链
        groupLeader.setNextHandler(manager);
        manager.setNextHandler(generalManager);

        //发起请假申请
        groupLeader.submit(leaveRequest);
    }
}

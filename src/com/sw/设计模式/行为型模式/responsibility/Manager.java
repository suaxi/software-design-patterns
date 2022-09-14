package com.sw.设计模式.行为型模式.responsibility;

/**
 * @author Wang Hao
 * @date 2022/9/14 22:38
 * @description 部门经理（具体处理者）
 */
public class Manager extends Handler {

    public Manager() {
        super(Handler.ONE, Handler.THREE);
    }

    @Override
    protected void handlerLeave(LeaveRequest leave) {
        System.out.println(leave.getName() + "由于" + leave.getContent() + "，请假：" + leave.getNum() + "天");
        System.out.println("部门经理意见：同意");
    }
}

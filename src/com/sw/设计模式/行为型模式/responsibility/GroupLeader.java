package com.sw.设计模式.行为型模式.responsibility;

/**
 * @author Wang Hao
 * @date 2022/9/14 22:38
 * @description 组长（具体处理者）
 */
public class GroupLeader extends Handler {

    public GroupLeader() {
        super(0, Handler.ONE);
    }

    @Override
    protected void handlerLeave(LeaveRequest leave) {
        System.out.println(leave.getName() + "由于" + leave.getContent() + "，请假：" + leave.getNum() + "天");
        System.out.println("组长审批意见：同意");
    }
}

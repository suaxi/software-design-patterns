package com.sw.设计模式.行为型模式.responsibility;

/**
 * @author Wang Hao
 * @date 2022/9/14 22:38
 * @description 总经理（具体处理者）
 */
public class GeneralManager extends Handler {

    public GeneralManager() {
        super(Handler.THREE, Handler.SEVEN);
    }

    @Override
    protected void handlerLeave(LeaveRequest leave) {
        System.out.println(leave.getName() + "由于" + leave.getContent() + "，请假：" + leave.getNum() + "天");
        System.out.println("总经理审批意见：同意");
    }
}

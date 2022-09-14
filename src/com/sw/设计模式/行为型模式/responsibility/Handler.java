package com.sw.设计模式.行为型模式.responsibility;

/**
 * @author Wang Hao
 * @date 2022/9/14 22:30
 * @description 抽象处理者
 */
public abstract class Handler {

    protected final static int ONE = 1;

    protected final static int THREE = 3;

    protected final static int SEVEN = 7;

    //不同角色可以处理的请假天数区间
    private int startNum;
    private int endNum;

    //声明后继者（该案例中的上级领导）
    private Handler nextHandler;

    public Handler(int startNum) {
        this.startNum = startNum;
    }

    public Handler(int startNum, int endNum) {
        this.startNum = startNum;
        this.endNum = endNum;
    }

    /**
     * 设置上级领导对象
     *
     * @param nextHandler
     */
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    /**
     * 各级领导处理请假条的方法
     *
     * @param leave
     */
    protected abstract void handlerLeave(LeaveRequest leave);

    /**
     * 提交请假申请
     *
     * @param leave
     */
    public final void submit(LeaveRequest leave) {
        //当前领导审批
        this.handlerLeave(leave);

        //上级领导审批
        if (this.nextHandler != null && leave.getNum() > this.endNum) {
            this.nextHandler.handlerLeave(leave);
        } else {
            System.out.println("流程结束");
        }
    }
}

package com.sw.设计模式.行为型模式.state;

/**
 * @author Wang Hao
 * @date 2022/9/15 22:35
 * @description 抽象状态类
 */
public abstract class LiftState {

    //环境角色类变量
    protected Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    /**
     * 开门
     */
    public abstract void open();

    /**
     * 关门
     */
    public abstract void close();

    /**
     * 运行
     */
    public abstract void run();

    /**
     * 停止
     */
    public abstract void stop();
}

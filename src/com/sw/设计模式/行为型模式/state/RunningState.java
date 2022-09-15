package com.sw.设计模式.行为型模式.state;

/**
 * @author Wang Hao
 * @date 2022/9/15 22:38
 * @description 电梯运行状态类
 */
public class RunningState extends LiftState {

    @Override
    public void open() {
        
    }

    @Override
    public void close() {

    }

    @Override
    public void run() {
        System.out.println("电梯正在运行");
    }

    @Override
    public void stop() {
        super.context.setLiftState(Context.STOPPING_STATE);
        super.context.stop();
    }
}

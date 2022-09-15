package com.sw.设计模式.行为型模式.state;

/**
 * @author Wang Hao
 * @date 2022/9/15 22:38
 * @description 电梯开启状态类
 */
public class OpeningState extends LiftState {

    @Override
    public void open() {
        System.out.println("电梯门开了");
    }

    @Override
    public void close() {
        //修改状态
        super.context.setLiftState(Context.CLOSING_STATE);
        //调用当前状态中的Context中的close方法
        super.context.close();
    }

    @Override
    public void run() {

    }

    @Override
    public void stop() {

    }
}

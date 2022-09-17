package com.sw.设计模式.行为型模式.observer;

/**
 * @author Wang Hao
 * @date 2022/9/17 23:16
 * @description 抽象观察者角色
 */
public interface Observer {

    /**
     * 更新
     * @param message 消息
     */
    void update(String message);
}

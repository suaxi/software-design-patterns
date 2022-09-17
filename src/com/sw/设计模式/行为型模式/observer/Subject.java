package com.sw.设计模式.行为型模式.observer;

/**
 * @author Wang Hao
 * @date 2022/9/17 23:15
 * @description 抽象主题角色
 */
public interface Subject {

    /**
     * 添加观察者对象（订阅者）
     * @param observer 观察者对象
     */
    void attach(Observer observer);

    /**
     * 删除观察者对象（订阅者）
     * @param observer 观察者对象
     */
    void detach(Observer observer);

    /**
     * 通志观察者（订阅者）更新消息
     * @param message 消息
     */
    void notify(String message);
}

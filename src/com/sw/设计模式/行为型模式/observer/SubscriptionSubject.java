package com.sw.设计模式.行为型模式.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wang Hao
 * @date 2022/9/17 23:19
 * @description 具体主题角色
 */
public class SubscriptionSubject implements Subject {

    private List<Observer> userList = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        userList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        userList.remove(observer);
    }

    @Override
    public void notify(String message) {
        //通知所有订阅者
        for (Observer observer : userList) {
            observer.update(message);
        }
    }
}

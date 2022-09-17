package com.sw.设计模式.行为型模式.observer;

/**
 * @author Wang Hao
 * @date 2022/9/17 23:22
 */
public class Client {
    public static void main(String[] args) {
        //创建公众号
        SubscriptionSubject subject = new SubscriptionSubject();

        //订阅公众号
        subject.attach(new User("孙笑川"));
        subject.attach(new User("药水哥"));
        subject.attach(new User("刘波"));

        //公众号发布新的消息
        subject.notify("带带大师兄");
    }
}

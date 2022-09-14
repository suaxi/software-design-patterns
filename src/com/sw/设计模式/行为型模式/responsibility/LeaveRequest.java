package com.sw.设计模式.行为型模式.responsibility;

/**
 * @author Wang Hao
 * @date 2022/9/14 22:29
 * @description 请假条
 */
public class LeaveRequest {

    //请假人
    private String name;

    //请假天数
    private int num;

    //请假事由
    private String content;

    public LeaveRequest(String name, int num, String content) {
        this.name = name;
        this.num = num;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    public String getContent() {
        return content;
    }
}

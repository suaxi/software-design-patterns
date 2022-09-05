package com.sw.设计模式.结构型模式.bridge;

/**
 * @author Wang Hao
 * @date 2022/9/5 22:30
 */
public class Client {
    public static void main(String[] args) {
        //操作系统
        OperationSystem operationSystem = new Windows(new MkvFile());

        //播放视频文件
        operationSystem.play("小猪佩奇");
    }
}

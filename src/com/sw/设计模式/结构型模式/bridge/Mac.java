package com.sw.设计模式.结构型模式.bridge;

/**
 * @author Wang Hao
 * @date 2022/9/5 22:28
 * @description Mac（扩展抽象化角色）
 */
public class Mac extends OperationSystem {

    public Mac(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void play(String fileName) {
        videoFile.decode(fileName);
    }
}

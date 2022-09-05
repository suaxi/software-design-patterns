package com.sw.设计模式.结构型模式.bridge;

/**
 * @author Wang Hao
 * @date 2022/9/5 22:27
 * @description 操作系统类（抽象化角色）
 */
public abstract class OperationSystem {

    //声明VideoFile变量
    protected VideoFile videoFile;

    public OperationSystem(VideoFile videoFile) {
        this.videoFile = videoFile;
    }

    /**
     * 播放视频
     *
     * @param fileName
     */
    public abstract void play(String fileName);
}

package com.sw.设计模式.结构型模式.bridge;

/**
 * @author Wang Hao
 * @date 2022/9/5 22:25
 * @description mp4视频文件（具体实现化角色）
 */
public class Mp4File implements VideoFile {

    @Override
    public void decode(String fileName) {
        System.out.println("播放mp4视频文件：" + fileName);
    }
}

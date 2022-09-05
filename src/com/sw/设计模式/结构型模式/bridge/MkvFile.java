package com.sw.设计模式.结构型模式.bridge;

/**
 * @author Wang Hao
 * @date 2022/9/5 22:25
 * @description mkv视频文件（具体实现化角色）
 */
public class MkvFile implements VideoFile {

    @Override
    public void decode(String fileName) {
        System.out.println("播放mkv视频文件：" + fileName);
    }
}

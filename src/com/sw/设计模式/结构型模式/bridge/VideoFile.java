package com.sw.设计模式.结构型模式.bridge;

/**
 * @author Wang Hao
 * @date 2022/9/5 22:23
 * @description 视频文件（实现化角色）
 */
public interface VideoFile {

    /**
     * 视频解码
     *
     * @param fileName
     */
    void decode(String fileName);
}

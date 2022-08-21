package com.sw.设计原则.依赖倒置原则.after;

/**
 * @author Wang Hao
 * @date 2022/8/21 22:48
 * @description 硬盘接口
 */
public interface HardDisk {

    /**
     * 存储数据
     *
     * @param data 数据
     */
    void save(String data);

    /**
     * 读取数据
     *
     * @return
     */
    String get();
}

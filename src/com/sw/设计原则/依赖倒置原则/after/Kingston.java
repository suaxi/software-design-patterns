package com.sw.设计原则.依赖倒置原则.after;

/**
 * @author Wang Hao
 * @date 2022/8/21 22:29
 * @description 金士顿内存条
 */
public class Kingston implements Memory {

    @Override
    public void save() {
        System.out.println("使用金士顿内存条");
    }
}

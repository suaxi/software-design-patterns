package com.sw.设计原则.依赖倒置原则.after;

/**
 * @author Wang Hao
 * @date 2022/8/21 22:28
 * @description AMD
 */
public class Amd implements Cpu {

    @Override
    public void run() {
        System.out.println("使用AMD cpu");
    }
}

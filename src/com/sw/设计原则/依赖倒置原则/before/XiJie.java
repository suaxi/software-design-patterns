package com.sw.设计原则.依赖倒置原则.before;

/**
 * @author Wang Hao
 * @date 2022/8/21 22:26
 * @description 希捷硬盘
 */
public class XiJie {

    public void save(String data) {
        System.out.println("使用希捷硬盘存储数据：" + data);
    }

    public String get() {
        System.out.println("使用希捷硬盘读取数据");
        return "数据";
    }
}

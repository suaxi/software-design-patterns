package com.sw.设计模式.行为型模式.visitor;

/**
 * @author Wang Hao
 * @date 2022/9/20 22:04
 * @description 抽象元素角色
 */
public interface Animal {

    /**
     * 接受访问者访问
     *
     * @param person 访问者
     */
    void accept(Person person);
}

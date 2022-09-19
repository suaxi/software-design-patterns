package com.sw.设计模式.行为型模式.iterator;

/**
 * @author Wang Hao
 * @date 2022/9/19 22:37
 * @description 抽象迭代器角色
 */
public interface StudentIterator {

    /**
     * 判断是否还有元素
     *
     * @return
     */
    boolean hasNext();

    /**
     * 获取下一个元素
     *
     * @return
     */
    Student next();
}

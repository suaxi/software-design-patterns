package com.sw.设计模式.行为型模式.iterator;

/**
 * @author Wang Hao
 * @date 2022/9/19 22:41
 * @description 抽象聚合角色
 */
public interface StudentAggregate {

    /**
     * 添加元素
     *
     * @param student
     */
    void add(Student student);

    /**
     * 移除元素
     *
     * @param student
     */
    void remove(Student student);

    /**
     * 获取迭代器
     *
     * @return
     */
    StudentIterator getStudentIterator();
}

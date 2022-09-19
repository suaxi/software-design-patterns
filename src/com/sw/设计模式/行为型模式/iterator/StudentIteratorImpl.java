package com.sw.设计模式.行为型模式.iterator;

import java.util.List;

/**
 * @author Wang Hao
 * @date 2022/9/19 22:38
 * @description 具体迭代器角色
 */
public class StudentIteratorImpl implements StudentIterator {

    private List<Student> list;

    //记录遍历时的位置
    private int position = 0;

    public StudentIteratorImpl(List<Student> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return position < list.size();
    }

    @Override
    public Student next() {
        Student currentStudent = list.get(position);
        position++;
        return currentStudent;
    }
}

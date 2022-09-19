package com.sw.设计模式.行为型模式.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wang Hao
 * @date 2022/9/19 22:43
 * @description 具体聚合对象
 */
public class StudentAggregateImpl implements StudentAggregate {

    private List<Student> list = new ArrayList<>();

    @Override
    public void add(Student student) {
        list.add(student);
    }

    @Override
    public void remove(Student student) {
        list.remove(student);
    }

    @Override
    public StudentIterator getStudentIterator() {
        return new StudentIteratorImpl(list);
    }
}

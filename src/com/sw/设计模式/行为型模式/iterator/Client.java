package com.sw.设计模式.行为型模式.iterator;

/**
 * @author Wang Hao
 * @date 2022/9/19 22:44
 */
public class Client {
    public static void main(String[] args) {
        //创建聚合对象
        StudentAggregateImpl studentAggregate = new StudentAggregateImpl();

        //添加元素
        studentAggregate.add(new Student("孙笑川", "001"));
        studentAggregate.add(new Student("药水哥", "002"));
        studentAggregate.add(new Student("刘波", "003"));

        //获取迭代器对象
        StudentIterator iterator = studentAggregate.getStudentIterator();
        //遍历
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

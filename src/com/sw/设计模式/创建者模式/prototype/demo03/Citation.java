package com.sw.设计模式.创建者模式.prototype.demo03;

/**
 * @author Wang Hao
 * @date 2022/8/30 22:18
 * @description 三好学生
 */
public class Citation implements Cloneable {

    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void show() {
        System.out.println(student.getName() + "同学，在本学年表现优秀，被评为“三好学生”，特发此状，以资鼓励！");
    }

    @Override
    public Citation clone() throws CloneNotSupportedException {
        return (Citation) super.clone();
    }
}

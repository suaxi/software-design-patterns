package com.sw.设计模式.创建者模式.prototype.demo03;

/**
 * @author Wang Hao
 * @date 2022/8/30 22:21
 */
public class CitationTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        //创建原型对象
        Citation citation = new Citation();

        //创建学生
        Student student = new Student();
        student.setName("孙笑川");
        citation.setStudent(student);

        //复制奖状
        Citation citation1 = citation.clone();
        citation1.getStudent().setName("药水哥");

        //展示奖状
        citation.show();
        citation1.show();

        //药水哥同学，在本学年表现优秀，被评为“三好学生”，特发此状，以资鼓励！
        //药水哥同学，在本学年表现优秀，被评为“三好学生”，特发此状，以资鼓励！
    }
}

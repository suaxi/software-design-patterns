package com.sw.设计模式.创建者模式.prototype.demo04;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Wang Hao
 * @date 2022/8/30 22:21
 */
public class CitationTest {
    public static void main(String[] args) throws Exception {
        //创建原型对象
        Citation citation = new Citation();

        //创建学生
        Student student = new Student();
        student.setName("孙笑川");
        citation.setStudent(student);

        //创建对象输出流
        ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get("D:/citation.txt")));
        //写对象
        oos.writeObject(citation);
        //释放资源
        oos.close();

        //创建对象
        ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get("D:/citation.txt")));
        Citation citation1 = (Citation) ois.readObject();
        ois.close();

        citation1.getStudent().setName("药水哥");

        citation.show();
        citation1.show();
    }
}

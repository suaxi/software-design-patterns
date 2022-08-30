package com.sw.设计模式.创建者模式.prototype.demo02;

/**
 * @author Wang Hao
 * @date 2022/8/30 22:18
 * @description 三好学生
 */
public class Citation implements Cloneable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println(name + "同学，在本学年表现优秀，被评为“三好学生”，特发此状，以资鼓励！");
    }

    @Override
    public Citation clone() throws CloneNotSupportedException {
        return (Citation) super.clone();
    }
}

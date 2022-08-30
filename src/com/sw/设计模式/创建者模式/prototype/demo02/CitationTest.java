package com.sw.设计模式.创建者模式.prototype.demo02;

/**
 * @author Wang Hao
 * @date 2022/8/30 22:21
 */
public class CitationTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        //创建原型对象
        Citation citation = new Citation();
        //复制奖状
        Citation citation1 = citation.clone();

        citation.setName("孙笑川");
        citation1.setName("药水哥");

        //展示奖状
        citation.show();
        citation1.show();
    }
}

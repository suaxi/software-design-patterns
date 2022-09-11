package com.sw.设计模式.行为型模式.template;

/**
 * @author Wang Hao
 * @date 2022/9/11 22:54
 */
public class Client {
    public static void main(String[] args) {
        //炒包菜
        ConcreteClass_BaoCai baoCai = new ConcreteClass_BaoCai();
        baoCai.cookProcess();
    }
}

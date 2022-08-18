package com.sw.设计原则;

/**
 * @author Wang Hao
 * @date 2022/8/18 21:49
 */
public class Client {
    public static void main(String[] args) {
        //1.创建输入法对象
        SouGouInput input = new SouGouInput();

        //2.创建默认皮肤对象
        //DefaultSkin skin = new DefaultSkin();
        TestSkin skin = new TestSkin();

        //3.将皮肤设置到输入法中
        input.setSkin(skin);

        //4.显示皮肤
        input.display();
    }
}

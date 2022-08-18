package com.sw.设计原则;

/**
 * @author Wang Hao
 * @date 2022/8/18 21:48
 * @description 搜狗输入法
 */
public class SouGouInput {

    private AbstractSkin skin;

    public void setSkin(AbstractSkin skin) {
        this.skin = skin;
    }

    public void display() {
        skin.display();
    }
}

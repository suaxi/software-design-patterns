package com.sw.设计模式.行为型模式.memento.blackBox;

/**
 * @author Wang Hao
 * @date 2022/9/22 22:40
 * @description 备忘录管理对象
 */
public class RoleStateCaretaker {

    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}

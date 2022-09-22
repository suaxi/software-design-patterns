package com.sw.设计模式.行为型模式.memento.whiteBox;

/**
 * @author Wang Hao
 * @date 2022/9/22 22:40
 * @description 备忘录管理对象
 */
public class RoleStateCaretaker {

    private RoleStateMemento roleStateMemento;

    public RoleStateMemento getRoleStateMemento() {
        return roleStateMemento;
    }

    public void setRoleStateMemento(RoleStateMemento roleStateMemento) {
        this.roleStateMemento = roleStateMemento;
    }
}

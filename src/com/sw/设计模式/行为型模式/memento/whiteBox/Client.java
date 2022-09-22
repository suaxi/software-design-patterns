package com.sw.设计模式.行为型模式.memento.whiteBox;

/**
 * @author Wang Hao
 * @date 2022/9/22 22:41
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("====战斗前====");
        GameRole gameRole = new GameRole();
        gameRole.initState();
        gameRole.displayState();

        //备份角色状态
        RoleStateCaretaker roleStateCaretaker = new RoleStateCaretaker();
        roleStateCaretaker.setRoleStateMemento(gameRole.saveState());

        System.out.println("====战斗后====");
        gameRole.fight();
        gameRole.displayState();

        System.out.println("====恢复状态====");
        gameRole.recoverState(roleStateCaretaker.getRoleStateMemento());
        gameRole.displayState();
    }
}

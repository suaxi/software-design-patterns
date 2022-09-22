package com.sw.设计模式.行为型模式.memento.whiteBox;

/**
 * @author Wang Hao
 * @date 2022/9/22 22:31
 * @description 游戏角色类（发起人）
 */
public class GameRole {

    /**
     * 生命值
     */
    private int vit;

    /**
     * 攻击值
     */
    private int atk;

    /**
     * 防御值
     */
    private int def;

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    /**
     * 初始化内部状态
     */
    public void initState() {
        this.vit = 100;
        this.atk = 100;
        this.def = 100;
    }

    /**
     * 战斗
     */
    public void fight() {
        this.vit = 0;
        this.atk = 0;
        this.def = 0;
    }

    /**
     * 保存游戏角色状态
     *
     * @return
     */
    public RoleStateMemento saveState() {
        return new RoleStateMemento(vit, atk, def);
    }

    /**
     * 恢复角色状态
     *
     * @param roleStateMemento
     */
    public void recoverState(RoleStateMemento roleStateMemento) {
        this.vit = roleStateMemento.getVit();
        this.atk = roleStateMemento.getAtk();
        this.def = roleStateMemento.getDef();
    }

    /**
     * 展示角色状态
     */
    public void displayState() {
        System.out.println("生命值：" + vit);
        System.out.println("攻击值：" + vit);
        System.out.println("防御值：" + vit);
    }
}

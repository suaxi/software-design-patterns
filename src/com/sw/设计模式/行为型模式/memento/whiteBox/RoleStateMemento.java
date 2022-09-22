package com.sw.设计模式.行为型模式.memento.whiteBox;

/**
 * @author Wang Hao
 * @date 2022/9/22 22:34
 * @description 备忘录角色
 */
public class RoleStateMemento {

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

    public RoleStateMemento() {
    }

    public RoleStateMemento(int vit, int atk, int def) {
        this.vit = vit;
        this.atk = atk;
        this.def = def;
    }

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
}

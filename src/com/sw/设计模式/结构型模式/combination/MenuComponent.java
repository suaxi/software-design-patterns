package com.sw.设计模式.结构型模式.combination;

/**
 * @author Wang Hao
 * @date 2022/9/7 22:25
 * @description 菜单组件（抽象根节点）
 */
public abstract class MenuComponent {

    protected String name;
    protected int level;

    /**
     * 添加菜单
     *
     * @param menuComponent
     */
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    /**
     * 移除菜单
     *
     * @param menuComponent
     */
    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    /**
     * 查询子菜单
     *
     * @param index
     * @return
     */
    public MenuComponent getChild(int index) {
        throw new UnsupportedOperationException();
    }

    /**
     * 查询菜单或菜单项的名称
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 打印菜单（包含子菜单和子菜单项）
     */
    public abstract void print();
}

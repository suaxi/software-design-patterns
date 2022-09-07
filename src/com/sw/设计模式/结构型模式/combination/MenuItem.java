package com.sw.设计模式.结构型模式.combination;

/**
 * @author Wang Hao
 * @date 2022/9/7 22:36
 * @description 菜单项（叶子节点）
 */
public class MenuItem extends MenuComponent {

    public MenuItem(String name, int level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void print() {
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }

        //打印菜单项名称
        System.out.println(name);
    }
}

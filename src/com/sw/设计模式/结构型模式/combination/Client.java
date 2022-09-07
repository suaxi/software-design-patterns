package com.sw.设计模式.结构型模式.combination;

/**
 * @author Wang Hao
 * @date 2022/9/7 22:38
 */
public class Client {
    public static void main(String[] args) {
        //创建菜单
        MenuComponent menue1 = new Menu("菜单一", 2);
        menue1.add(new MenuItem("1", 3));
        menue1.add(new MenuItem("2", 3));
        menue1.add(new MenuItem("3", 3));

        MenuComponent menue2 = new Menu("菜单二", 2);
        menue2.add(new MenuItem("1", 3));
        menue2.add(new MenuItem("2", 3));
        menue2.add(new MenuItem("3", 3));

        MenuComponent menue3 = new Menu("菜单三", 2);
        menue3.add(new MenuItem("1", 3));
        menue3.add(new MenuItem("2", 3));
        menue3.add(new MenuItem("3", 3));

        MenuComponent menue4 = new Menu("菜单四", 2);
        menue4.add(new MenuItem("1", 3));
        menue4.add(new MenuItem("2", 3));
        menue4.add(new MenuItem("3", 3));

        //将二级菜单添加到一级菜单中
        MenuComponent component = new Menu("根菜单", 1);
        component.add(menue1);
        component.add(menue2);
        component.add(menue3);
        component.add(menue4);

        //打印菜单
        component.print();
    }
}

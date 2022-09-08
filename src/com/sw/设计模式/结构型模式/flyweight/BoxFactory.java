package com.sw.设计模式.结构型模式.flyweight;

import java.util.HashMap;

/**
 * @author Wang Hao
 * @date 2022/9/8 22:13
 * @description 享元工厂
 */
public class BoxFactory {

    private HashMap<String, AbstractBox> map;

    private BoxFactory() {
        map = new HashMap<>();
        map.put("I", new IBox());
        map.put("L", new LBox());
        map.put("O", new OBox());
    }

    /**
     * 饿汉式
     *
     * @return
     */
    public static BoxFactory getInstance() {
        return factory;
    }

    private static BoxFactory factory = new BoxFactory();

    /**
     * 根据名称获取图形
     *
     * @param key
     * @return
     */
    public AbstractBox getShape(String key) {
        return map.get(key);
    }
}

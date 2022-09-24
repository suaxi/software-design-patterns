package com.sw.设计模式.行为型模式.interpret;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wang Hao
 * @date 2022/9/24 22:43
 * @description 环境角色
 */
public class Context {

    private Map<Variable, Integer> map = new HashMap<>();

    /**
     * 添加变量
     *
     * @param var   key
     * @param value value
     */
    public void assign(Variable var, Integer value) {
        map.put(var, value);
    }

    /**
     * 获取变量
     *
     * @param var key
     * @return
     */
    public int getVariable(Variable var) {
        return map.get(var);
    }
}

package com.sw.设计模式.行为型模式.interpret;

/**
 * @author Wang Hao
 * @date 2022/9/24 22:44
 * @description 变量类
 */
public class Variable extends AbstractExpression {

    //变量名
    private String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public int interpret(Context context) {
        //直接返回变量值
        return context.getVariable(this);
    }

    @Override
    public String toString() {
        return name;
    }
}

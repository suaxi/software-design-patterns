package com.sw.设计模式.行为型模式.interpret;

/**
 * @author Wang Hao
 * @date 2022/9/24 22:42
 * @description 抽象表达式
 */
public abstract class AbstractExpression {

    /**
     * 解释（解析）
     *
     * @param context 环境变量
     * @return
     */
    public abstract int interpret(Context context);
}

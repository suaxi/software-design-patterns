package com.sw.设计模式.行为型模式.interpret;

/**
 * @author Wang Hao
 * @date 2022/9/24 22:46
 * @description 减法表达式
 */
public class Minus extends AbstractExpression {

    //减号左边的表达式
    private AbstractExpression left;

    //减号右边的表达式
    private AbstractExpression right;

    public Minus(AbstractExpression left, AbstractExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) - right.interpret(context);
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " - " + right.toString() + ")";
    }
}

package com.sw.设计模式.行为型模式.interpret;

/**
 * @author Wang Hao
 * @date 2022/9/24 22:46
 * @description 加法表达式
 */
public class Plus extends AbstractExpression {

    //加号左边的表达式
    private AbstractExpression left;

    //加号右边的表达式
    private AbstractExpression right;

    public Plus(AbstractExpression left, AbstractExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) + right.interpret(context);
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " + " + right.toString() + ")";
    }
}

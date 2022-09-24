package com.sw.设计模式.行为型模式.interpret;

/**
 * @author Wang Hao
 * @date 2022/9/24 22:57
 */
public class Client {
    public static void main(String[] args) {
        //创建环境对象
        Context context = new Context();

        //创建多个变量对象
        Variable a = new Variable("a");
        Variable b = new Variable("b");
        Variable c = new Variable("c");
        Variable d = new Variable("d");

        //存储变量
        context.assign(a, 1);
        context.assign(b, 2);
        context.assign(c, 3);
        context.assign(d, 4);

        //获取抽象语法树 a + b - c + d
        AbstractExpression expression = new Plus(a, new Minus(b, new Plus(c, d)));

        //解释（解析）
        System.out.println(expression.interpret(context));
    }
}

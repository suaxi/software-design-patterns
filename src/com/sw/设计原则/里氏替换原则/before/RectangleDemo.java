package com.sw.设计原则.里氏替换原则.before;

/**
 * @author Wang Hao
 * @date 2022/8/20 21:47
 */
public class RectangleDemo {

    public static void main(String[] args) {
        //创建长方形对象
        Rectangle rectangle = new Rectangle();
        rectangle.setLength(20);
        rectangle.setWidth(10);
        //扩宽
        resize(rectangle);
        printLengthAndWidth(rectangle);


        System.out.println("====================");

        //创建正方形
        Square square = new Square();
        square.setWidth(20);
        resize(square);
        //在resize方法中，Rectangle类型的参数不能被Square类型的参数所代替，如果进行了替换，则不能得到预期的打印结果
        printLengthAndWidth(square);
    }

    public static void resize(Rectangle rectangle) {
        //如果长 > 宽，进行扩宽操作
        while (rectangle.getLength() >= rectangle.getWidth()) {
            rectangle.setWidth(rectangle.getWidth() + 1);
        }
    }

    public static void printLengthAndWidth(Rectangle rectangle) {
        System.out.println("长：" + rectangle.getLength());
        System.out.println("宽：" + rectangle.getWidth());
    }
}

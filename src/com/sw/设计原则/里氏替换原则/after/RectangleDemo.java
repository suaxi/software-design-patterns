package com.sw.设计原则.里氏替换原则.after;

/**
 * @author Wang Hao
 * @date 2022/8/20 22:16
 */
public class RectangleDemo {

    public static void main(String[] args) {
        //创建长方形对象
        Rectangle rectangle = new Rectangle();
        rectangle.setLength(20);
        rectangle.setWidth(10);
        resize(rectangle);
        printLengthAndWidth(rectangle);

        System.out.println("====================");

        //创建正方形对象（此时正方形和长方形不存在父子关系）
        Square square = new Square();
        square.setSide(10);
        printLengthAndWidth(square);
    }

    public static void resize(Rectangle rectangle) {
        //如果长 > 宽，进行扩宽操作
        while (rectangle.getLength() >= rectangle.getWidth()) {
            rectangle.setWidth(rectangle.getWidth() + 1);
        }
    }

    public static void printLengthAndWidth(Quadrilateral quadrilateral) {
        System.out.println("长：" + quadrilateral.getLength());
        System.out.println("宽：" + quadrilateral.getWidth());
    }
}

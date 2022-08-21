package com.sw.设计原则.依赖倒置原则.before;

/**
 * @author Wang Hao
 * @date 2022/8/21 22:32
 */
public class ComputerDemo {
    public static void main(String[] args) {
        //创建组件对象
        XiJie hardDisk = new XiJie();
        Intel cpu = new Intel();
        Kingston memory = new Kingston();

        Computer computer = new Computer();

        //组装计算机
        computer.setHardDisk(hardDisk);
        computer.setCpu(cpu);
        computer.setMemory(memory);

        //运行
        //存在的问题：现在的电脑只能使用给定的组件，如果要使用其他的，则违背了开闭原则
        computer.run();
    }
}

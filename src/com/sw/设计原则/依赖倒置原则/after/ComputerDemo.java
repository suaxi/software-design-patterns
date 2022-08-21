package com.sw.设计原则.依赖倒置原则.after;

/**
 * @author Wang Hao
 * @date 2022/8/21 22:54
 */
public class ComputerDemo {
    public static void main(String[] args) {
        //创建组件对象
        HardDisk xiJie = new XiJie();
        //Cpu intel = new Intel();
        Cpu intel = new Amd();
        Memory kingston = new Kingston();

        //创建计算机对象
        Computer computer = new Computer();

        //组装计算机
        computer.setHardDisk(xiJie);
        computer.setCpu(intel);
        computer.setMemory(kingston);

        //运行
        computer.run();
    }
}

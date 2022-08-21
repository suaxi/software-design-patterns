package com.sw.设计原则.依赖倒置原则.before;

/**
 * @author Wang Hao
 * @date 2022/8/21 22:29
 */
public class Computer {

    private XiJie hardDisk;
    private Intel cpu;
    private Kingston memory;

    public XiJie getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(XiJie hardDisk) {
        this.hardDisk = hardDisk;
    }

    public Intel getCpu() {
        return cpu;
    }

    public void setCpu(Intel cpu) {
        this.cpu = cpu;
    }

    public Kingston getMemory() {
        return memory;
    }

    public void setMemory(Kingston memory) {
        this.memory = memory;
    }

    public void run() {
        System.out.println("电脑运行了");
        String data = hardDisk.get();
        System.out.println("从硬盘上获取的数据是：" + data);
        cpu.run();
        memory.save();
    }
}

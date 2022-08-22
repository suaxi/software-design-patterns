package com.sw.设计原则.接口隔离原则.after;

/**
 * @author Wang Hao
 * @date 2022/8/22 22:54
 */
public class Test01SafetyDoor implements AntiTheft, Fireproof {

    @Override
    public void antiTheft() {
        System.out.println("防盗");
    }

    @Override
    public void fireproof() {
        System.out.println("防火");
    }
}

package com.sw.设计原则.接口隔离原则.before;

/**
 * @author Wang Hao
 * @date 2022/8/22 22:44
 * @description Test牌安全门
 */
public class TestSafetyDoor implements SafetyDoor {
    @Override
    public void antiTheft() {
        System.out.println("防盗");
    }

    @Override
    public void fireproof() {
        System.out.println("防火");
    }

    @Override
    public void waterproof() {
        System.out.println("防水");
    }
}

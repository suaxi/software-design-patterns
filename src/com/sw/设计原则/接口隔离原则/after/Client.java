package com.sw.设计原则.接口隔离原则.after;

/**
 * @author Wang Hao
 * @date 2022/8/22 22:55
 */
public class Client {
    public static void main(String[] args) {
        //Test品牌安全门
        TestSafetyDoor testSafetyDoor = new TestSafetyDoor();
        testSafetyDoor.antiTheft();
        testSafetyDoor.fireproof();
        testSafetyDoor.waterproof();

        System.out.println("=================");

        //Test品牌安全门
        Test01SafetyDoor test01SafetyDoor = new Test01SafetyDoor();
        test01SafetyDoor.antiTheft();
        test01SafetyDoor.fireproof();
    }
}

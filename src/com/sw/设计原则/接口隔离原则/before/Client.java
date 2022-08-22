package com.sw.设计原则.接口隔离原则.before;

/**
 * @author Wang Hao
 * @date 2022/8/22 22:45
 */
public class Client {
    public static void main(String[] args) {
        //存在的问题：如果要增加新的品牌的安全门，则违背了开闭原则
        TestSafetyDoor testSafetyDoor = new TestSafetyDoor();
        testSafetyDoor.antiTheft();
        testSafetyDoor.fireproof();
        testSafetyDoor.waterproof();
    }
}

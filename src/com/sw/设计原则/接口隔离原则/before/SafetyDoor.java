package com.sw.设计原则.接口隔离原则.before;

/**
 * @author Wang Hao
 * @date 2022/8/22 22:40
 * @description 安全门接口
 */
public interface SafetyDoor {

    /**
     * 防盗
     */
    void antiTheft();

    /**
     * 防火
     */
    void fireproof();

    /**
     * 防水
     */
    void waterproof();
}

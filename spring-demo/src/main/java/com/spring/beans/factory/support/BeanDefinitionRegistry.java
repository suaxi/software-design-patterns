package com.spring.beans.factory.support;

import com.spring.beans.BeanDefinition;

/**
 * @author Wang Hao
 * @date 2022/9/27 22:02
 * @description 注册表对象
 */
public interface BeanDefinitionRegistry {

    /**
     * 注册BeanDefinition对象到注册表中
     *
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 从注册表中删除指定名称的对象
     *
     * @param beanName
     */
    void removeBeanDefinition(String beanName);

    /**
     * 根据名称获取指定对象
     *
     * @param beanName
     * @return
     */
    BeanDefinition getBeanDefinition(String beanName);

    /**
     * 根据名称判断是否包含指定对象
     *
     * @param beanName
     * @return
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * 获取已注册bean的个数
     *
     * @return
     */
    int getBeanDefinitionCount();

    /**
     * 获取已注册bean的名称数组
     *
     * @return
     */
    String[] getBeanDefinitionNames();
}

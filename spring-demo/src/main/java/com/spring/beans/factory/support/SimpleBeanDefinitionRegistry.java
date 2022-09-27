package com.spring.beans.factory.support;

import com.spring.beans.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wang Hao
 * @date 2022/9/27 22:08
 * @description 注册表接口实现类
 */
public class SimpleBeanDefinitionRegistry implements BeanDefinitionRegistry {

    /**
     * BeanDefinition存储容器
     */
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public void removeBeanDefinition(String beanName) {
        beanDefinitionMap.remove(beanName);
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) {
        return beanDefinitionMap.get(beanName);
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    @Override
    public int getBeanDefinitionCount() {
        return beanDefinitionMap.size();
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return beanDefinitionMap.keySet().toArray(new String[0]);
    }
}

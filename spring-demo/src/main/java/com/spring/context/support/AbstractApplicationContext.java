package com.spring.context.support;

import com.spring.beans.factory.support.BeanDefinitionReader;
import com.spring.beans.factory.support.BeanDefinitionRegistry;
import com.spring.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Wang Hao
 * @date 2022/9/27 22:38
 * @description ApplicationContext子实现类，用于立即加载
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    /**
     * 声明解析器
     */
    protected BeanDefinitionReader beanDefinitionReader;

    /**
     * 存储bean的容器
     */
    protected Map<String, Object> singleObjects = new HashMap<>();

    /**
     * 配置文件路径
     */
    protected String configLocation;

    @Override
    public void refresh() throws Exception {
        //加载BeanDefinition
        beanDefinitionReader.loadBeanDefinitions(configLocation);
        //初始化bean
        this.finishBeanInitialization();
    }

    /**
     * 初始化bean
     */
    private void finishBeanInitialization() throws Exception {
        //获取注册表对象
        BeanDefinitionRegistry registry = beanDefinitionReader.getRegistry();

        //获取BeanDefinition
        String[] beanNames = registry.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            //执行初始化
            getBean(beanName);
        }
    }
}

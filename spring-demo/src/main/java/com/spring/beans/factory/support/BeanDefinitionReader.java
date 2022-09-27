package com.spring.beans.factory.support;

import org.dom4j.DocumentException;

/**
 * @author Wang Hao
 * @date 2022/9/27 22:13
 * @description 解析配置文件
 */
public interface BeanDefinitionReader {

    /**
     * 获取注册表对象
     *
     * @return
     */
    BeanDefinitionRegistry getRegistry();

    /**
     * 加载配置文件并在注册表中注册
     *
     * @param configLocation
     */
    void loadBeanDefinitions(String configLocation) throws DocumentException;
}

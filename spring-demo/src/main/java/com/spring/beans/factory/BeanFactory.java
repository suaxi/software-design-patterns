package com.spring.beans.factory;

/**
 * @author Wang Hao
 * @date 2022/9/27 22:34
 * IOC容器接口
 */
public interface BeanFactory {

    /**
     * 根据名称获取bean
     *
     * @param name
     * @return
     */
    Object getBean(String name) throws Exception;

    /**
     * 根据名称、class类获取bean
     *
     * @param name
     * @param clazz
     * @param <T>
     * @return
     */
    <T> T getBean(String name, Class<? extends T> clazz) throws Exception;
}

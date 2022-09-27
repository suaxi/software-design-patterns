package com.spring.context;

import com.spring.beans.factory.BeanFactory;

/**
 * @author Wang Hao
 * @date 2022/9/27 22:37
 * @description 定义非延时加载功能
 */
public interface ApplicationContext extends BeanFactory {

    /**
     * 加载配置文件并创建对象
     *
     * @throws Exception
     */
    void refresh() throws Exception;
}

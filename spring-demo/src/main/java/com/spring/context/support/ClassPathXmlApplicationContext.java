package com.spring.context.support;

import com.spring.beans.BeanDefinition;
import com.spring.beans.PropertyValue;
import com.spring.beans.factory.support.BeanDefinitionRegistry;
import com.spring.beans.factory.xml.XmlBeanDefinitionReader;
import com.spring.context.utils.StringUtils;

import java.lang.reflect.Method;

/**
 * @author Wang Hao
 * @date 2022/9/27 22:50
 * @description IOC容器具体子实现类，加载类路径下xml格式的配置文件
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    public ClassPathXmlApplicationContext(String configLocation) {
        this.configLocation = configLocation;
        //构建解析器
        beanDefinitionReader = new XmlBeanDefinitionReader();
        try {
            this.refresh();
        } catch (Exception e) {

        }
    }

    @Override
    public Object getBean(String name) throws Exception {
        //判断对象容器中是否包含指定名称的容器对象，如果有则直接返回，反之进行创建
        Object obj = singleObjects.get(name);
        if (obj != null) {
            return obj;
        }

        //获取BeanDefinition
        BeanDefinitionRegistry registry = beanDefinitionReader.getRegistry();
        BeanDefinition beanDefinition = registry.getBeanDefinition(name);

        //根据bean标签数据中的类名反射创建对象
        Class<?> clazz = Class.forName(beanDefinition.getClassName());
        Object beanObj = clazz.newInstance();

        //执行依赖注入
        for (PropertyValue propertyValue : beanDefinition.getPropertyValues()) {
            //name
            String propertyName = propertyValue.getName();
            //value
            String value = propertyValue.getValue();
            //ref
            String ref = propertyValue.getRef();
            if (ref != null && !"".equals(ref)) {
                //获取依赖的bean对象
                Object bean = getBean(ref);
                //拼接方法名
                String methodName = StringUtils.getSetMethodByFieldName(propertyName);
                Method[] methods = clazz.getMethods();
                for (Method method : methods) {
                    if (method.getName().equals(methodName)) {
                        method.invoke(beanObj, bean);
                    }
                }

            }
            if (value != null && !"".equals(value)) {
                String methodName = StringUtils.getSetMethodByFieldName(propertyName);
                Method method = clazz.getDeclaredMethod(methodName, StringUtils.class);
                method.invoke(beanObj, value);
            }
        }

        //在返回之前将该对象存储到bean容器中
        singleObjects.put(name, beanObj);
        return beanObj;
    }

    @Override
    public <T> T getBean(String name, Class<? extends T> clazz) throws Exception {
        Object bean = getBean(name);
        if (bean == null) {
            return null;
        }
        return clazz.cast(bean);
    }
}

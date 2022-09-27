package com.spring.beans.factory.xml;

import com.spring.beans.BeanDefinition;
import com.spring.beans.MutablePropertyValues;
import com.spring.beans.PropertyValue;
import com.spring.beans.factory.support.BeanDefinitionReader;
import com.spring.beans.factory.support.BeanDefinitionRegistry;
import com.spring.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/**
 * @author Wang Hao
 * @date 2022/9/27 22:15
 * @description 根据xml文件进行解析
 */
public class XmlBeanDefinitionReader implements BeanDefinitionReader {

    /**
     * 声明注册表对象
     */
    private BeanDefinitionRegistry registry;

    public XmlBeanDefinitionReader() {
        registry = new SimpleBeanDefinitionRegistry();
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public void loadBeanDefinitions(String configLocation) throws DocumentException {
        SAXReader reader = new SAXReader();
        //获取类路径下的配置文件
        InputStream is = XmlBeanDefinitionReader.class.getClassLoader().getResourceAsStream(configLocation);
        Document document = reader.read(is);

        //根标签
        Element rootElement = document.getRootElement();
        //根标签下的bean标签对象
        List<Element> beanElementList = rootElement.elements();

        for (Element beanElement : beanElementList) {
            //id
            String id = beanElement.attributeValue("id");

            //class
            String className = beanElement.attributeValue("class");

            MutablePropertyValues propertyValues = new MutablePropertyValues();
            //property
            List<Element> propertyList = beanElement.elements("property");
            for (Element propertyElement : propertyList) {
                String name = propertyElement.attributeValue("name");
                String ref = propertyElement.attributeValue("ref");
                String value = propertyElement.attributeValue("value");
                propertyValues.addPropertyValue(new PropertyValue(name, ref, value));
            }

            //封装
            BeanDefinition beanDefinition = new BeanDefinition();
            beanDefinition.setId(id);
            beanDefinition.setClassName(className);
            beanDefinition.setPropertyValues(propertyValues);

            //将beanDefinition注册到注册表中
            registry.registerBeanDefinition(id, beanDefinition);
        }
    }
}

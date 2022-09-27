package com.spring.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Wang Hao
 * @date 2022/9/27 21:42
 * @description 存储和管理多个PropertyValue
 */
public class MutablePropertyValues implements Iterable<PropertyValue> {

    private final List<PropertyValue> propertyValueList;

    public MutablePropertyValues() {
        this.propertyValueList = new ArrayList<>();
    }

    public MutablePropertyValues(List<PropertyValue> propertyValueList) {
        if (propertyValueList == null) {
            this.propertyValueList = new ArrayList<>();
        } else {
            this.propertyValueList = propertyValueList;
        }
    }

    /**
     * 获取PropertyValue数组
     *
     * @return
     */
    public PropertyValue[] getPropertyValues() {
        return propertyValueList.toArray(new PropertyValue[0]);
    }

    /**
     * 根据名称获取PropertyValue对象
     *
     * @param propertyName
     * @return
     */
    public PropertyValue getPropertyValueByName(String propertyName) {
        for (PropertyValue propertyValue : propertyValueList) {
            if (propertyValue.getName().equals(propertyValue)) {
                return propertyValue;
            }
        }
        return null;
    }

    /**
     * 判断集合是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return propertyValueList.isEmpty();
    }

    /**
     * 添加
     *
     * @param propertyValue
     * @return
     */
    public MutablePropertyValues addPropertyValue(PropertyValue propertyValue) {
        for (int i = 0; i < propertyValueList.size(); i++) {
            PropertyValue currentPropertyValue = this.propertyValueList.get(i);
            if (currentPropertyValue.getName().equals(propertyValue.getName())) {
                propertyValueList.set(i, new PropertyValue(propertyValue.getName(), propertyValue.getRef(), propertyValue.getValue()));
                return this;
            }
        }
        this.propertyValueList.add(propertyValue);
        return this;
    }

    /**
     * 判断是否包含指定名称的PropertyValue对象
     *
     * @param propertyName
     * @return
     */
    public boolean contains(String propertyName) {
        return this.getPropertyValueByName(propertyName) != null;
    }

    /**
     * 获取迭代器对象
     *
     * @return
     */
    @Override
    public Iterator<PropertyValue> iterator() {
        return propertyValueList.listIterator();
    }
}

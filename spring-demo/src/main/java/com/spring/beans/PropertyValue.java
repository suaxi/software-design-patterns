package com.spring.beans;

/**
 * @author Wang Hao
 * @date 2022/9/27 21:39
 * @description 封装bean标签下的property属性
 */
public class PropertyValue {

    /**
     * name
     */
    private String name;

    /**
     * ref
     */
    private String ref;

    /**
     * value:给基本数据类型及String类型赋的值
     */
    private String value;

    public PropertyValue() {
    }

    public PropertyValue(String name, String ref, String value) {
        this.name = name;
        this.ref = ref;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

package com.spring.context.utils;

/**
 * @author Wang Hao
 * @date 2022/9/27 23:02
 */
public class StringUtils {

    private StringUtils() {

    }

    /**
     * 根据字段名获取set方法
     * @param fieldName
     * @return
     */
    public static String getSetMethodNameByFieldName(String fieldName) {
        return "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    }
}

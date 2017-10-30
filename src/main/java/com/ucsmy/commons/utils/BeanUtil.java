package com.ucsmy.commons.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapperImpl;

import java.util.HashSet;
import java.util.Set;

/**
 * bean工具类，封装一些常用的操作bean的方法
 * Created by chenqilin on 2017/4/18.
 */
public class BeanUtil {

    /**
     * 使用BeanUtils.copyProperties复制对象属性，过滤值为null的属性
     * @param source
     * @param target
     */
    public static void copyPropertiesIgnoreNull(Object source, Object target) {
        final org.springframework.beans.BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet<>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        emptyNames.toArray(result);
        BeanUtils.copyProperties(source, target, result);
    }
}

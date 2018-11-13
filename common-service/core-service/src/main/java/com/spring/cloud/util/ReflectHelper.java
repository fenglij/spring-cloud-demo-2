package com.spring.cloud.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * 利用java反射机制，提供访问类的详细信息和类对象的工具方法
 */
public class ReflectHelper {

    private static final Logger log = LoggerFactory.getLogger(ReflectHelper.class);

    /**
     * 获取obj象的Field
     * @param obj
     * @param filedName
     * @return
     */
    public static Field getFiledByFiledName(Object obj,String filedName){
        for(Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()){
            try {
                return superClass.getDeclaredField(filedName);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        return null;

    }

    /**
     * 通过java反射获取定义类声明的基类的范型
     * @param clazz
     * @param index
     * @return
     */
    public static Class getSuperClassgenericType(final Class clazz, final int index){
        Type genericType = clazz.getGenericSuperclass();
        if(!(genericType instanceof ParameterizedType)){
            return Object.class;
        }
        Type[] params = ((ParameterizedType) genericType).getActualTypeArguments();
        Arrays.asList(params).forEach(type -> {
            System.out.println(type.getTypeName());
        });

        if(index >= params.length || index < 0){
            return Object.class;
        }
        if(!(params[index] instanceof Class)){
            return Object.class;
        }
        return (Class)params[index];

    }

}

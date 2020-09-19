package com.atguigu.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author xzt
 * @create 2020-07-23 10:03
 */
public class WebUtils {

//    private static ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    public static <T>T copyParamToBean(Map value , T bean){
        try {
            BeanUtils.populate(bean,value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parseInt(String strInt,int defaultValue){
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
//            e.printStackTrace();
        }
        return defaultValue;
    }

    /**
     * 从ioc容器中获取组件的方法
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> clazz){
        WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
        return context.getBean(clazz);
    }

}

package cn.abelib.springframework.utils;

import cn.abelib.springframework.beans.factory.BeanFactory;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2024/3/5 23:08
 */
public class BeanFactoryUtils {

    /**
     * Return whether the given name is a factory dereference
     * (beginning with the factory dereference prefix).
     * @param name the name of the bean
     * @return whether the given name is a factory dereference
     * @see BeanFactory#FACTORY_BEAN_PREFIX
     */
    public static boolean isFactoryDereference(String name) {
        return (name != null && name.startsWith(BeanFactory.FACTORY_BEAN_PREFIX));
    }
}

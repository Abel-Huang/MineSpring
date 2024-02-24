package cn.abelib.springframework.beans.factory.support;

import cn.abelib.springframework.beans.BeansException;

import java.lang.reflect.Constructor;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2023/11/1 23:43
 */
public interface InstantiationStrategy {

    Object instantiate(AbstractBeanDefinition beanDefinition, String beanName, Constructor<?> ctor, Object... args) throws BeansException;

}

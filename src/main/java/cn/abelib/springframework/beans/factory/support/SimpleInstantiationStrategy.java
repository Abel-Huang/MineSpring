package cn.abelib.springframework.beans.factory.support;

import cn.abelib.springframework.beans.BeansException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2023/11/1 23:58
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(AbstractBeanDefinition beanDefinition, String beanName, Constructor<?> ctor, Object... args) throws BeansException {
        Class clazz = beanDefinition.getBeanClass();
        try {
            if (Objects.nonNull(ctor)) {
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            } else {
                return clazz.getDeclaredConstructor().newInstance();
            }
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new BeansException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
    }
}

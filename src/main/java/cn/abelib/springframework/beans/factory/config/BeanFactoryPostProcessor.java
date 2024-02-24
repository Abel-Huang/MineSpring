package cn.abelib.springframework.beans.factory.config;

import cn.abelib.springframework.beans.BeansException;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2023/12/27 0:22
 * 在 Bean 对象注册后但未实例化之前
 * 对 BeanDefinition 执行修改操作
 */
public interface BeanFactoryPostProcessor {

    /**
     * 在所有的 BeanDefinition 加载完成后，
     * 实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}

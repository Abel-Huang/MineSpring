package cn.abelib.springframework.beans.factory.config;

import cn.abelib.springframework.beans.factory.ListableBeanFactory;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2023/12/12 23:36
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory  {
    void preInstantiateSingletons();

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}

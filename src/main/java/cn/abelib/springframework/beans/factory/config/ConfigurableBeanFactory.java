package cn.abelib.springframework.beans.factory.config;

import cn.abelib.springframework.beans.BeansException;
import cn.abelib.springframework.beans.factory.BeanFactory;
import cn.abelib.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2023/12/12 23:54
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    /**
     * Determine whether the bean with the given name is a FactoryBean.
     * @since 2.5
     */
    boolean isFactoryBean(String name) throws BeansException;

    /**
     * 销毁单例对象
     */
    void destroySingletons();

    /**
     * Set the parent of this bean factory.
     */
    void setParentBeanFactory(BeanFactory parentBeanFactory) throws IllegalStateException;

    /**
     * Set the class loader to use for loading bean classes.
     * Default is the thread context class loader.
     */
    void setBeanClassLoader(ClassLoader beanClassLoader);

    /**
     * Return this factory's class loader for loading bean classes.
     */
    ClassLoader getBeanClassLoader();
}

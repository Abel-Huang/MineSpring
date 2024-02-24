package cn.abelib.springframework.context;

import cn.abelib.springframework.beans.BeansException;
import cn.abelib.springframework.beans.factory.config.BeanFactoryPostProcessor;
import cn.abelib.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.List;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2023/12/27 0:08
 */
public interface ConfigurableApplicationContext extends ApplicationContext  {

    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;

    void registerShutdownHook();

    void close();

    /**
     * Add a new BeanFactoryPostProcessor that will get applied to the internal
     * bean factory of this application context on refresh, before any of the
     * bean definitions get evaluated. To be invoked during context configuration.
     */
    void addBeanFactoryPostProcessor(BeanFactoryPostProcessor postProcessor);

    /**
     * Return the list of BeanFactoryPostProcessors that will get applied
     * to the internal BeanFactory.
     */
    List<BeanFactoryPostProcessor> getBeanFactoryPostProcessors();

    /**
     * Return the internal bean factory of this application context.
     */
    ConfigurableListableBeanFactory getBeanFactory() throws IllegalStateException;
}

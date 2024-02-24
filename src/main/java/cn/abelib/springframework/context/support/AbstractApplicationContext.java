package cn.abelib.springframework.context.support;

import cn.abelib.springframework.beans.BeansException;
import cn.abelib.springframework.beans.factory.config.BeanFactoryPostProcessor;
import cn.abelib.springframework.beans.factory.config.BeanPostProcessor;
import cn.abelib.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import cn.abelib.springframework.context.ConfigurableApplicationContext;
import cn.abelib.springframework.core.io.DefaultResourceLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2023/12/27 0:05
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    /** BeanFactoryPostProcessors to apply on refresh */
    private final List<BeanFactoryPostProcessor> beanFactoryPostProcessors = new ArrayList<BeanFactoryPostProcessor>();

    //---------------------------------------------------------------------
    // Implementation of BeanFactory interface
    //---------------------------------------------------------------------
    @Override
    public Object getBean(String name) {
        return getBeanFactory().getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public void refresh() throws BeansException {

        // 1. 创建BeanFactory, 加载BeanDefinition
        prepareRefresh();

        // 2. 获取BeanFactory
        ConfigurableListableBeanFactory beanFactory = obtainFreshBeanFactory();

        // 3. 准备BeanFactory
        prepareBeanFactory(beanFactory);

        // 3. 执行BeanFactoryPostProcessor
        invokeBeanFactoryPostProcessors(beanFactory);

        // 4. 执行BeanPostProcessor
        registerBeanPostProcessors(beanFactory);

        // 5. 实例化单例Bean
        beanFactory.preInstantiateSingletons();
    }

    protected void prepareRefresh() {
        // do noting now
    }

    @Override
    public abstract ConfigurableListableBeanFactory getBeanFactory() throws IllegalStateException;

    protected ConfigurableListableBeanFactory obtainFreshBeanFactory() {
        refreshBeanFactory();
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();
        return beanFactory;
    }

    /**
     * Configure the factory's standard context characteristics,
     * such as the context's ClassLoader and post-processors.
     */
    protected void prepareBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        // Configure the bean factory with context callbacks. 实现Bean对象感知所属的ApplicationContext
        beanFactory.addBeanPostProcessor(new ApplicationContextAwareProcessor(this));
    }


    /**
     * Subclasses must implement this method to perform the actual configuration load.
     */
    protected abstract void refreshBeanFactory() throws BeansException, IllegalStateException;

    @Override
    public void addBeanFactoryPostProcessor(BeanFactoryPostProcessor postProcessor) {
        this.beanFactoryPostProcessors.add(postProcessor);
    }

    /**
     * Return the list of BeanFactoryPostProcessors that will get applied
     * to the internal BeanFactory.
     */
    @Override
    public List<BeanFactoryPostProcessor> getBeanFactoryPostProcessors() {
        return this.beanFactoryPostProcessors;
    }

    /**
     * 执行 BeanFactoryPostProcessor
     * @param beanFactory
     */
    protected void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    protected void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    @Override
    public void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
    }

    @Override
    public void close() {
        getBeanFactory().destroySingletons();
    }

    protected void destroyBeans() {
        getBeanFactory().destroySingletons();
    }

    protected abstract void closeBeanFactory();
}

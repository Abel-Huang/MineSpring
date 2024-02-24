package cn.abelib.springframework.context.support;

import cn.abelib.springframework.beans.BeansException;
import cn.abelib.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import cn.abelib.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2023/12/27 0:06
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {
    private DefaultListableBeanFactory beanFactory;

    private String[] configLocations;

    @Override
    protected void prepareRefresh() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    public ConfigurableListableBeanFactory getBeanFactory() throws IllegalStateException {
        if (this.beanFactory == null) {
            throw new IllegalStateException("BeanFactory not initialized or already closed - " +
                    "call 'refresh' before accessing beans via the ApplicationContext");
        }
        return this.beanFactory;
    }

    @Override
    protected void refreshBeanFactory() throws BeansException, IllegalStateException {
        if (hasBeanFactory()) {
            destroyBeans();
            closeBeanFactory();
        }
        try {
            DefaultListableBeanFactory beanFactory = createBeanFactory();
            customizeBeanFactory(beanFactory);
            loadBeanDefinitions(beanFactory);
            this.beanFactory = beanFactory;
        }
        catch (Exception ex) {
            throw new BeansException("I/O error parsing bean definition source", ex);
        }
    }

    /**
     * Customize the internal bean factory used by this context.
     */
    protected void customizeBeanFactory(DefaultListableBeanFactory beanFactory) {
        // do nothing now
    }

    protected DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    /**
     * Determine whether this context currently holds a bean factory,
     * i.e. has been refreshed at least once and not been closed yet.
     */
    protected final boolean hasBeanFactory() {
        return (this.beanFactory != null);
    }

    @Override
    protected final void closeBeanFactory() {
        this.beanFactory = null;
    }

    /**
     * Return an array of resource locations, referring to the XML bean definition
     * files that this context should be built with. Can also include location
     * patterns, which will get resolved via a ResourcePatternResolver.
     */
    protected String[] getConfigLocations() {
        return (this.configLocations != null ? this.configLocations : getDefaultConfigLocations());
    }

    protected String[] getDefaultConfigLocations() {
        return null;
    }


    public void setConfigLocation(String location) {
        // todo StringUtils.tokenizeToStringArray impl
        setConfigLocations(new String[]{location});
    }

    /**
     * Set the config locations for this application context.
     * <p>If not set, the implementation may use a default as appropriate.
     */
    public void setConfigLocations(String... locations) {
        if (locations != null) {
            this.configLocations = new String[locations.length];
            for (int i = 0; i < locations.length; i++) {
                this.configLocations[i] = locations[i].trim();
            }
        }
        else {
            this.configLocations = null;
        }
    }
}

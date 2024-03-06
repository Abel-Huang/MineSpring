package cn.abelib.springframework.beans.factory;

import cn.abelib.springframework.beans.BeansException;
import cn.abelib.springframework.beans.factory.config.BeanPostProcessor;
import cn.abelib.springframework.beans.factory.config.ConfigurableBeanFactory;
import cn.abelib.springframework.beans.factory.support.AbstractBeanDefinition;
import cn.abelib.springframework.beans.factory.support.FactoryBeanRegistrySupport;
import cn.abelib.springframework.utils.BeanFactoryUtils;
import cn.abelib.springframework.utils.ClassUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2023/10/26 0:35
 */
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    /** Parent bean factory, for bean inheritance support */
    private BeanFactory parentBeanFactory;

    /** ClassLoader to resolve bean class names with, if necessary */
    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return doGetBean(name, requiredType, null, false);
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null, null, false);
    }

    /**
     * @param name
     * @param args
     * @return
     * @throws BeansException
     */
    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, null, args, false);
    }

    /**
     * TODO 循环依赖
     * @param beanName
     * @param requiredType
     * @param args
     * @param typeCheckOnly
     * @param <T>
     * @return
     * @throws BeansException
     */
    protected <T> T doGetBean(final String beanName, final Class<T> requiredType, final Object[] args, boolean typeCheckOnly)
            throws BeansException {

        // Check if bean definition exists in this factory.
        BeanFactory parentBeanFactory = getParentBeanFactory();
        if (parentBeanFactory != null && !containsBeanDefinition(beanName)) {
            // Not found -> check parent.
            if (args != null) {
                // Delegation to parent with explicit args.
                return (T) parentBeanFactory.getBean(beanName, args);
            }
            else {
                // No args -> delegate to standard getBean method.
                return parentBeanFactory.getBean(beanName, requiredType);
            }
        }

        Object sharedInstance = getSingleton(beanName);
        if (sharedInstance != null) {
            return (T) getObjectForBeanInstance(sharedInstance, beanName);
        }

        AbstractBeanDefinition beanDefinition = getBeanDefinition(beanName);
        Object bean = createBean(beanName, beanDefinition, args);
        return (T) getObjectForBeanInstance(bean, beanName);
    }

    /**
     * Get the object for the given bean instance, either the bean
     * instance itself or its created object in case of a FactoryBean.
     */
    protected Object getObjectForBeanInstance(Object beanInstance, String beanName) {
        // If it's a FactoryBean, we use it to create a bean instance, unless the
        // caller actually wants a reference to the factory.
        if (!(beanInstance instanceof FactoryBean)) {
            return beanInstance;
        }

        Object object = getCachedObjectForFactoryBean(beanName);
        if (object == null) {
            // Return bean instance from factory.
            FactoryBean<?> factory = (FactoryBean<?>) beanInstance;
            object = getObjectFromFactoryBean(factory, beanName);
        }
        return object;
    }

    protected abstract AbstractBeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, AbstractBeanDefinition beanDefinition, Object[] args) throws BeansException;

    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }


    //---------------------------------------------------------------------
    // Abstract methods to be implemented by subclasses
    //---------------------------------------------------------------------

    /**
     * Check if this bean factory contains a bean definition with the given name.
     */
    protected abstract boolean containsBeanDefinition(String beanName);

    //---------------------------------------------------------------------
    // Implementation of HierarchicalBeanFactory interface
    //---------------------------------------------------------------------

    @Override
    public BeanFactory getParentBeanFactory() {
        return this.parentBeanFactory;
    }

    @Override
    public boolean containsLocalBean(String name) { ;
        return ((containsSingleton(name) || containsBeanDefinition(name)) &&
                (!BeanFactoryUtils.isFactoryDereference(name) || isFactoryBean(name)));
    }

    //---------------------------------------------------------------------
    // Implementation of ConfigurableBeanFactory interface
    //---------------------------------------------------------------------
    @Override
    public void setParentBeanFactory(BeanFactory parentBeanFactory) {
        if (this.parentBeanFactory != null && this.parentBeanFactory != parentBeanFactory) {
            throw new IllegalStateException("Already associated with parent BeanFactory: " + this.parentBeanFactory);
        }
        this.parentBeanFactory = parentBeanFactory;
    }

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    @Override
    public boolean isFactoryBean(String name) throws BeansException {
        Object beanInstance = getSingleton(name);
        if (beanInstance != null) {
            return (beanInstance instanceof FactoryBean);
        }
        else if (containsSingleton(name)) {
            // null instance registered
            return false;
        }

        // No singleton instance found -> check bean definition.
        if (!containsBeanDefinition(name) && getParentBeanFactory() instanceof ConfigurableBeanFactory) {
            // No bean definition found in this factory -> delegate to parent.
            return ((ConfigurableBeanFactory) getParentBeanFactory()).isFactoryBean(name);
        }

        // todo 暂时不支持merge
        return false;
    }

    @Override
    public void setBeanClassLoader(ClassLoader beanClassLoader) {
        this.beanClassLoader = (beanClassLoader != null ? beanClassLoader : ClassUtils.getDefaultClassLoader());
    }

    @Override
    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader;
    }
}

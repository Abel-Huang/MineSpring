package cn.abelib.springframework.beans.factory.support;

import cn.abelib.springframework.beans.PropertyValues;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2024/1/28 19:00
 */
public class RootBeanDefinition extends AbstractBeanDefinition {
    /**
     * Create a new RootBeanDefinition for a singleton.
     */
    public RootBeanDefinition(Class<?> beanClass) {
        super();
        setBeanClass(beanClass);
    }

    public RootBeanDefinition(Class beanClass, PropertyValues propertyValues) {
        super(beanClass, propertyValues);
    }

    /**
     * Create a new RootBeanDefinition, to be configured through its bean
     * properties and configuration methods.
     */
    public RootBeanDefinition() {
        super();
    }


}

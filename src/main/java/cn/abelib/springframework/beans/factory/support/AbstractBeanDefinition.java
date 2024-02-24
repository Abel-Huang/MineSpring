package cn.abelib.springframework.beans.factory.support;

import cn.abelib.springframework.beans.PropertyValues;
import cn.abelib.springframework.beans.factory.config.BeanDefinition;

import java.util.Objects;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2023/10/25 23:06
 */
public abstract class AbstractBeanDefinition implements BeanDefinition {

    /**
     * Constant for the default scope name: {@code ""}, equivalent to singleton
     * status unless overridden from a parent bean definition (if applicable).
     */
    public static final String SCOPE_DEFAULT = "";

    private volatile Object beanClass;

    private PropertyValues propertyValues;

    private String initMethodName;

    private String destroyMethodName;

    private String scope = SCOPE_DEFAULT;

    public AbstractBeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public AbstractBeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = Objects.nonNull(propertyValues) ? propertyValues : new PropertyValues();
    }

    public AbstractBeanDefinition() {
        this.propertyValues = new PropertyValues();
    }

    /**
     * Specify the bean class name of this bean definition.
     */
    @Override
    public void setBeanClassName(String beanClassName) {
        this.beanClass = beanClassName;
    }

    /**
     * Return the current bean class name of this bean definition.
     */
    @Override
    public String getBeanClassName() {
        Object beanClassObject = this.beanClass;
        if (beanClassObject instanceof Class) {
            return ((Class<?>) beanClassObject).getName();
        }
        else {
            return (String) beanClassObject;
        }
    }

    /**
     * Specify the class for this bean.
     */
    public void setBeanClass(Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    /**
     * Return the class of the wrapped bean, if already resolved.
     */
    public Class<?> getBeanClass() throws IllegalStateException {
        Object beanClassObject = this.beanClass;
        if (beanClassObject == null) {
            throw new IllegalStateException("No bean class specified on bean definition");
        }
        if (!(beanClassObject instanceof Class)) {
            throw new IllegalStateException(
                    "Bean class name [" + beanClassObject + "] has not been resolved into an actual Class");
        }
        return (Class<?>) beanClassObject;
    }

    public PropertyValues getPropertyValues() {
        return this.propertyValues;
    }

    public String getInitMethodName() {
        return this.initMethodName;
    }

    public String getDestroyMethodName() {
        return this.destroyMethodName;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }

    public void setDestroyMethodName(String destroyMethodName) {
        this.destroyMethodName = destroyMethodName;
    }

    @Override
    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public String getScope() {
        return this.scope;
    }

    /**
     * Return whether this a <b>Singleton</b>, with a single shared instance
     * returned from all calls.
     * @see #SCOPE_SINGLETON
     */
    @Override
    public boolean isSingleton() {
        return SCOPE_SINGLETON.equals(scope) || SCOPE_DEFAULT.equals(scope);
    }

    /**
     * Return whether this a <b>Prototype</b>, with an independent instance
     * returned for each call.
     * @see #SCOPE_PROTOTYPE
     */
    @Override
    public boolean isPrototype() {
        return SCOPE_PROTOTYPE.equals(scope);
    }
}

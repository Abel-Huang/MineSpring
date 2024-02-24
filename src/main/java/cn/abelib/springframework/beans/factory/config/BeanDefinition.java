package cn.abelib.springframework.beans.factory.config;

import cn.abelib.springframework.beans.PropertyValues;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2024/1/28 18:59
 */
public interface BeanDefinition {

    /**
     * Scope identifier for the standard singleton scope: "singleton".
     * <p>Note that extended bean factories might support further scopes.
     */
    String SCOPE_SINGLETON = ConfigurableBeanFactory.SCOPE_SINGLETON;

    /**
     * Scope identifier for the standard prototype scope: "prototype".
     * <p>Note that extended bean factories might support further scopes.
     */
    String SCOPE_PROTOTYPE = ConfigurableBeanFactory.SCOPE_PROTOTYPE;

    /**
     * Return the current bean class name of this bean definition.
     */
    String getBeanClassName();

    /**
     * Specify the bean class name of this bean definition.
     */
    void setBeanClassName(String beanClassName);

    /**
     * Return the property values to be applied to a new instance of the bean.
     */
    PropertyValues getPropertyValues();

    /**
     * Override the target scope of this bean, specifying a new scope name.
     * @see #SCOPE_SINGLETON
     * @see #SCOPE_PROTOTYPE
     */
    void setScope(String scope);

    /**
     * Return the name of the current target scope for this bean,
     * or {@code null} if not known yet.
     */
    String getScope();

    // Read-only attributes

    /**
     * Return whether this a <b>Singleton</b>, with a single, shared instance
     * returned on all calls.
     * @see #SCOPE_SINGLETON
     */
    boolean isSingleton();

    /**
     * Return whether this a <b>Prototype</b>, with an independent instance
     * returned for each call.
     * @since 3.0
     * @see #SCOPE_PROTOTYPE
     */
    boolean isPrototype();
}

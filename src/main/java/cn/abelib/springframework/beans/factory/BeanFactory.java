package cn.abelib.springframework.beans.factory;

import cn.abelib.springframework.beans.BeansException;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2023/10/25 23:06
 */
public interface BeanFactory {

    /**
     * Used to dereference a {@link FactoryBean} instance and distinguish it from
     * beans <i>created</i> by the FactoryBean.
     */
    String FACTORY_BEAN_PREFIX = "&";

    Object getBean(String name);

    Object getBean(String name, Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}

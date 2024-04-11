package cn.abelib.springframework.beans.factory.config;

import cn.abelib.springframework.beans.BeansException;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2024/4/7 下午 11:00
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {
    /**
     * Apply this BeanPostProcessor <i>before the target bean gets instantiated</i>.
     * The returned bean object may be a proxy to use instead of the target bean,
     * effectively suppressing default instantiation of the target bean.
     */
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;
}

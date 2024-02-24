package cn.abelib.springframework.beans.factory.config;

import cn.abelib.springframework.beans.BeansException;
import cn.abelib.springframework.beans.factory.BeanFactory;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2023/12/12 23:47
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    /**
     * Apply BeanPostProcessors to the given existing bean
     * instance, invoking their postProcessBeforeInitialization methods.
     * The returned bean instance may be a wrapper around the original.
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName)
            throws BeansException;

    /**
     * Apply BeanPostProcessors to the given existing bean
     * instance, invoking their postProcessAfterInitialization methods.
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName)
            throws BeansException;
}

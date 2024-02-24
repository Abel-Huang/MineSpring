package cn.abelib.springframework.context.support;

import cn.abelib.springframework.beans.BeansException;
import cn.abelib.springframework.beans.factory.config.BeanPostProcessor;
import cn.abelib.springframework.context.ApplicationContextAware;
import cn.abelib.springframework.context.ConfigurableApplicationContext;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2024/2/4 22:59
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {
    private final ConfigurableApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ConfigurableApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware){
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}

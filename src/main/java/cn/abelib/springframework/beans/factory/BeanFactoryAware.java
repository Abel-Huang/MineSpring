package cn.abelib.springframework.beans.factory;

import cn.abelib.springframework.beans.BeansException;

/**
 * Interface to be implemented by beans that wish to be aware of their
 * owning {@link BeanFactory}
 *
 * @author abel.huang
 * @version 1.0
 * @date 2024/2/4 22:56
 *
 */
public interface BeanFactoryAware extends Aware {

    /**
     * Callback that supplies the owning factory to a bean instance.
     */
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}

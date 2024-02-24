package cn.abelib.springframework.context;

import cn.abelib.springframework.beans.BeansException;
import cn.abelib.springframework.beans.factory.Aware;

/**
 * Interface to be implemented by any object that wishes to be notified
 * of the {@link ApplicationContext} that it runs in.
 * @author abel.huang
 * @version 1.0
 * @date 2024/2/4 22:58
 */
public interface ApplicationContextAware extends Aware {

    /**
     * Set the ApplicationContext that this object runs in.
     * Normally this call will be used to initialize the object.
     */
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}

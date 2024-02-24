package cn.abelib.springframework.beans.factory;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2024/1/9 23:10
 */
public interface InitializingBean {

    /**
     * Invoked by a BeanFactory after it has set all bean properties supplied
     * (and satisfied BeanFactoryAware and ApplicationContextAware).
     */
    void afterPropertiesSet() throws Exception;
}

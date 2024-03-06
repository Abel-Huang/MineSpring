package cn.abelib.springframework.beans.factory.config;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2023/10/26 0:36
 */
public interface SingletonBeanRegistry {

    /**
     * Register the given existing object as singleton in the bean registry,
     * under the given bean name.
     */
    void registerSingleton(String beanName, Object singletonObject);

    Object getSingleton(String beanName);

    /**
     * Check if this registry contains a singleton instance with the given name.
     */
    boolean containsSingleton(String beanName);
}

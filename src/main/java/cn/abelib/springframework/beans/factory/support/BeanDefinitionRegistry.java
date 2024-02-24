package cn.abelib.springframework.beans.factory.support;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2023/10/25 23:50
 */
public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String name, AbstractBeanDefinition beanDefinition);

    boolean containsBeanDefinition(String beanName);
}

package cn.abelib.springframework.beans.factory.config;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2023/10/26 0:36
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}

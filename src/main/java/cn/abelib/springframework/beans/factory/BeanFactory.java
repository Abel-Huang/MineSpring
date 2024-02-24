package cn.abelib.springframework.beans.factory;

import cn.abelib.springframework.beans.BeansException;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2023/10/25 23:06
 */
public interface BeanFactory {

    Object getBean(String name);

    Object getBean(String name, Object... args) throws BeansException;

    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}

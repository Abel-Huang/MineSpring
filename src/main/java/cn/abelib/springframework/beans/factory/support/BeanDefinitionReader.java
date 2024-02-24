package cn.abelib.springframework.beans.factory.support;

import cn.abelib.springframework.beans.BeansException;
import cn.abelib.springframework.core.io.Resource;
import cn.abelib.springframework.core.io.ResourceLoader;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2023/12/12 23:31
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    int loadBeanDefinitions(Resource resource) throws BeansException;

    int loadBeanDefinitions(Resource... resources) throws BeansException;

    int loadBeanDefinitions(String location) throws BeansException;

    int loadBeanDefinitions(String... locations) throws BeansException;
}

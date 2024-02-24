package cn.abelib.springframework.beans.factory.support;

import cn.abelib.springframework.beans.BeansException;
import cn.abelib.springframework.core.io.DefaultResourceLoader;
import cn.abelib.springframework.core.io.Resource;
import cn.abelib.springframework.core.io.ResourceLoader;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2023/12/12 23:33
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this.registry = registry;

        // Determine ResourceLoader to use.
        if (this.registry instanceof ResourceLoader) {
            this.resourceLoader = (ResourceLoader) this.registry;
        }
        else {
            this.resourceLoader = new DefaultResourceLoader();
        }
    }

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public final BeanDefinitionRegistry getRegistry() {
        return this.registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    @Override
    public int loadBeanDefinitions(Resource... resources) throws BeansException {
        int counter = 0;
        for (Resource resource : resources) {
            counter += loadBeanDefinitions(resource);
        }
        return counter;
    }

    @Override
    public int loadBeanDefinitions(String... locations) throws BeansException {
        int counter = 0;
        for (String location : locations) {
            counter += loadBeanDefinitions(location);
        }
        return counter;
    }

}

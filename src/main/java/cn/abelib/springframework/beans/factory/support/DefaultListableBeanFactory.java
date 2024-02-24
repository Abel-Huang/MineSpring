package cn.abelib.springframework.beans.factory.support;

import cn.abelib.springframework.beans.BeansException;
import cn.abelib.springframework.beans.factory.AbstractAutowireCapableBeanFactory;
import cn.abelib.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import com.google.common.collect.Maps;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2023/10/26 0:39
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory
        implements ConfigurableListableBeanFactory, BeanDefinitionRegistry {

    private Map<String, AbstractBeanDefinition> beanDefinitionMap = Maps.newHashMap();

    /** List of names of manually registered singletons, in registration order */
    private volatile Set<String> manualSingletonNames = new LinkedHashSet<>(16);

    @Override
    public void registerBeanDefinition(String beanName, AbstractBeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    @Override
    public AbstractBeanDefinition getBeanDefinition(String beanName) throws BeansException {
        AbstractBeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new BeansException("No bean named '" + beanName + "' is defined");
        }

        return beanDefinition;
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        Map<String, T> map = Maps.newHashMap();
        beanDefinitionMap.forEach((beanName, beanDefinition) -> {
            if (type.isAssignableFrom(beanDefinition.getBeanClass())) {
                map.put(beanName, (T) getBean(beanName));
            }
        });
        return map;
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return beanDefinitionMap.keySet().toArray(new String[0]);
    }

    @Override
    public void destroySingletons() {
        super.destroySingletons();
        this.manualSingletonNames.clear();
    }

    @Override
    public void preInstantiateSingletons() {
        beanDefinitionMap.keySet().forEach(this::getBean);
    }
}

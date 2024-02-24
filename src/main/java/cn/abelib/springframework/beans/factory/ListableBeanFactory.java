package cn.abelib.springframework.beans.factory;

import cn.abelib.springframework.beans.BeansException;

import java.util.Map;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2023/12/12 23:34
 */
public interface ListableBeanFactory extends BeanFactory {

    /**
     * Return the bean instances that match the given object type (including
     * subclasses),
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * Return the names of all beans defined in this factory.
     * <p>Does not consider any hierarchy this factory may participate in,
     * and ignores any singleton beans that have been registered by
     * other means than bean definitions.
     * @return the names of all beans defined in this factory,
     * or an empty array if none defined
     */
    String[] getBeanDefinitionNames();
}

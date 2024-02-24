package cn.abelib.springframework.beans.factory;

/**
 * Interface to be implemented by beans that want to be aware of their
 * bean name in a bean factory
 *
 * @author abel.huang
 * @version 1.0
 * @date 2024/2/4 22:56
 */
public interface BeanNameAware extends Aware {

    /**
     * Set the name of the bean in the bean factory that created this bean.
     */
    void setBeanName(String name);
}

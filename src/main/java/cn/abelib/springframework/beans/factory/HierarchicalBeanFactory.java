package cn.abelib.springframework.beans.factory;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2023/12/12 23:35
 */
public interface HierarchicalBeanFactory extends BeanFactory {

    /**
     * Return the parent bean factory,
     * or {@code null} if there is none.
     */
    BeanFactory getParentBeanFactory();


    /**
     * Return whether the local bean factory contains a bean of the given name,
     * ignoring beans defined in ancestor contexts.
     */
    boolean containsLocalBean(String name);

}

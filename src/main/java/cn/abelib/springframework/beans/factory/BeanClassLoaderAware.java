package cn.abelib.springframework.beans.factory;

/**
 * Callback that allows a bean to be aware of the bean
 * {@link ClassLoader class loader}; that is, the class loader used by the
 * present bean factory to load bean classes.
 *
 * @author abel.huang
 * @version 1.0
 * @date 2024/2/4 22:57
 */
public interface BeanClassLoaderAware extends Aware {

    /**
     * Callback that supplies the bean {@link ClassLoader class loader} to
     * a bean instance.
     */
    void setBeanClassLoader(ClassLoader classLoader);
}

package cn.abelib.springframework.beans.factory;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2024/2/22 0:10
 */
public interface FactoryBean<T> {

    /**
     * Return an instance (possibly shared or independent) of the object
     * managed by this factory.
     */
    T getObject() throws Exception;

    /**
     * Return the type of object that this FactoryBean creates,
     * or {@code null} if not known in advance.
     */
    Class<?> getObjectType();

    /**
     * Is the object managed by this factory a singleton? That is,
     * will {@link #getObject()} always return the same object
     * (a reference that can be cached)?
     */
    boolean isSingleton();
}

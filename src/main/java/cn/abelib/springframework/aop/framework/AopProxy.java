package cn.abelib.springframework.aop.framework;

/**
 * Delegate interface for a configured AOP proxy, allowing for the creation
 * of actual proxy objects.
 *
 * @author abel.huang
 * @version 1.0
 * @date 2024/3/19 22:44
 */
public interface AopProxy {

    /**
     * Create a new proxy object.
     */
    Object getProxy();

    /**
     * Create a new proxy object.
     */
    Object getProxy(ClassLoader classLoader);
}

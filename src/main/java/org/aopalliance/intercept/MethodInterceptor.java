package org.aopalliance.intercept;

/**
 * Intercepts calls on an interface on its way to the target. These
 * are nested "on top" of the target.
 *
 * @author abel.huang
 * @version 1.0
 * @date 2024/4/6 下午 11:39
 */
public interface MethodInterceptor extends Interceptor {
    /**
     * Implement this method to perform extra treatments before and
     * after the invocation.
     */
    Object invoke(MethodInvocation invocation) throws Throwable;

}

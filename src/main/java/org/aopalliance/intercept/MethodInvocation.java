package org.aopalliance.intercept;

import java.lang.reflect.Method;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2024/4/6 下午 7:43
 */
public interface MethodInvocation extends Invocation {

    /**
     * Get the method being called.
     */
    Method getMethod();

}

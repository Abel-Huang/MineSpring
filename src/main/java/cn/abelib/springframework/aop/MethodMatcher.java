package cn.abelib.springframework.aop;

import java.lang.reflect.Method;

/**
 * Part of a {@link Pointcut}: Checks whether the target method is eligible for advice.
 *
 * @author abel.huang
 * @version 1.0
 * @date 2024/3/19 0:05
 */
public interface MethodMatcher {

    /**
     * Perform static checking whether the given method matches. If this
     * returns {@code false} or if the {@link #isRuntime()} method
     * returns {@code false}, no runtime check (i.e. no.
     */
    boolean matches(Method method, Class<?> targetClass);

    /**
     * Is this MethodMatcher dynamic, that is, must a final call be made on the
     * {@link #matches(java.lang.reflect.Method, Class, Object[])} method at
     * runtime even if the 2-arg matches method returns {@code true}
     */
    boolean isRuntime();

    /**
     * Check whether there a runtime (dynamic) match for this method,
     * which must have matched statically.
     */
    boolean matches(Method method, Class<?> targetClass, Object... args);
}

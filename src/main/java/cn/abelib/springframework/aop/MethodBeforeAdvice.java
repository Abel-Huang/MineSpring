package cn.abelib.springframework.aop;

import java.lang.reflect.Method;

/**
 *
 * Advice invoked before a method is invoked. Such advices cannot
 * prevent the method call proceeding, unless they throw a Throwable.
 *
 * @author abel.huang
 * @version 1.0
 * @date 2024/3/31 下午 10:33
 */
public interface MethodBeforeAdvice extends BeforeAdvice {

    /**
     * Callback before a given method is invoked.
     */
    void before(Method method, Object[] args, Object target) throws Throwable;
}

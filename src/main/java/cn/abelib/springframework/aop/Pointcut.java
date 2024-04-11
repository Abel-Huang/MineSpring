package cn.abelib.springframework.aop;

/**
 * Core Spring pointcut abstraction.
 *
 * @author abel.huang
 * @version 1.0
 * @date 2024/3/19 0:03
 */
public interface Pointcut {

    /**
     * Return the ClassFilter for this pointcut.
     */
    ClassFilter getClassFilter();

    /**
     * Return the MethodMatcher for this pointcut.
     */
    MethodMatcher getMethodMatcher();
}

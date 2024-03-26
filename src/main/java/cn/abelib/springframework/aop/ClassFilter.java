package cn.abelib.springframework.aop;

/**
 * Filter that restricts matching of a pointcut or introduction to
 * a given set of target classes.
 *
 * @author abel.huang
 * @version 1.0
 * @date 2024/3/19 0:04
 */
public interface ClassFilter {

    /**
     * Should the pointcut apply to the given interface or target class?
     */
    boolean matches(Class<?> clazz);
}

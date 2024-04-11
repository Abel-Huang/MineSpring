package cn.abelib.springframework.aop;

import org.aopalliance.aop.Advice;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2024/3/31 下午 10:35
 */
public interface Advisor {

    /**
     * Return the advice part of this aspect. An advice may be an
     * interceptor, a before advice, a throws advice, etc.
     */
    Advice getAdvice();
}

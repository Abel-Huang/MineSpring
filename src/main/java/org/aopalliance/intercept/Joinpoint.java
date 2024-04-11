package org.aopalliance.intercept;

/**
 * This interface represents a generic runtime joinpoint (in the AOP
 * terminology).
 * @author abel.huang
 * @version 1.0
 * @date 2024/4/6 下午 11:34
 */
public interface Joinpoint {

    /**
     * Proceed to the next interceptor in the chain.
     */
    Object proceed() throws Throwable;

    /**
     * Return the object that holds the current joinpoint's static part.
     */
    Object getThis();

}

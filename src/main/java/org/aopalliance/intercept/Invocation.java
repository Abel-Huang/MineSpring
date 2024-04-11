package org.aopalliance.intercept;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2024/4/6 下午 7:44
 */
public interface Invocation extends Joinpoint {

    /**
     * Get the arguments as an array object.
     * It is possible to change element values within this
     */
    Object[] getArguments();

}
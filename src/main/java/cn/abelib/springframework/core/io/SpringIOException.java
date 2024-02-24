package cn.abelib.springframework.core.io;


import org.apache.commons.lang3.exception.ExceptionUtils;

/**
 * @author abel.huang
 * @version 1.0
 * @date 2024/1/27 23:58
 */
public class SpringIOException extends RuntimeException {

    public SpringIOException(Throwable e) {
        super(ExceptionUtils.getMessage(e), e);
    }

    public SpringIOException(String message) {
        super(message);
    }

    public SpringIOException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
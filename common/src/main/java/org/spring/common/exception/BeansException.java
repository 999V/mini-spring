package org.spring.common.exception;

/**
 * Beans异常
 *
 * @author zhengxin
 * @see RuntimeException
 * @since 1.0.0
 */
public class BeansException extends RuntimeException {

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }

}

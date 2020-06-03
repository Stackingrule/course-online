package com.course.server.exception;

/**
 * <h1>校验异常类</h1>
 */
public class ValidatorException extends RuntimeException {

    public ValidatorException(String message) {
        super(message);
    }
}

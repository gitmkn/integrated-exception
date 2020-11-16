package cn.makn;

import java.io.Serializable;

/**
 * 异常基类
 * @Auther: makn
 * @Date: 2020/8/16 23:24
 */
public class BaseException extends RuntimeException implements Serializable {
    public BaseException() {
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
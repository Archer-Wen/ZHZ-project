package com.zhzteam.zhz233.exception;

public class CRUDException extends RuntimeException {
    public CRUDException() {
        super();
    }

    public CRUDException(String message) {
        super(message);
    }

    public CRUDException(String message, Throwable cause) {
        super(message, cause);
    }

    public CRUDException(Throwable cause) {
        super(cause);
    }

    protected CRUDException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

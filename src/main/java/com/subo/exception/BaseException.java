package com.subo.exception;

public class BaseException extends RuntimeException {

    private static final long serialVersionUID = -2013099994778186749L;

    private Integer errorCode;
    private String subErrorCode;
    private String errorMessage;

    public String getSubErrorCode() {
        return subErrorCode;
    }

    public void setSubErrorCode(String subErrorCode) {
        this.subErrorCode = subErrorCode;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public BaseException(Integer errorCode, String subErrorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.subErrorCode = subErrorCode;
        this.errorMessage = errorMessage;
    }

    public BaseException(Integer errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public BaseException(Integer errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public BaseException() {
        super();
    }

    public BaseException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }
}

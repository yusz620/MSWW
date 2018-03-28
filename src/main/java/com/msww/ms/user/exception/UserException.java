package com.msww.ms.user.exception;

public class UserException extends RuntimeException {
    private static final long serialVersionUID = -7946191879726387151L;
    private Integer code;

    public UserException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


}

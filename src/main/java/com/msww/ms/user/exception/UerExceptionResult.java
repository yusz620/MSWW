package com.msww.ms.user.exception;

public enum UerExceptionResult {
    UNKOWN_ERROR(-1, "Uknown error"), USERNAME_NOT_EXIST(1, "UserName not exist"), USERNAME_OR_PASSWORD_WRONG(2,
            "UserName or password wrong"), USERNAME_ALREADY_EXIST(3, "UserName already exist");
    private Integer code;
    private String message;

    UerExceptionResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}

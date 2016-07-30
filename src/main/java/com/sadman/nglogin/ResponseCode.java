package com.sadman.nglogin;

/**
 * @author Sadman
 * @since Jul 30, 2016
 */
public enum ResponseCode {
    OPERATION_SUCCESSFUL(200),
    REGISTRATION_SUCCESSFUL(201),
    OPERATION_FAILED(101),
    AUTHENTICATION_FAILED(401);

    private int code;

    ResponseCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}

package com.flying.book.core.exception;

import com.flying.book.core.ResultCode;

public class PermissionForbiddenException extends BusinessException {
    private static final long serialVersionUID = 3721036867889297081L;

    public PermissionForbiddenException() {
    }

    public PermissionForbiddenException(Object data) {
        super.data = data;
    }

    public PermissionForbiddenException(ResultCode resultCode) {
        super(resultCode);
    }

    public PermissionForbiddenException(String msg) {
        super(msg);
    }
}

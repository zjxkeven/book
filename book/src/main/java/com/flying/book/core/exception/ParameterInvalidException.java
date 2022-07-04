package com.flying.book.core.exception;

import com.flying.book.core.ResultCode;

public class ParameterInvalidException extends BusinessException {
    private static final long serialVersionUID = 3721036867889297081L;

    public ParameterInvalidException() {
    }

    public ParameterInvalidException(Object data) {
        super.data = data;
    }

    public ParameterInvalidException(ResultCode resultCode) {
        super(resultCode);
    }

    public ParameterInvalidException(String msg) {
        super(msg);
    }
}

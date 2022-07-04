package com.flying.book.core.exception;

import com.flying.book.core.ResultCode;

public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 194906846739586856L;
    protected String code;
    protected String message;
    protected ResultCode resultCode;
    protected Object data;

    public BusinessException() {
        BusinessExceptionEnum exceptionEnum = BusinessExceptionEnum.getByEClass(this.getClass());
        if (exceptionEnum != null) {
            this.resultCode = exceptionEnum.getResultCode();
            this.code = exceptionEnum.getResultCode().code().toString();
            this.message = exceptionEnum.getResultCode().message().replaceAll("\\{}", "");
        }

    }

    public BusinessException(String code, String message) {
        this();
        this.code = code;
        this.message = message;
    }

    public BusinessException(String message) {
        this();
        this.message = message;
    }

    public BusinessException(ResultCode resultCode) {
        this.resultCode = resultCode;
        this.code = resultCode.code().toString();
        this.message = resultCode.message().replaceAll("\\{}", "");
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public ResultCode getResultCode() {
        return this.resultCode;
    }

    public Object getData() {
        return this.data;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public void setResultCode(final ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public void setData(final Object data) {
        this.data = data;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof BusinessException)) {
            return false;
        } else {
            BusinessException other = (BusinessException) o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59:
                {
                    Object this$code = this.getCode();
                    Object other$code = other.getCode();
                    if (this$code == null) {
                        if (other$code == null) {
                            break label59;
                        }
                    } else if (this$code.equals(other$code)) {
                        break label59;
                    }

                    return false;
                }

                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                Object this$resultCode = this.getResultCode();
                Object other$resultCode = other.getResultCode();
                if (this$resultCode == null) {
                    if (other$resultCode != null) {
                        return false;
                    }
                } else if (!this$resultCode.equals(other$resultCode)) {
                    return false;
                }

                Object this$data = this.getData();
                Object other$data = other.getData();
                if (this$data == null) {
                    if (other$data != null) {
                        return false;
                    }
                } else if (!this$data.equals(other$data)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BusinessException;
    }

    public int hashCode() {
        int PRIME = 1;
        int result = 1;
        Object $code = this.getCode();
        result = result * 59 + ($code == null ? 43 : $code.hashCode());
        Object $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        Object $resultCode = this.getResultCode();
        result = result * 59 + ($resultCode == null ? 43 : $resultCode.hashCode());
        Object $data = this.getData();
        result = result * 59 + ($data == null ? 43 : $data.hashCode());
        return result;
    }

    public String toString() {
        return "BusinessException(code=" + this.getCode() + ", message=" + this.getMessage() + ", resultCode=" + this.getResultCode() + ", data=" + this.getData() + ")";
    }
}

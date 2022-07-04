package com.flying.book.core;

public enum ResultCode {
    SUCCESS(200, "成功"),
    UNAUTHORIZED(401, "未授权的请求"),
    UNAUTHORIZED_OF_DELETE(403, "访问受限，未授权的请求"),
    NOT_EXISTED(404, "{}接口不存在"),
    ERROR(500, "error"),
    TIMEOUT(504, "{}服务超时"),
    MISSING_PARAM(505, "缺少参数{}"),
    CLASS_CAST_EXCEPTION(506, "类转换异常"),
    FAILURE(1000, "failure"),
    EXCEPTION(-1, "系统异常"),
    PARAM_IS_INVALID(10001, "{}参数无效"),
    PARAM_IS_BLANK(10002, "{}参数为空"),
    PARAM_TYPE_BIND_ERROR(10003, "{}参数类型错误"),
    PARAM_NOT_COMPLETE(10004, "{}参数缺失"),
    PARAM_NOT_NULL(10005, "参数不能为空"),
    PARAM_READABLE_ERR(10006, "请求参数不完整或不正确：【%s】"),
    USER_NOT_LOGGED_IN(20001, "用户{}未登录"),
    USER_LOGIN_ERROR(20002, "帐号{}不存在或密码错误"),
    USER_ACCOUNT_FORBIDDEN(20003, "帐号{}已被禁用"),
    USER_NOT_EXIST(20004, "用户{}不存在"),
    USER_HAS_EXISTED(20005, "用户{}已存在"),
    USER_NOT_MAIN_GROUP(20006, "用户{}未设置主岗位"),
    USER_IS_EXPIRE(20007, "用户{}已过期"),
    USER_IS_NOT_VALID_DATE(20008, "用户{}不在有效期内"),
    USER_IS_NOT_VALID(20009, "用户{}无效"),
    USER_ACCOUNT_LOCKED(20010, "帐号{}已被锁定"),
    USER_CREDENTIALS_EXPIRED(20011, "用户{}凭证已过期"),
    USER_NOT_BIND_OPENID(20012, "此用户未绑定内部帐号"),
    PASSWORD_NOT_VALID(20013, "密码设置不符合规则，请重新设置"),
    REGISTER_FAIL(20014, "app注册失败"),
    CODE_ERROR(20015, "短信验证码错误"),
    CODE_ERROR_MAX(20115, "验证码已失效，请点击重新发送"),
    ID_CARD_ERROR_DESC(20016, "证件号码错误，请重新输入"),
    TRANS_ID_NOT_EXIST(20017, "事务ID不存在"),
    FLOW_ERROR(20018, "注册流程不正确，请检查"),
    PHONE_REGEX_ERROR(20019, "手机号码错误，请重新输入"),
    CODE_NULL_ERROR(20020, "验证码不能为空"),
    VERIFY_CODE_TYPE_ERROR(20021, "验证码类型不正确"),
    REALNAME_DOES_NOT_MATCH(20022, "身份证号码和姓名不一致，请重新输入"),
    VERIFY_FACEID_FAIL(20023, "本次人脸识别失败，请再次进行人脸识别"),
    CODE_NOT_FOUND(20024, "短信验证码已失效"),
    Valid_FACE_FAIL(20025, "填写的用户信息和注册流程中填写的信息不一致，请检查"),
    ACCOUNT_FAIL(20026, "帐号格式错误，请检查是否为手机号或身份证"),
    IDCARD_FAIL(20027, "身份证号码错误，请重新输入"),
    LOGIN_INFO_FAIL(20028, "帐号或密码错误"),
    USER_HAS_EXISTED2(20030, "该证件已注册，请直接登录"),
    TOKEN_NOT_VALID(20031, "token无效"),
    UUID_NOT_EXIST(20032, "UUID不存在"),
    SCAN_ERROR(20033, "扫码登录流程错误"),
    OAuth_LOGIN_FAIL(20034, "OAuth登录失败"),
    EXPIRED_ERROR(506,"用户密码已过期"),

    BUS_ERROR(30001, "{}业务出现问题"),
    BUS_FILE_UPLOAD(30002, "附件上传失败"),
    SYSTEM_INNER_ERROR(40001, "系统繁忙，请稍后重试"),
    RESULE_DATA_NONE(50001, "{}数据未找到"),
    DATA_IS_WRONG(50002, "{}数据有误"),
    DATA_ALREADY_EXISTED(50003, "{}数据已存在"),
    DATA_IS_UNIQUE(50004, "{}违反数据唯一性校验"),
    INTERFACE_INNER_INVOKE_ERROR(60001, "内部系统{}接口调用异常"),
    INTERFACE_OUTTER_INVOKE_ERROR(60002, "外部系统{}接口调用异常"),
    INTERFACE_FORBID_VISIT(60003, "该{}接口禁止访问"),
    INTERFACE_ADDRESS_INVALID(60004, "接口地址{}无效"),
    INTERFACE_REQUEST_TIMEOUT(60005, "{}接口请求超时"),
    INTERFACE_EXCEED_LOAD(60006, "{}接口负载过高"),
    PERMISSION_NO_ACCESS(70001, "{}无访问权限"),
    PERMISSION_NO_TOKEN(70002, "token无效"),
    PERMISSION_ERROR(70003, "访问认证的资源{}时，用户{}没有相关凭证：未登录、token失效"),
    PERMISSION_REFRESH(70004, "刷新token"),

    PARAMS_NOT_MAX(100001, "{}长度不能超过{}")
    ;

    private Integer code;
    private String message;

    private ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String message() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static String getMessage(String name) {
        ResultCode[] var1 = values();
        int var2 = var1.length;

        for (int var3 = 0; var3 < var2; ++var3) {
            ResultCode item = var1[var3];
            if (item.name().equals(name)) {
                return item.message;
            }
        }

        return name;
    }

    public static Integer getCode(String name) {
        ResultCode[] var1 = values();
        int var2 = var1.length;

        for (int var3 = 0; var3 < var2; ++var3) {
            ResultCode item = var1[var3];
            if (item.name().equals(name)) {
                return item.code;
            }
        }

        return null;
    }
}

package com.shzhong.mqorder.util;

public enum ResponseEnum {
    SUCCESS(200, "success"),
    SERVER_ERROR(500, "error"),
    BAD_PARAMS(401, "请先登录"),
    NO_AUTH(403, "没有权限"),
    ADMIN_INVALID_NAME(601),
    ADMIN_INVALID_PASSWORD(602),
    ADMIN_NAME_EXIST(602),
    ADMIN_ALTER_NOT_ALLOWED(603),
    ADMIN_DELETE_NOT_ALLOWED(604),
    ADMIN_INVALID_ACCOUNT(605),
    GOODS_UPDATE_NOT_ALLOWED(610),
    GOODS_NAME_EXIST(611),
    ORDER_CONFIRM_NOT_ALLOWED(620),
    ORDER_REFUND_FAILED(621),
    ORDER_REPLY_EXIST(622),
    USER_INVALID_NAME(630),
    USER_INVALID_PASSWORD(631),
    USER_INVALID_MOBILE(632),
    USER_NAME_EXIST(633),
    USER_MOBILE_EXIST(634);

    private String msg;
    private int code;

    private ResponseEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private ResponseEnum(int code) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

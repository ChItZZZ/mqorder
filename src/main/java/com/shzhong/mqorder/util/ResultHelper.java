package com.shzhong.mqorder.util;


import com.shzhong.mqorder.domain.ResponseEnum;

import java.util.HashMap;
import java.util.Map;

public class ResultHelper {

    public static Object ok() {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("error", 0);
        obj.put("msg", "成功");
        return obj;
    }

    public static Object ok(Object data) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("error", 0);
        obj.put("msg", "成功");
        obj.put("data", data);
        return obj;
    }

    public static Object fail(int error, String msg) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("error", error);
        obj.put("msg", msg);
        return obj;
    }

    public static Object fail(ResponseEnum responseEnum) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("error", responseEnum.getCode());
        obj.put("msg", responseEnum.getMsg());
        return obj;
    }


    public static Object badArgument() {
        return fail(401, "参数不对");
    }

    public static Object badArgumentValue() {
        return fail(402, "参数值不对");
    }

    public static Object unlogin() {
        return fail(501, "请登录");
    }

    public static Object serious() {
        return fail(502, "系统内部错误");
    }

    public static Object unsupport() {
        return fail(503, "业务不支持");
    }

    public static Object updatedDateExpired() {
        return fail(504, "更新数据已经失效");
    }

    public static Object updatedDataFailed() {
        return fail(505, "更新数据失败");
    }
}

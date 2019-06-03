package com.shzhong.mqorder.controller;

import com.shzhong.mqorder.util.ResponseEnum;
import com.shzhong.mqorder.service.UserService;
import com.shzhong.mqorder.util.JacksonUtil;
import com.shzhong.mqorder.util.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Component
@RequestMapping("/user")
@Api(value = "用户接口", tags = {"用户管理相关接口"})
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ResponseBody
    @ApiOperation(value = "通过账号密码查询用户进行登录", notes = "查询用户")
    @ApiResponse(code = 200, message = "success")
    public Object login(@RequestBody(required = false) String body) {

        String username = JacksonUtil.parseString(body, "username");
        String password = JacksonUtil.parseString(body, "password");

        if (userService.checkAuth(username, password)) {
            return R.ok();
        }
        return R.fail(ResponseEnum.NO_AUTH);
    }

    @GetMapping("/test")
    public Object test(@RequestBody String body) {
        return R.ok(body);
    }

    @RequestMapping("/session/set")
    public String set(HttpSession session) {
        String key = "test";

        System.out.println(new Date());
        session.setAttribute(key, new Date());
        return key;
    }

    @RequestMapping("/session/get")
    public String get(HttpSession session) {
        String value = (String) session.getAttribute("test").toString();
        return value;
    }

}

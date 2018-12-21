package com.shzhong.mqorder.controller;

import com.shzhong.mqorder.domain.ResponseEnum;
import com.shzhong.mqorder.service.UserService;
import com.shzhong.mqorder.util.JacksonUtil;
import com.shzhong.mqorder.util.ResultHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Component
@RequestMapping("/user")
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public Object login(@RequestBody(required = false) String body){

        String username = JacksonUtil.parseString(body,"username");
        String password = JacksonUtil.parseString(body,"password");

        if(userService.checkAuth(username, password)){
            return ResultHelper.ok();
        }
        return ResultHelper.fail(ResponseEnum.NO_AUTH);
    }

    @GetMapping("/test")
    public Object test(@RequestBody String body){
        return ResultHelper.ok(body);
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

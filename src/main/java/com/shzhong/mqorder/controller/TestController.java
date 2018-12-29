package com.shzhong.mqorder.controller;

import com.shzhong.mqorder.domain.DemoReq;
import com.shzhong.mqorder.util.ResultHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/test")
@Slf4j
@RestController
public class TestController {

    @GetMapping("/demo")
    public Object testDemo(String name, Integer age) {
        log.info(name);
        log.info(age.toString());
        return ResultHelper.ok();
    }

    @PostMapping("/demo1")
    public Object testDemo1(@RequestBody Map<String, Object> demoReq) {
        //application/json
        log.info(demoReq.get("name").toString());
        log.info(demoReq.get("age").toString());
        return ResultHelper.ok(demoReq);
    }

    @PostMapping("/demo2")
    public Object testDemo2(@RequestBody DemoReq demoReq) {
        //application/json
        System.out.println(demoReq);
        System.out.println(demoReq.getName());
        return ResultHelper.ok(demoReq);
    }


    @PostMapping("/demo3")
    public Object testDemo3(String name, Integer age) {
        //解析x-www-form-urlencoded
        log.info(name);
        log.info(age.toString());
        return ResultHelper.ok();
    }
}
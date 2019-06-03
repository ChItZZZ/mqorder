package com.shzhong.mqorder.controller;

import com.shzhong.mqorder.dto.DemoDTO;
import com.shzhong.mqorder.util.R;
import com.shzhong.mqorder.util.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RequestMapping("/test")
@Slf4j
@RestController
public class TestController {

    @GetMapping("/demo")
    public Object testDemo(Integer age) {
        // query string
        System.out.println("age = " + age);
        ApplicationContext context = SpringContextUtil.getApplicationContext();
        Object config = context.getBean("rabbitMqConfig");
        log.info("config,{}", config);
        return R.ok();
    }

    @PostMapping("/demo1")
    public Object testDemo1(@RequestBody Map<String, Object> demoReq) {
        //application/json
        log.info(demoReq.get("name").toString());
        log.info(demoReq.get("age").toString());
        return R.ok(demoReq);
    }

    @PostMapping("/demo2")
    public Object testDemo2(@RequestBody DemoDTO demoDTO) {
        //application/json
        System.out.println(demoDTO);
        System.out.println(demoDTO.getName());
        return R.ok(demoDTO);
    }


    @PostMapping("/demo3")
    public Object testDemo3(String name, Integer age) {
        //解析x-www-form-urlencoded
        log.info(name);
        log.info(age.toString());
        return R.ok();
    }


    @GetMapping("main")
    public Object demo4(HttpServletRequest request) {
        // get query string
        String name = request.getParameter("name");
        System.out.println(name);
        return R.ok();
    }

    @PostMapping("post")
    public Object demo5(HttpServletRequest request) {
        // 解析x-www-form-urlencoded
        String name = request.getParameter("name");
        System.out.println(name);
        return R.ok();
    }

}

package com.shzhong.mqorder;

import com.shzhong.mqorder.util.SpringContextUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@MapperScan({"com.shzhong.mqorder.mapper"}) // this is mapper java client location，and mapper xml in yml config
public class App {

    public static void main(String[] args) {
        ApplicationContext app = SpringApplication.run(App.class, args);
        SpringContextUtil.setApplicationContext(app);
    }
}

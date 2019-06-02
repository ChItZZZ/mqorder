package com.shzhong.mqorder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.shzhong.mqorder.mapper"}) // this is mapper java client location，and mapper xml in yml config
public class MqorderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MqorderApplication.class, args);
    }
}

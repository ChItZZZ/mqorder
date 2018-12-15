package com.shzhong.mqorder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.shzhong.mqorder"})
@MapperScan("com.shzhong.mqorder.mapper")
public class MqorderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MqorderApplication.class, args);
    }
}

package com.shzhong.mqorder.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Component;

@Component
@MapperScan({"com.shzhong.mqorder.mapper"}) // this is mapper java client location，and mapper xml in yml config
public class MybatisConfig {
}

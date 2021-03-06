package com.shzhong.mqorder.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class DemoDTO {
    @Max(value = 150, message = "超过最大数值")
    @Min(value = 18, message = "未成年禁止入内")
    public int age;

    public String name;

}

package com.shzhong.mqorder.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


@Data
public class OmsOrder {
    private Integer id;

    private String orderId;

    private Long uuid;

    private BigDecimal price;

    private Date createTime;

}
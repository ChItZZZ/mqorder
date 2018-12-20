package com.shzhong.mqorder.controller;

import com.shzhong.mqorder.domain.OmsOrder;
import com.shzhong.mqorder.service.OmsOrderService;
import com.shzhong.mqorder.util.ResultHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@RequestMapping("/order")
@RestController
@Slf4j
public class OmsOrderController {

    @Autowired
    private OmsOrderService omsOrderService;

    @GetMapping("list")
    public Object getOrder(@RequestParam(defaultValue = "1") Integer pageNum,
                           @RequestParam(defaultValue = "15") Integer pageSize,
                           @RequestParam(defaultValue = "create_time") String sort,
                           @RequestParam(defaultValue = "desc") String order) {


        List<OmsOrder> list = omsOrderService.selectByExample(pageNum, pageSize, sort, order);
        return ResultHelper.ok(list);

    }

    @PostMapping("add")
    public void addOrder(@RequestBody OmsOrder order) {
        OmsOrder omsOrder = new OmsOrder();
        int randomNum = new Random().nextInt(10000);
        omsOrder.setOrderId(String.valueOf(randomNum));
        omsOrder.setUuid((long) randomNum);
        omsOrder.setPrice(new BigDecimal(new Random().nextDouble() * 1000));
        omsOrderService.add(omsOrder);
    }

    @PostMapping("/cancel")
    @ResponseBody
    public Object cancelOrder(@RequestBody Long orderId) {
        omsOrderService.sendDelayMessageCancelOrder(orderId);
        return ResultHelper.ok();
    }
}
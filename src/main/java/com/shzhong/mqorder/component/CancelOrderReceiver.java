package com.shzhong.mqorder.component;

import com.shzhong.mqorder.service.OmsOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 取消订单消息的处理者
 * Created by zhongshaohan on 2018/12/12.
 */
@Component
@Slf4j
@RabbitListener(queues = "mall.order.cancel")
public class CancelOrderReceiver {
    @Autowired
    private OmsOrderService omsOrderService;

    @RabbitHandler
    public void handle(Integer id) {
        omsOrderService.deleteById(id);
        log.info("process orderId:{}", id);
    }


    public static void main(String[] args) {

        Callable<Integer> call = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return null;
            }
        };

        FutureTask<Integer> ft = new FutureTask<>(call);
        Thread thread = new Thread(ft);
        thread.start();
    }
}

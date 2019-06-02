package com.shzhong.mqorder.component;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class MessageServiceImpl {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMsg(String queueName, String msg) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("消息发送时间:" + sdf.format(new Date()));
        rabbitTemplate.convertAndSend("test_exchange", queueName, msg, message -> {
            message.getMessageProperties().setHeader("x-delay", 3000);
            return message;
        });
    }

    public static void main(String[] args) {
        ArrayBlockingQueue queue = new ArrayBlockingQueue<String>(2);

        queue.add("123123");
        queue.add("123123");

        ArrayList<Integer> list = new ArrayList<>();



    }
}

package com.shzhong.mqorder;

import com.shzhong.mqorder.component.MessageServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {

    @Autowired
    private MessageServiceImpl messageService;

    @Test
    public void send() throws InterruptedException {
        messageService.sendMsg("test_queue_1", "hello i am delay msg");
        while (true){
            Thread.sleep(10);
        }
    }

    class User{
        String name;
    }

    public void test(String name,User user){

    }

}

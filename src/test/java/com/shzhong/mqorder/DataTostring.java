package com.shzhong.mqorder;

import com.shzhong.mqorder.domain.OmsOrder;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class DataTostring {

    private Object testObj =new Object();
    public boolean isLocked = false;

    class innerChild {
        public static final String name = "123123";
        public Integer age;

    }


    public void doWait()  {
        synchronized (testObj){
            if(!isLocked){
                try {
                    testObj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
        //clear signal and continue running.
        isLocked = false;
    }

    public void doNotify() {
        synchronized (testObj){
            isLocked = true;
            testObj.notify();
        }
    }

    @Test
    public void name() {
        OmsOrder omsOrder = new OmsOrder();
        omsOrder.setOrderId("1231");
        System.out.println(omsOrder.toString());
    }

    @Test
    public void testmap() {
        Map<String, String> map = new HashMap<>();
        map.put("123", "ncz");
        map.put("test1231", "zzzzz");


        for (String s : map.keySet()) {
            System.out.println(1 + s + ":" + map.get(s));
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(2 + entry.getKey() + ":" + entry.getValue());
        }
    }

    @Test
    public void testThread(){
        new Thread(()->{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

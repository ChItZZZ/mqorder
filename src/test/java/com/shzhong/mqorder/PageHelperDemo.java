package com.shzhong.mqorder;

import com.github.pagehelper.PageHelper;
import com.shzhong.mqorder.mapper.OmsOrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
@Slf4j
public class PageHelperDemo {

    @Resource
    private OmsOrderMapper orderMapper;

    @Test
    public void test() {

        PageHelper.startPage(1, 10);
//        List<OmsOrder> list = jdbcTemplate.query("select * from oms_order", (rs, rowNum) -> {
//            OmsOrder omsOrder = new OmsOrder();
//            omsOrder.setOrderId(rs.getString("order_id"));
//            return omsOrder;
//        });
//        orderMapper.selectByExample(new osm);
//        log.info(String.valueOf(list.size()));
//        log.info(list.get(0).toString());
    }
}

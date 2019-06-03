package com.shzhong.mqorder.service;

import com.github.pagehelper.PageHelper;
import com.shzhong.mqorder.component.CancelOrderSender;
import com.shzhong.mqorder.entity.OmsOrder;
import com.shzhong.mqorder.entity.OmsOrderExample;
import com.shzhong.mqorder.mapper.OmsOrderMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class OmsOrderService {
    @Resource
    private OmsOrderMapper omsOrderMapper;

    @Autowired
    CancelOrderSender cancelOrderSender;

    public List<OmsOrder> selectByExample(Integer pageNum, Integer pageSize, String sort, String order) {
        OmsOrderExample omsOrderExample = new OmsOrderExample();
        OmsOrderExample.Criteria criteria = omsOrderExample.createCriteria();

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            omsOrderExample.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(pageNum, pageSize);

        return omsOrderMapper.selectByExample(omsOrderExample);
    }

    public void add(OmsOrder order) {
        omsOrderMapper.insertSelective(order);
    }

    public OmsOrder findById(Integer id) {
        return omsOrderMapper.selectByPrimaryKey(id);
    }

    public int updateById(OmsOrder order) {
        return omsOrderMapper.updateByPrimaryKeySelective(order);
    }

    public void deleteById(Integer id) {
        omsOrderMapper.deleteByPrimaryKey(id);
    }

    public void sendDelayMessageCancelOrder(Long orderId) {

        cancelOrderSender.sendMessage(orderId,1000);

    }
}

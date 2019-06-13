package com.fancyliu.springcloud.order.mapper;

import com.fancyliu.springcloud.order.OrderApplicationTests;
import com.fancyliu.springcloud.order.entity.Order;
import com.fancyliu.springcloud.order.enums.OrderStatusEnum;
import com.fancyliu.springcloud.order.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OrderMapperTest extends OrderApplicationTests {

    @Autowired
    private OrderMapper orderMapper;


    @Test
    public void testSave() {
        Order order = new Order();

        order.setOrderId("1111");
        order.setBuyerName("zhangsan");
        order.setBuyerPhone("18611111234");
        order.setBuyerAddress("xxx 街道");
        order.setBuyerOpenid("wx11111");
        order.setOrderAmount(new BigDecimal(100));
        order.setOrderStatus(OrderStatusEnum.NEW.getCode());
        order.setPayStatus(PayStatusEnum.WAIT.getCode());

        int insert = orderMapper.insert(order);

        Assert.assertTrue(insert != 0);

    }


}
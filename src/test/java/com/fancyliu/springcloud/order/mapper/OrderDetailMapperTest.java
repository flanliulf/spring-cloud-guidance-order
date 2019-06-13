package com.fancyliu.springcloud.order.mapper;

import com.fancyliu.springcloud.order.OrderApplicationTests;
import com.fancyliu.springcloud.order.entity.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OrderDetailMapperTest extends OrderApplicationTests {

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Test
    public void testSave() {

        OrderDetail detail = new OrderDetail();
        detail.setDetailId("1234");
        detail.setOrderId("1111");
        detail.setProductIcon("http://image.gyenno.com/123123123");
        detail.setProductId("157875196366160022");
        detail.setProductName("皮蛋粥");
        detail.setProductPrice(new BigDecimal(0.01));
        detail.setProductQuantity(2);

        int insert = orderDetailMapper.insert(detail);

        Assert.assertTrue(insert != 0);

    }

}
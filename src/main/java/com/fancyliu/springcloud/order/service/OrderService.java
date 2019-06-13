package com.fancyliu.springcloud.order.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fancyliu.springcloud.order.dto.OrderDTO;
import com.fancyliu.springcloud.order.entity.Order;
import com.fancyliu.springcloud.order.enums.OrderStatusEnum;
import com.fancyliu.springcloud.order.enums.PayStatusEnum;
import com.fancyliu.springcloud.order.mapper.OrderDetailMapper;
import com.fancyliu.springcloud.order.mapper.OrderMapper;
import com.fancyliu.springcloud.order.utils.KeyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderService extends ServiceImpl<OrderMapper, Order> {

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private OrderMapper orderMapper;

    public OrderDTO create(OrderDTO orderDTO) {

        // 1. 查询商品信息(调用商品服务)
        // 2. 计算总价
        // 3. 扣库存(调用商品服务)

        // 4. 订单入库
        Order order = new Order();

        orderDTO.setOrderId(KeyUtils.genUniqueKey());
        BeanUtils.copyProperties(orderDTO, order);
        order.setOrderAmount(new BigDecimal(100));
        order.setOrderStatus(OrderStatusEnum.NEW.getCode());
        order.setPayStatus(PayStatusEnum.WAIT.getCode());

        orderMapper.insert(order);

        return orderDTO;

    }

}

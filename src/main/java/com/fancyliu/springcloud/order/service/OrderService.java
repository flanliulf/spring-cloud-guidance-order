package com.fancyliu.springcloud.order.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fancyliu.springcloud.order.dto.OrderDTO;
import com.fancyliu.springcloud.order.entity.Order;
import com.fancyliu.springcloud.order.enums.OrderStatusEnum;
import com.fancyliu.springcloud.order.enums.PayStatusEnum;
import com.fancyliu.springcloud.order.mapper.OrderDetailMapper;
import com.fancyliu.springcloud.order.mapper.OrderMapper;
import com.fancyliu.springcloud.order.utils.KeyUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService extends ServiceImpl<OrderMapper, Order> {

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private OrderMapper orderMapper;

    public OrderDTO create(OrderDTO orderDTO) {

        // TODO 1. 查询商品信息(调用商品服务)
        // TODO 2. 计算总价
        // TODO 3. 扣库存(调用商品服务)

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

    public List<Order> queryPageList(String name, String phone, String pageSize, String pageNo, String sortBy, String order) {

        List<Order> orderList = null;

        // 构建查询条件封装
        QueryWrapper<Order> queryWrapper = new QueryWrapper<Order>();
        if (StringUtils.isNotEmpty(name)) {
            queryWrapper.eq("buyer_name", name);
        }
        if (StringUtils.isNotEmpty(phone)) {
            queryWrapper.eq("buyer_phone", phone);
        }
        queryWrapper.orderBy(false, "asc".equals(order) ? true : false, sortBy);

//        orderList = this.orderMapper.selectList(queryWrapper);

        // 构建分页封装
        Page<Order> orderPage = new Page<Order>(Integer.parseInt(pageNo), Integer.parseInt(pageSize));
//        queryWrapper.

        orderList = this.orderMapper.selectPage(orderPage, queryWrapper).getRecords();

        return orderList;
    }
}

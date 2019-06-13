package com.fancyliu.springcloud.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fancyliu.springcloud.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}

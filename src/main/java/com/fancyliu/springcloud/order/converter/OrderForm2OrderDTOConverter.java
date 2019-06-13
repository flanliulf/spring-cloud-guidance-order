package com.fancyliu.springcloud.order.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fancyliu.springcloud.order.dto.OrderDTO;
import com.fancyliu.springcloud.order.entity.OrderDetail;
import com.fancyliu.springcloud.order.enums.ResultEnum;
import com.fancyliu.springcloud.order.exception.OrderException;
import com.fancyliu.springcloud.order.form.OrderForm;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述:
 * 将表单对象转换为 DTO
 *
 * @author : Liu Fan
 * @date : 2019-06-11 13:27
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());

//            String content = JSON.toJSONString(orderForm.getItems());
//            List<OrderDetail> orderDetails = JSONObject.parseArray(content, OrderDetail.class);
            log.info("转换成功");
        } catch (Exception e) {
            log.error("【json转换】错误, string={}", orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}

package com.fancyliu.springcloud.order.controller;

import com.fancyliu.springcloud.order.converter.OrderForm2OrderDTOConverter;
import com.fancyliu.springcloud.order.dto.OrderDTO;
import com.fancyliu.springcloud.order.enums.ResultEnum;
import com.fancyliu.springcloud.order.form.OrderForm;
import com.fancyliu.springcloud.order.service.OrderService;
import com.fancyliu.springcloud.order.utils.ResponseDataUtils;
import com.fancyliu.springcloud.order.vo.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResponseData create(@Valid OrderForm orderForm,
                               BindingResult bindingResult) {
        // 参数校验
        if (bindingResult.hasErrors()) {
            log.error("----创建订单参数错误,orderForm={}", orderForm);
//            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),
//                    bindingResult.getFieldError().getDefaultMessage());

            return ResponseDataUtils.failure(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage(), orderForm);

        }

        // 将表单对象 转换成 DTO 对象
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);

        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("----创建订单商品明细为空");
//            throw new OrderException(ResultEnum.CART_EMPTY);
            return ResponseDataUtils.failure(500, ResultEnum.CART_EMPTY.getMessage(), orderForm);
        }

        orderDTO = orderService.create(orderDTO);

        return ResponseDataUtils.success(200, "订单创建成功", orderDTO);
    }

}

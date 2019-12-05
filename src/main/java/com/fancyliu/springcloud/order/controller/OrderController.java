package com.fancyliu.springcloud.order.controller;

import com.fancyliu.springcloud.order.converter.OrderForm2OrderDTOConverter;
import com.fancyliu.springcloud.order.dto.OrderDTO;
import com.fancyliu.springcloud.order.entity.Order;
import com.fancyliu.springcloud.order.enums.ResultEnum;
import com.fancyliu.springcloud.order.form.OrderForm;
import com.fancyliu.springcloud.order.service.OrderService;
import com.fancyliu.springcloud.order.utils.ResponseDataUtils;
import com.fancyliu.springcloud.order.vo.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 1. 参数校验
     * 2. 查询商品信息(调用商品服务)
     * 3. 计算总价
     * 4. 扣库存 (调用商品服务)
     * 5. 订单入库
     *
     * @param orderForm
     * @param bindingResult
     * @return
     */
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

    /**
     * 1. 参数校验
     * 2. 查询商品信息(调用商品服务)
     * 3. 计算总价
     * 4. 扣库存 (调用商品服务)
     * 5. 订单入库
     *
     * @param orderForm
     * @param bindingResult
     * @return
     */
    @PostMapping("/api/orders")
    public ResponseData add(@Valid OrderForm orderForm,
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

    @GetMapping("/api/orders/{id}")
    public ResponseData getById(@PathVariable("id") String orderId) {

        Order order = this.orderService.getById(orderId);

        ResponseData responseData = ResponseDataUtils.success(200, "查询成功", order);

        return responseData;
    }

    @GetMapping("/api/orders")
    public ResponseData query(String name,
                              String phone,
                              @RequestParam String pageSize,
                              @RequestParam String pageNo,
                              @RequestParam String sortBy,
                              @RequestParam String order) {

        ResponseData responseData = null;
        try {
            log.info("name={}", name);
            log.info("phone={}", phone);

            List<Order> orderList = this.orderService.queryPageList(name, phone, pageSize, pageNo, sortBy, order);

            responseData = ResponseDataUtils.success(200, "查询成功", orderList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseData;
    }


    @DeleteMapping("/api/orders/{id}")
    public ResponseData delelte(@PathVariable("id") String orderId) {

        boolean flag = this.orderService.removeById(orderId);

        ResponseData responseData = ResponseDataUtils.success(200, "删除成功", null);

        return responseData;
    }

}

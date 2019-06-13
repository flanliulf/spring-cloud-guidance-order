package com.fancyliu.springcloud.order.exception;

import com.fancyliu.springcloud.order.enums.ResultEnum;

/**
 * 类描述:
 * 订单统一异常封装类
 *
 * @author : Liu Fan
 * @date : 2019-06-11 13:53
 */
public class OrderException extends RuntimeException {

    private Integer code;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}

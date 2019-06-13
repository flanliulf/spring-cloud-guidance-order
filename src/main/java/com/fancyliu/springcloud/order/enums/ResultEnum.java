package com.fancyliu.springcloud.order.enums;

import lombok.Getter;

/**
 * 类描述:
 * 定义返回对象的一些常用信息枚举
 *
 * @author : Liu Fan
 * @date : 2019-06-11 13:28
 */
@Getter
public enum ResultEnum {
    PARAM_ERROR(1, "参数错误"),
    CART_EMPTY(2, "购物车为空");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

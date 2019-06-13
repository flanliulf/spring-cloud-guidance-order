package com.fancyliu.springcloud.order.enums;

import lombok.Getter;

/**
 * 类描述:
 * 订单状态枚举类
 *
 * @author : Liu Fan
 * @date : 2019-06-11 09:40
 */
@Getter
public enum OrderStatusEnum {
    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "取消"),
    ;
    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

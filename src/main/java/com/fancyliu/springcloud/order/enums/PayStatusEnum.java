package com.fancyliu.springcloud.order.enums;

import lombok.Getter;

/**
 * 类描述:
 * 支付状态枚举类
 *
 * @author : Liu Fan
 * @date : 2019-06-11 09:40
 */
@Getter
public enum PayStatusEnum {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;
    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

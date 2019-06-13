package com.fancyliu.springcloud.order.vo;

import lombok.Data;

@Data
public class ResponseData {
    private boolean success;
    private String msg;
    private Integer code;
    private Object data;

    public ResponseData() {
    }

    public ResponseData(boolean success, Integer code, String msg, Object data) {
        this.success = success;
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

}

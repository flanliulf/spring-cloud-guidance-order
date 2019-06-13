package com.fancyliu.springcloud.order.utils;

import com.fancyliu.springcloud.order.vo.ResponseData;

public class ResponseDataUtils {

    public static ResponseData success(Integer code, String msg, Object data) {
        return new ResponseData(true, code, msg, data);
    }

    public static ResponseData failure(Integer code, String msg, Object data) {
        return new ResponseData(false, code, msg, data);
    }
}

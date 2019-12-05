package com.fancyliu.springcloud.order.client;

import com.fancyliu.springcloud.order.entity.ProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 类描述:
 * 定义需要调用外部的哪些接口
 *
 * @author : Liu Fan
 * @date : 2019-06-14 12:29
 */
@FeignClient(name = "product")
public interface ProductClient {

    @GetMapping("/msg")
    String productMsg();

    @PostMapping("/product/list4Order")
    List<ProductInfo> list4Order(@RequestBody List<String> productIdList);
}
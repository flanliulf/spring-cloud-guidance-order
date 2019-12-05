package com.fancyliu.springcloud.order.controller;

import com.fancyliu.springcloud.order.client.ProductClient;
import com.fancyliu.springcloud.order.entity.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class ClientController {

    @Autowired
    private ProductClient productClient;

    /**
     * feign 方式,通过接口方法调用
     *
     * @return
     */
    @GetMapping("/getProductMsg")
    public String getProductMsg() {
        String result = productClient.productMsg();
        log.info("response={}", result);
        return result;
    }

    @GetMapping("/getProductList")
    public String getProductList() {
        List<ProductInfo> productInfos = productClient.
                list4Order(Arrays.asList("157875196366160022", "157875227953464068"));
        log.info("response={}", productInfos);
        return "success";
    }

}

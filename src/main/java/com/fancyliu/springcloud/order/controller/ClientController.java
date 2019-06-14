package com.fancyliu.springcloud.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class ClientController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

//    @Autowired
//    private RestTemplate restTemplate;

    /**
     * RestTemplate 第一种调用方式
     * 使用 restTemplate 写死的 url
     *
     * @return
     */
    @GetMapping("/getProductMsg1")
    public String getProductMsg1() {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://localhost:8081/msg", String.class);
        log.info("response={}", result);
        return result;
    }

    /**
     * RestTemplate 第二种调用方式
     * 利用 loadBalancerClient 通过应用名获取 url,然后使用 restTemplate
     *
     * @return
     */
    @GetMapping("/getProductMsg2")
    public String getProductMsg2() {
        ServiceInstance productService = loadBalancerClient.choose("PRODUCT");

        String url = String.format("http://%s:%s", productService.getHost(), productService.getPort()) + "/msg";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);

        log.info("response={}", result);
        return result;
//        return "";
    }

    /**
     * RestTemplate 第三种调用方式
     * 利用 LoadBalanced注解,在 restTemplate 中使用应用名称
     *
     * @return
     */
    @GetMapping("/getProductMsg3")
    public String getProductMsg3() {
//        String result = restTemplate.getForObject("http://PRODUCT/msg", String.class);
//        log.info("response={}", result);
//        return result;
        return "";
    }
}

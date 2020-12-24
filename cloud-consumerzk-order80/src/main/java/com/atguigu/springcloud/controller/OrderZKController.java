package com.atguigu.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderZKController {

    private final static String name = "http://cloud-payment-service";

    @Autowired
    public RestTemplate restTemplate;

    @GetMapping("consumer/payment/zk")
    public String payment(){
        String result = restTemplate.getForObject(name + "/payment/zk", String.class);
        return result;
    }
}

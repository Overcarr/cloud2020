package com.atguigu.springcloud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Value("${service-url.nacos-user-service}")
    private String defaultUrl;

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/consumer/payment/{id}")
    public String payment(@PathVariable("id")String id){
        return restTemplate.getForObject(defaultUrl+"/payment/" + id,String.class);

    }
}

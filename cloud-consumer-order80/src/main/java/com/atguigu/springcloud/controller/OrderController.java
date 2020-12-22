package com.atguigu.springcloud.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    private final static String url = "http://127.0.0.1:8001";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment>   create(Payment payment){
        return restTemplate.postForObject(url+"/payment/create",payment,CommonResult.class);  //写操作
    }

    @GetMapping("consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        CommonResult forObject = restTemplate.getForObject(url + "/payment/get/" + id, CommonResult.class);
        if (forObject!=null){  //说明有数据，能查询成功
            return new CommonResult(200,"查询成功",forObject);
        }else {
            return new CommonResult(444,"没有对应记录，查询ID："+id,null);
        }
    }
}

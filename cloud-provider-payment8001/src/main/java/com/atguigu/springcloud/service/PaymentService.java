package com.atguigu.springcloud.service;


import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    public int create(Payment payment){
        System.out.println(payment);
        return paymentDao.create(payment);

    }

    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }
}

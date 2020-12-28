package com.atguigu.springcloud.lb;


import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private Integer getIndex(){
        int current;
        int next;
        do{
            current = atomicInteger.get();
            next = current>=2147483647 ? 0 :current+1;
        }while (!atomicInteger.compareAndSet(current,next));
        System.out.println("第几次访问: "+next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getIndex() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}

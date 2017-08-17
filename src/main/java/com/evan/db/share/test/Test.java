package com.evan.db.share.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.druid.support.json.JSONUtils;
import com.evan.db.share.domain.Order;
import com.evan.db.share.service.OrderService;

public class Test {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(16);
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring/application-context.xml");
        final OrderService orderService = ac.getBean(OrderService.class);
        /*for(int idx=0;idx<100;idx++){
            final Order order = new Order();
            order.setProductCode(String.valueOf((char)(idx % 26 + 'A')));
            order.setOrderNo(String.valueOf(idx));
            es.execute(new Runnable() {
                
                public void run() {
                    orderService.save(order);
                }
            });
        }*/
        Order order = orderService.getByOrder("B", "79");
        System.out.println(order.getId());
        es.shutdown();
    }
}

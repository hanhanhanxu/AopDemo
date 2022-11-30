package com.example.aopdemo;

import com.example.aopdemo.pojo.SaveOrder;
import com.example.aopdemo.pojo.UpdateOrder;
import com.example.aopdemo.service.OrderService;
import com.example.aopdemo.service.Test1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopDemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AopDemoApplication.class, args);
    }

    @Autowired
    private OrderService orderService;

    @Autowired
    private Test1Service test1Service;

    @Override
    public void run(String... args) throws Exception {
        SaveOrder saveOrder = new SaveOrder(1L);
        orderService.saveOrder(saveOrder);

        UpdateOrder updateOrder = new UpdateOrder(2L);
        orderService.updateOrder(updateOrder);

        test1Service.print();
    }
}

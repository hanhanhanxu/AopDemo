package com.example.aopdemo.service;

import com.example.aopdemo.annotation.RecordOperate;
import com.example.aopdemo.pojo.SaveOrder;
import com.example.aopdemo.pojo.SaveOrderConvert;
import com.example.aopdemo.pojo.UpdateOrder;
import com.example.aopdemo.pojo.UpdateOrderConvert;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @RecordOperate(desc = "保存订单", convert = SaveOrderConvert.class)
    public Boolean saveOrder(SaveOrder saveOrder) {
        System.out.println("save order, orderId:" + saveOrder.getId());
        return true;
    }

    @RecordOperate(desc = "修改订单", convert = UpdateOrderConvert.class)
    public Boolean updateOrder(UpdateOrder updateOrder) {
        System.out.println("update order, orderId:" + updateOrder.getOrderId());
        return true;
    }
}

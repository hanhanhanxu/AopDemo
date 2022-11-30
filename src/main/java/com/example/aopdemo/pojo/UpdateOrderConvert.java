package com.example.aopdemo.pojo;

import com.example.aopdemo.entity.Convert;
import com.example.aopdemo.entity.OperateLogDO;

public class UpdateOrderConvert implements Convert<UpdateOrder> {
    @Override
    public OperateLogDO convert(UpdateOrder updateOrder) {
        OperateLogDO operateLogDO = new OperateLogDO();
        operateLogDO.setOrderId(updateOrder.getOrderId());
        return operateLogDO;
    }
}

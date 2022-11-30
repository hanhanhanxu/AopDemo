package com.example.aopdemo.pojo;

import com.example.aopdemo.entity.Convert;
import com.example.aopdemo.entity.OperateLogDO;

public class SaveOrderConvert implements Convert<SaveOrder> {
    @Override
    public OperateLogDO convert(SaveOrder saveOrder) {
        OperateLogDO operateLogDO = new OperateLogDO();
        operateLogDO.setOrderId(saveOrder.getId());
        return operateLogDO;
    }
}

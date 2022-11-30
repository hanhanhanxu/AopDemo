package com.example.aopdemo.entity;

public interface Convert<PARAM> {
    OperateLogDO convert(PARAM param);
}

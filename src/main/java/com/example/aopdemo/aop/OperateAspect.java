package com.example.aopdemo.aop;

import com.alibaba.fastjson2.JSON;
import com.example.aopdemo.annotation.RecordOperate;
import com.example.aopdemo.entity.Convert;
import com.example.aopdemo.entity.OperateLogDO;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class OperateAspect {
    /**
     * 定义切面步骤：
     * 1、定义切入点
     * 2、横切逻辑
     * 3、植入（Spring做）
     */
    @Pointcut("@annotation(com.example.aopdemo.annotation.RecordOperate)")
    public void pointcut() {}

    private ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            1, 1, 1, TimeUnit.SECONDS, new LinkedBlockingDeque<>(100)
    );

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // todo 这里可以在方法执行前，添加日志
        Object result = proceedingJoinPoint.proceed();
        threadPoolExecutor.execute(() -> {
            try {
                MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
                RecordOperate annotation = signature.getMethod().getAnnotation(RecordOperate.class);
                //通过注解，拿到类；再通过反射，构造对象
                Class<? extends Convert> convert = annotation.convert();
                Convert logConvert = convert.newInstance();
                OperateLogDO operateLogDO = logConvert.convert(proceedingJoinPoint.getArgs()[0]);

                operateLogDO.setDesc(annotation.desc());
                operateLogDO.setResult(result.toString());

                System.out.println("insert operateLog " + JSON.toJSONString(operateLogDO));
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        return result;
    }
}

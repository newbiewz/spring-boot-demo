package com.newbiewz.learn.monitor.interceptor;

import com.newbiewz.learn.monitor.annotation.SystemServiceLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class AnnotationInterceptor {
    private static Logger logger = LoggerFactory.getLogger("interceptor");

    @Value("${interceptor.enable:false}")
    public Boolean enable;

    @Pointcut("execution(* com.newbiewz.learn..*(..)) && @annotation(com.newbiewz.learn.monitor.annotation.SystemServiceLog)")
    public void controllerMethodPointcut(){}

    @Around("controllerMethodPointcut()") //指定拦截器规则；也可以直接把“execution(* com.xjj.........)”写进这里
    public Object Interceptor(ProceedingJoinPoint pjp) throws Throwable {
        if(!enable) {
            return pjp.proceed();
        }
        long beginTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod(); //获取被拦截的方法
        String methodName = method.getName(); //获取被拦截的方法名

        System.out.println(method.getAnnotation(SystemServiceLog.class).description());

        try {
            Object result = pjp.proceed();
            return result;
        } finally {
            logger.info("{}-{}-{}", method.getDeclaringClass(), pjp.getSignature().toString(), System.currentTimeMillis()-beginTime);
        }
    }
}

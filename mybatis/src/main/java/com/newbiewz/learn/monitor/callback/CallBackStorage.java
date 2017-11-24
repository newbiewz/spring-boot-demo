package com.newbiewz.learn.monitor.callback;

import com.newbiewz.learn.monitor.annotation.MyCallback;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

@Component
public class CallBackStorage implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    private Map<String, Object> callbackMap;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public Map<String, Object> getCallbackBeans() {
        if(callbackMap != null) {
            return callbackMap;
        }
        synchronized (this) {
            if(callbackMap == null) {
                callbackMap = applicationContext.getBeansWithAnnotation(MyCallback.class);
            }
        }
        return callbackMap;
    }

    public Object invoke(Method method, Object obj, Object[] args) {
        try {
            method.invoke(obj, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
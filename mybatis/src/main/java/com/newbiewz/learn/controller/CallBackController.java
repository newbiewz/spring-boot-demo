package com.newbiewz.learn.controller;

import com.newbiewz.learn.monitor.annotation.MyCallback;
import com.newbiewz.learn.monitor.callback.CallBackStorage;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController

@RequestMapping("/callback")
public class CallBackController{

    @Resource
    private CallBackStorage callBackStorage;

    @RequestMapping(value = "/")
    public void index() {
        callBackStorage.getCallbackBeans();
    }

}

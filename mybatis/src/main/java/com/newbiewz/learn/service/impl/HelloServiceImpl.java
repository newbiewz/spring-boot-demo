package com.newbiewz.learn.service.impl;

import com.newbiewz.learn.monitor.annotation.MyCallback;
import com.newbiewz.learn.monitor.annotation.SystemServiceLog;
import com.newbiewz.learn.service.HelloService;
import org.springframework.stereotype.Service;

@Service
@MyCallback
public class HelloServiceImpl implements HelloService{
    @MyCallback
    @SystemServiceLog(description = "abc")
    @Override
    public void sayHello(String name) {
        System.out.println(name + " say HELLO");
    }
}

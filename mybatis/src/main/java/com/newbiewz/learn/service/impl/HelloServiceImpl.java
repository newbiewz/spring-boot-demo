package com.newbiewz.learn.service.impl;

import com.newbiewz.learn.SystemServiceLog;
import com.newbiewz.learn.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService{
    @SystemServiceLog
    @Override
    public void sayHello(String name) {
        System.out.println(name + " say HELLO");
    }
}

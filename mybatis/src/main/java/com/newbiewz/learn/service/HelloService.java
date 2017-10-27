package com.newbiewz.learn.service;

import com.newbiewz.learn.SystemServiceLog;

public interface HelloService {
    @SystemServiceLog
    void sayHello(String name);
}

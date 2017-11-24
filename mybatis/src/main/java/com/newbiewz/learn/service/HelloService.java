package com.newbiewz.learn.service;

import com.newbiewz.learn.monitor.annotation.SystemServiceLog;

public interface HelloService {
    @SystemServiceLog
    void sayHello(String name);
}

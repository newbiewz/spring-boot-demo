package com.newbiewz.learn.controller;

import com.newbiewz.learn.monitor.annotation.SystemServiceLog;
import com.newbiewz.learn.service.HelloService;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Resource
    private HelloService helloService;

    @RequestMapping(value = "/{id}")
    @SystemServiceLog
    public String info(@PathVariable Long id, @RequestParam String name, @RequestParam MultiValueMap map) {
        if(id == null) {
            throw new NullPointerException("id is null");
        }
        helloService.sayHello(name);
        return map.toString();
    }
}

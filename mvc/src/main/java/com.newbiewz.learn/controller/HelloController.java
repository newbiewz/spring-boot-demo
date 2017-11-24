package com.newbiewz.learn.controller;

import com.google.common.collect.Lists;
import com.newbiewz.learn.model.Student;
import com.newbiewz.learn.util.GsonUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController {

    public static void main(String args[]) {
        long time = System.currentTimeMillis();
        System.out.println((time + 8 * 60 * 60 * 1000) % (24 * 60 * 60 * 1000) / 60000);

        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm").format(LocalDateTime.ofInstant(Instant.ofEpochMilli(time), ZoneId.systemDefault())));
    }

    @RequestMapping("/")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("name", "wz");
        map.addAttribute("bookTitle", "java");
        // return模板文件的名称，对应src/main/resources/templates/welcome.html
        return "welcome";
    }

    @RequestMapping("/stat")
    public String stat(ModelMap map) {
        Student s1 = new Student();
        s1.setName("wz1");
        s1.setAge(10);

        Student s2 = new Student();
        s2.setName("wz2");
        s2.setAge(20);

        List stats = Lists.newArrayList(s1, s2);
        System.out.println(GsonUtil.toJson(stats));
        // 加入一个属性，用来在模板中读取
        map.addAttribute("name", "wz");
        map.addAttribute("bookTitle", "java");
        map.addAttribute("studentList", stats);
        map.addAttribute("student", s2);
        // return模板文件的名称，对应src/main/resources/templates/welcome.html
        return "stat/stats";
    }

}

package com.newbiewz.learn.util.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.newbiewz.learn.util.GsonUtil;
import org.springframework.web.servlet.HandlerMapping;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String args[]) throws Exception {
        System.out.println(HandlerMapping.class.getName());
    }

    private static void test2() throws Exception {
        Demo1 demo1 = new Demo1();
        demo1.setName("WZ");
        Map map = new HashMap();
        map.put("attr1", "a1");
        map.put("attr2", 2);
        demo1.setProperties(map);

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        mapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
        String content = mapper.writeValueAsString(demo1);
        System.out.println(content);

        Demo1 demo2 = mapper.readValue(content, Demo1.class);
        System.out.println(GsonUtil.toJson(demo2));
    }

    private static void test1() throws Exception {
        Person person = new Person();
        person.setName("WZ");
        person.setDirthday(new Date());
        person.setGender(Gender.MAN);

        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(person);
        System.out.println(content);

        Person person2 = mapper.readValue(content, Person.class);
        System.out.println(GsonUtil.toJson(person2));
        System.out.println(mapper.writeValueAsString(person2));
    }
}

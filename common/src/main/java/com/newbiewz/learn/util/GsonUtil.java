package com.newbiewz.learn.util;

import com.google.gson.Gson;

public class GsonUtil {
    private static final Gson gson = new Gson();

    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    public <T> T fromJson(String str, Class<T> clazz) {
        return gson.fromJson(str, clazz);
    }
}

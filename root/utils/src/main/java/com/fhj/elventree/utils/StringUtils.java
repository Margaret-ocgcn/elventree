package com.fhj.elventree.utils;

import com.google.gson.Gson;

import java.util.UUID;

public class StringUtils {
    private static final Gson gson = new Gson();

    public final static String getTaskId() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String bean2Json(Object obj) {
        return gson.toJson(obj);
    }

    public static <T> T json2Bean(String json,Class<T> clazz){
        return gson.fromJson(json,clazz);
    }

    public static void main(String[] args) {
        System.out.println(StringUtils.getTaskId().length());
    }

}

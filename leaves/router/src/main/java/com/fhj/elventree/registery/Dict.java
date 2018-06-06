package com.fhj.elventree.registery;

import java.util.HashMap;
import java.util.Map;

public class Dict {
    private static final Map<String, String> map = new HashMap<String, String>();

    public Dict() {
    }

    public void init() {
        map.put("test", "test");
    }

    public void destory() {
        map.clear();
    }

    public String getValue(String key) {
        return map.get(key);
    }
}

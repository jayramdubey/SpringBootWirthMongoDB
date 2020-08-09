package com.cts.personservice.config;


import java.util.HashMap;
import java.util.Map;

import static org.springframework.util.CollectionUtils.isEmpty;


public class ServletRequestContext {

    private static final ThreadLocal<Map<String, Object>> attributes = new ThreadLocal<>();

    public static void set(String key, Object value) {
        if (isEmpty(attributes.get())) {
            attributes.set(new HashMap<>());
        }
        attributes.get().put(key, value);
    }

    public static Object get(String key) {
        if (!isEmpty(attributes.get())) {
            return attributes.get().get(key);
        }
        return null;
    }

    public static void clear() {
        attributes.remove();
    }

}

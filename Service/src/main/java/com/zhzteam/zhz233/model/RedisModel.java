package com.zhzteam.zhz233.model;

import java.io.Serializable;

public class RedisModel implements Serializable {
    /**
     * Key
     */
    private String Key;
    /**
     * Value
     */
    private String Value;

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }
}

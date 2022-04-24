package com.hujtb.test;

public enum Status {

    ADMINISTRATOR("管理员", 100);

    private final String name;

    private final Integer code;

    Status(String name, Integer code) {
        this.name = name ;
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public Integer getCode() {
        return this.code;
    }
}

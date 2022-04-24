package com.hujtb.test;

import java.io.Serializable;

public class Major implements Serializable {
    private static final long serializeUID = 1L;

    private String name;

   public Major(String name) {
       this.name = name;
   }

   public String getName() {
       return this.name;
   }

   public void setName(String name) {
       this.name = name;
    }

    @Override
    public String toString() {
        return "Major{" +
                "name='" + name + '\'' +
                '}';
    }
}

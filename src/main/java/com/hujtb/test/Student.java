package com.hujtb.test;

import com.hujtb.test.anno.Length;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Objects;

public class Student implements Serializable {

    private static final long serializeUId = 1L;

    private String name;
    @Length(min = 10, max = 100, errMessage = "年龄应当在0-100之间")
    private int age;
    private Major major;

    public Student() {
    }

    public static String validate(Object object) throws IllegalAccessException {
        Field[] declaredFields = object.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(Length.class)) {
                Length length = field.getAnnotation(Length.class);
                field.setAccessible(true);
                int value = ((String) field.get(object)).length();
                if (value < length.min() || value > length.max()) {
                    return length.errMessage();
                }
            }
        }
        return null;
    }

    public Student(String name, int age, Major major) {
        this.name = name;
        this.age = age;
        this.major = major;
    }

    public Student clone() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(this);
            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            return (Student) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", major=" + major +
                '}';
    }
}

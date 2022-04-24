package com.hujtb.algorithms.search;

public class Student implements Comparable<Student> {

    private String name;
    private int score;

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public boolean equals(Object student) {

        if (this == student) {
            return true;
        }

        if (student == null) {
            return false;
        }

        if (this.getClass() != student.getClass()) {
            return false;
        }

        Student another = (Student) student;
        return this.name.toLowerCase().equals(another.name);
    }

    @Override
    public int compareTo(Student o) {

        // 返回负值，代表当前类对象要排在传入类对象前面；返回正值，代表当前类对象要排在传入对象后面
        if (this.score < o.score) {
            return -1;
        } else if (this.score > o.score) {
            return 1;
        } else {
            return 0;
        }
        // return this.score - o.score;
    }

    @Override
    public String toString() {

        return String.format("Student(name: %s, score: %d)", name, score);
    }
}

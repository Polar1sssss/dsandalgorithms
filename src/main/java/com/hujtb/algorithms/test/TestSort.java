package com.hujtb.algorithms.test;

import com.hujtb.algorithms.search.Student;
import com.hujtb.algorithms.sort.*;

public class TestSort {
    public static void main(String[] args) {

//        Integer[] a = {53, 3, 542, 748, 14, 214, 154, 63, 616};
//        SelectionSort.selectionSort1(a);

        Student s1 = new Student("zhangsan", 31);
        Student s2 = new Student("lisi", 30);
        Student s3 = new Student("lisi", 33);
        Student s4 = new Student("lisi", 40);
        Student s5 = new Student("lisi", 80);
        Student s6 = new Student("lisi", 100);

        Student[] students = {s1, s2, s3, s4, s5, s6};
        InsertionSort.insertionSort1(students);

        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
    }
}

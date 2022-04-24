package com.hujtb.algorithms.search;

/**
 * 线性查找
 */
public class LinerSearch {

    private LinerSearch() {
    }

    public static <T> int search(T[] arr, T target) {

        for (int i = 0; i < arr.length; i++) {
            // 对象比较，应该用equals
            if (arr[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Integer[] arr = {1, 2222, 33333, 44444, 5555};
        Integer i = LinerSearch.search(arr, 5555);
        System.out.println(i);

        Student[] students = {
                new Student("zhangsan"),
                new Student("lisi"),
                new Student("wangwu")
        };
        Student zhangsan = new Student("zhangsan");
        int search = LinerSearch.search(students, zhangsan);
        System.out.println(search);
    }
}

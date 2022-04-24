package com.hujtb.algorithms.sort;

/**
 * 插入排序
 * 数列分成有序区和无序区
 * （1）取出无序区中第一个数，并找到在有序区对应的位置
 * （2）将无序区中的数据插入到有序区，若有必要的话，则对有序区中的数据进行移位
 */
public class InsertionSort {

    private InsertionSort() {
    }

    public static <E extends Comparable<E>> void insertionSort1(E[] a) {

        for (int i = 0; i < a.length; i++) {
            for (int j = i; j - 1 >= 0 && a[j].compareTo(a[j - 1]) < 0; j--) {
                swap(a, j, j - 1);
            }
        }
    }

    /**
     * 平移
     * @param a
     * @param <E>
     */
    public static <E extends Comparable<E>> void sort2(E[] a) {

        for (int i = 0; i < a.length; i++) {

            E t = a[i];
            int j;
            for (j = i; j - 1 >= 0 && t.compareTo(a[j - 1]) > 0; j--) {
                a[j] = a[j - 1];
            }
            a[j] = t;
        }
    }

    public static <E> void swap(E[] a, int i, int j) {

        E tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}

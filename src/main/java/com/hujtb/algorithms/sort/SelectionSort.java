package com.hujtb.algorithms.sort;

/**
 * 选择排序
 * 每一次循环选择一个最小的数，与数组中最前面未交换过的数字交换
 */
public class SelectionSort {

    private SelectionSort() {
    }

    public static <E extends Comparable<E>> void selectionSort1(E[] a) {

        int i, j, min;
        for (i = 0; i < a.length; i++) {
            min = i;

            for (j = i + 1; j < a.length; j++) {
                // 如果a[min]大于a[j]，证明j位置的数为最小值
                if (a[min].compareTo(a[j]) > 0) {
                    min = j;
                }
            }
            // 最开始定义min和i相等，不相等就说明此时找到比min位置小的数，min被重新赋值
            // 将最小位置的数与初始i位置的数交换
            if (min != i) {
                swap(a, i, min);
            }
        }
    }

    private static <E> void swap(E[] a, int i, int min) {

        E tmp = a[i];
        a[i] = a[min];
        a[min] = tmp;
    }
}

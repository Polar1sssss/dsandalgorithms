package com.hujtb.algorithms.sort;

/**
 * 归并排序
 */
public class MergeSort {

    // TODO xxx
    public static void mergeSort1() {

    }

    /**
     * 将数组拆解
     */
    public static void mergeUp2Down(int[] a, int start, int end) {
        if (a == null || start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeUp2Down(a, start, mid);
        mergeUp2Down(a, mid + 1, end);

        merge(a, start, mid, end);
    }

    private static void merge(int[] a, int start, int mid, int end) {

    }
}

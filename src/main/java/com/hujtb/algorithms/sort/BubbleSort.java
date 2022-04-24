package com.hujtb.algorithms.sort;

public class BubbleSort {

    public static void bubbleSort1(int[] a) {
        // 是否交换标记
        int flag;
        for (int i = a.length - 1; i > 0; i--) {
            flag = 0;
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = 1;
                }
            }
            if (flag == 0) {
                break;
            }
        }
    }
}

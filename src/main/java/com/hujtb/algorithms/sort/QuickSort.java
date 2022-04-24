package com.hujtb.algorithms.sort;

/**
 * 快速排序
 * 选择一个基准数，通过一趟排序将要排序的数分成两部分，其中一部分所有数据比另一部分所有数据都要小。
 * 然后在通过快速排序对两部分数据进行排序
 */
public class QuickSort {

    public static void quickSort1(int[] a, int l, int r) {
        if (l < r) {
            int i = l;
            int j = r;
            // 选定基准数
            int x = a[i];
            while (i < j) {
                // 从右往左找第一个小于x的数
                while (i < j && a[j] > x) {
                    j--;
                }
                if (i < j) {
                    a[i++] = a[j];
                }
                // 从左往右找到第一个大于x的数
                while (i < j && a[i] < x) {
                    i++;
                }
                if (i < j) {
                    a[j--] = a[i];
                }
                a[i] = x;
                quickSort1(a, l, i - 1);
                quickSort1(a, i + 1, r);
            }
        }
    }
}

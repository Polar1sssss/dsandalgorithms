package com.hujtb.algorithms.sort;

/**
 * 桶排序(桶的下标 == 数组中的值)
 * 假设待排序的数组a中共有N个整数，并且已知数组a中数据的范围[0, MAX)。
 * 在桶排序时，创建容量为MAX的桶数组r，并将桶数组元素都初始化为0；将容量为MAX的桶数组中的每一个单元都看作一个"桶"。
 * 在排序时，逐个遍历数组a，将数组a的值，作为"桶数组r"的下标。当a中数据被读取时，就将桶的值加1。
 * 例如，读取到数组a[3]=5，则将r[5]的值+1。
 */
public class BucketSort {

    // 先遍历数组，放到桶里，也就自动排好序，在遍历桶里不为0的位置，放回到数组
    public static void bucketSort1(int[] a) {
        if (a == null) return;

        // 桶的最大长度
        int max = 10;
        int[] bucket = new int[max];

        // 根据a数组中各个值，对桶中对应的位置进行计数
        for (int i = 0; i < a.length; i++) {
            bucket[a[i]]++;
        }

        // 排序
        for (int x = 0, y = 0; x < max; x++) {
            while ((bucket[x]--) > 0) {
                a[y++] = x;
            }
        }
        bucket = null;
    }
}

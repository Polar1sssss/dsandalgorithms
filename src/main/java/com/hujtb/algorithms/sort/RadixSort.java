package com.hujtb.algorithms.sort;

/**
 * 将有待比较的数值统一成同样长度，数位较短的数前面补0。从最低位开始，依次进行一次排序。
 * 这样从最低位排序依次到最高位排序完成后，数列就是一个有序序列。
 */
public class RadixSort {

    public static int getMax(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    /**
     *
     * @param a 数组
     * @param exp 指数，个位 - 1， 十位 - 10， 百位 - 100
     */
    public static void courtSort(int[] a, int exp) {
        int[] output = new int[a.length]; // 创建一个和a等长的数组作为临时数组
        int[] bucket = new int[10];

        for (int i = 0; i < a.length; i++) {
            bucket[ (a[i] / exp) % 10 ]++;
        }

        for (int i = 1; i < bucket.length; i++) {
            bucket[i] += bucket[i - 1];
        }

        // 将数据存储到临时数组output中
        for (int i = a.length - 1; i >= 0; i--) {
            output[ bucket[ (a[i] / exp) % 10 ] - 1 ] = a[i];
            bucket[ (a[i] / exp) % 10 ]--;
        }

        for (int i = 0; i < output.length; i++) {
            a[i] = output[i];
        }

        output = null;
        bucket = null;
    }

    public static void radixSort1(int[] a) {
        int max = getMax(a);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            courtSort(a, exp);
        }
    }
}

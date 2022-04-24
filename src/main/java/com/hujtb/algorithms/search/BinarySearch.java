package com.hujtb.algorithms.search;

import java.util.Arrays;

/**
 * 二分查找，在数组中找到目标数字
 */
public class BinarySearch {

    public static int binarySearch(int[] a, int key) {
        Arrays.sort(a);
        int low = 0;
        int high = a.length - 1;

        if (key < a[low] || key > a[high]) return -1;

        while (low <= high) {
            int mid = low + high / 2;
            if (a[mid] < key) {
                low = mid + 1;
            } else if (a[mid] > key) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // 递归二分查找
    public static int binarySearch1(int[] a, int key, int fromIndex, int toIndex) {
        if (key < a[fromIndex] || key > a[toIndex] || fromIndex > toIndex)
            return -1;
        int mid = fromIndex + toIndex / 2;
        if (a[mid] < key) {
            return binarySearch1(a, key, mid + 1, toIndex);
        } else if (a[mid] > key) {
            return binarySearch1(a, key, fromIndex, mid - 1);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 9};
        System.out.println(binarySearch(a, 4));
    }
}

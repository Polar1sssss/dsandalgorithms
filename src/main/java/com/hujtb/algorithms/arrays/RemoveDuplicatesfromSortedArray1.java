package com.hujtb.algorithms.arrays;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 删除有序数组中的重复项
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 */
public class RemoveDuplicatesfromSortedArray1 {

    public static int solution(int[] array) {
        int count = 0;
        int length = array.length;
        for (int i = 1; i < length; ++i) {
            if (array[i] == array[i - 1]) {
                ++count;
            } else {
                array[i - count] = array[i];
            }
        }
        return length - count;
    }

    public static void main(String[] args) {

        int[] array = {1, 1, 2, 2, 3, 4, 5, 5, 5};
        int solution = solution(array);

    }

}

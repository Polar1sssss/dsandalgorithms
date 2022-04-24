package com.hujtb.algorithms.arrays;

/**
 *
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class RemoveDuplicatesfromSortedArray2 {

    public int solution(int[] array) {
        int count = 0;
        int cur = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]) {
                ++count;
            } else {
                count = 0;
            }
            if (count < 2) {
                array[cur++] = array[i];
            }
        }
        return cur;
    }
}

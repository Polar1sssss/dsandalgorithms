package com.hujtb.algorithms.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 在一个1~n的数组中查找重复的数字
 */
public class FindDuplicate {

    /**
     * 使用HashMap
     * @param nums
     * @return
     */
    public static int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (Integer num : nums) {
            if (countMap.containsKey(num)) {
                return num;
            }
            countMap.put(num, 1);
        }
        return -1;
    }

    /**
     * 使用HashSet
     * @param nums
     * @return
     */
    public static int findDuplicate1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (Integer ele : set) {
            if (set.contains(ele)) {
                return ele;
            } else {
                set.add(ele);
            }
        }
        return -1;
    }

    /**
     * 先排序再找相邻元素
     * @param nums
     * @return
     */
    public static int findDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 快慢指针
     * @param nums
     * @return
     */
    public static int findDuplicate3(int[] nums) {
        int slow = 0, fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);

        // 循环结束，slow和fast相等，就是相遇点
        // 寻找环的入口点
        int before = 0, after = slow;
        while (before != after) {
            before = nums[before];
            after = nums[after];
        }
        return before;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4, 5};
        System.out.println(findDuplicate(nums));
    }
}


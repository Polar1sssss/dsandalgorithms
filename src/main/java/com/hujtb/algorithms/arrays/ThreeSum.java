package com.hujtb.algorithms.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 从数组中找到三数之和为0的组合
 */
public class ThreeSum {

    public static List<List<Integer>> solution(int[] nums) {

        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            // 1.1 选定一个数作为基准数，如果基准数大于0，直接跳出循环
            if (nums[i] > 0) break;

            // 1.2 如果基准数已经出现过，进入下一次循环
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // 1.3 定义左右指针
            int lp = i + 1;
            int rp = n - 1;

            while (lp < rp) {
                int sum = nums[i] + nums[lp] + nums[rp];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[lp], nums[rp]));
                    lp++;
                    rp--;
                    // 如果指针移动之后的数字和移动之前相同，那么再进行一次移动
                    while (lp < rp && nums[lp] == nums[lp - 1]) lp++;
                    while (lp < rp && nums[rp] == nums[rp + 1]) rp--;
                } else if (sum < 0) {
                    // 和小于0，需要给左边的数增大一点（右边的数已经是最大了，所以只能改变左边的数）
                    lp++;
                } else {
                    // 和大于0，需要给右边的数减小一点
                    rp--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2, -1, -1, 0, 1, 4};
        List<List<Integer>> list = solution(nums);
        System.out.println(list);
    }
}

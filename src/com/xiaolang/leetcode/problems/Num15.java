package com.xiaolang.leetcode.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 题号：15 号题
 * 国内站：https://leetcode-cn.com/problems/3sum/
 * 国际站高票讨论区：https://leetcode.com/problems/3sum/discuss/?currentPage=1&orderBy=most_votes&query=&tag=java
 *
 * 题目描述：三数之和
 *   给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 *   请你找出所有满足条件且不重复的三元组。
 *   注意：答案中不可以包含重复的三元组。
 *
 * 示例：
 *   给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *   满足要求的三元组集合为：
 *   [
 *     [-1, 0, 1],
 *     [-1, -1, 2]
 *   ]
 */
public class Num15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) {
                            lo++;
                        }
                        while (lo < hi && nums[hi] == nums[hi - 1]) {
                            hi--;
                        }
                        lo++;
                        hi--;
                    } else if (nums[lo] + nums[hi] < sum) {
                        lo++;
                    } else {
                        hi--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Num15 threeSum = new Num15();

        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};

        threeSum.threeSum(nums).forEach(System.out::println);
    }

}

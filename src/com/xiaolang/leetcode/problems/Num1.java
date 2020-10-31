package com.xiaolang.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 题号：1 号题
 * 国内站：https://leetcode-cn.com/problems/two-sum/
 * 国际站高票讨论区：https://leetcode.com/problems/two-sum/discuss/?currentPage=1&orderBy=most_votes&query=&tag=java
 * 算法思路：https://leetcode-cn.com/problems/two-sum/solution/jie-suan-fa-1-liang-shu-zhi-he-by-guanpengchn/
 *
 * 题目描述：两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Num1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; map.put(nums[i], i++)) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        Num1 sum = new Num1();
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = sum.twoSum(nums, target);
        if (result.length == 2) {
            System.out.printf("[%d, %d]\n", result[0], result[1]);
        }
    }

}
package com.xiaolang.leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 题号：347 号题
 * 国内站：https://leetcode-cn.com/problems/top-k-frequent-elements/
 * 国际站高票讨论区：https://leetcode.com/problems/top-k-frequent-elements/discuss/?currentPage=1&orderBy=most_votes&query=&tag=java
 *
 * 题目描述：前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 *   示例 1:
 *     输入: nums = [1,1,1,2,2,3], k = 2
 *     输出: [1,2]
 *
 *   示例 2:
 *     输入: nums = [1], k = 1
 *     输出: [1]
 *
 *   提示：
 *     你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 *     你的算法的时间复杂度必须优于 O(NLogN), n 是数组的大小。
 *     题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 *     你可以按任意顺序返回答案。
 */
public class Num347 {

    public int[] topKFrequent(int[] nums, int k) {
        // O(1) time
        if (nums.length == k) {
            return nums;
        }

        // 1. build hash map: character and how often it appears
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 2. build maxHeap based on the frequency of each element
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(entry);
        }

        // 3. build an output array
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = maxHeap.poll().getKey();
        }
        return res;
    }

    public static void main(String[] args) {
        Num347 topK = new Num347();

        int[] nums = new int[]{1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 5};

        int[] results = topK.topKFrequent(nums, 3);
        Arrays.stream(results).boxed().collect(Collectors.toList()).forEach(System.out::println);
    }

}

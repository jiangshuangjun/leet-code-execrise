package com.xiaolang.leetcode.problems;

/**
 * 题号：11 号题
 * 国内站：https://leetcode-cn.com/problems/container-with-most-water/
 * 国际站高票讨论区：https://leetcode.com/problems/container-with-most-water/discuss/?currentPage=1&orderBy=most_votes&query=&tag=java
 *
 * 题目描述：盛最多水的容器
 *   给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i, ai) 。
 *   在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为(i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 示例：
 *   输入：[1,8,6,2,5,4,8,3,7]
 *   输出：49
 */
public class Num11 {

    public int maxArea(int[] height) {
        int max = 0;
        for (int i =0, j = height.length - 1; i < j; ) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            max = Math.max(max, (j - i + 1) * minHeight);
        }
        return max;
    }

    public static void main(String[] args) {
        Num11 maxWater = new Num11();

        int[] height = new int[]{1,8,6,2,5,4,8,3,7};

        System.out.println(maxWater.maxArea(height));
    }

}

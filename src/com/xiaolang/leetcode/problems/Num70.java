package com.xiaolang.leetcode.problems;

/**
 * 题号：70 号题
 * 国内站：https://leetcode-cn.com/problems/climbing-stairs/
 * 国际站高票讨论区：https://leetcode.com/problems/climbing-stairs/discuss/?currentPage=1&orderBy=most_votes&query=&tag=java
 *
 * 题目描述：爬楼梯
 *   假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *   每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *   注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *   输入： 2
 *   输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 *   1.  1 阶 + 1 阶
 *   2.  2 阶
 *
 * 示例 2：
 *   输入： 3
 *   输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 *   1.  1 阶 + 1 阶 + 1 阶
 *   2.  1 阶 + 2 阶
 *   3.  2 阶 + 1 阶
 */
public class Num70 {

    public int climbStairs1(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i == 1 || i == 2) {
                dp[i] = i;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }

    public int climbStairs2(int n) {
        int[] mem = new int[n + 1];
        return climbStairs2(mem, n);
    }

    public int climbStairs2(int[] mem, int n) {
        if (mem[n] > 0) {
            return mem[n];
        }

        if (n == 1 || n == 2) {
            mem[n] = n;
        } else {
            mem[n] = climbStairs2(mem, n - 1) + climbStairs2(mem, n - 2);
        }

        return mem[n];
    }

    public static void main(String[] args) {
        Num70 climbStairs = new Num70();

        int n = 5;

        System.out.printf("动态规划爬 %d 阶楼梯方法：%d\n", n, climbStairs.climbStairs1(5));
        System.out.printf("递归记忆化搜索爬 %d 阶楼梯方法：%d\n", n, climbStairs.climbStairs2(5));
    }

}

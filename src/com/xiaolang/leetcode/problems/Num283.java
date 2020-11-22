package com.xiaolang.leetcode.problems;

/**
 * 题号：283 号题
 * 国内站：https://leetcode-cn.com/problems/move-zeroes/
 * 国际站高票讨论区：https://leetcode.com/problems/move-zeroes/discuss/?currentPage=1&orderBy=most_votes&query=&tag=java
 *
 * 题目描述：移动零
 *   给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *   输入: [0,1,0,3,12]
 *   输出: [1,3,12,0,0]
 *
 * 说明:
 *   必须在原数组上操作，不能拷贝额外的数组。
 *   尽量减少操作次数。
 */
public class Num283 {

    public void moveZeroes(int[] nums) {
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i > j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Num283 moveZero = new Num283();

        int[] nums = new int[]{0, 1, 0, 3, 12};
        System.out.print("移动前：");
        for (int n : nums) {
            System.out.printf("\t%d\t", n);
        }
        System.out.println();

        moveZero.moveZeroes(nums);

        System.out.print("移动后：");
        for (int n : nums) {
            System.out.printf("\t%d\t", n);
        }
    }

}

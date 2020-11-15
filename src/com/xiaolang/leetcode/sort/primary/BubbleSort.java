package com.xiaolang.leetcode.sort.primary;

/**
 * 初级排序指时间复杂度为 O(n^2) 的三种排序算法：
 *   - 选择排序（Selection Sort）
 *   - 插入排序（Insertion Sort）
 *   - 冒泡排序（Bubble Sort）
 *
 * 初级排序之 —— 冒泡排序：O(n^2)，稳定排序：
 *   - 嵌套循环，每次查看相邻的元素，如果逆序，则交换
 *   - 参考文档：https://www.cnblogs.com/onepixel/p/7674659.html
 */
public class BubbleSort {

    public int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                // 相邻元素进行比较，如果逆序则交换，每一轮都会将一个最大元素沉底
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{15, 10, 13, 8, 4, 7, 2, 9};

        BubbleSort bubbleSort = new BubbleSort();

        int[] results = bubbleSort.bubbleSort(nums);
        for (int result : results) {
            System.out.printf("%d\t", result);
        }
    }

}

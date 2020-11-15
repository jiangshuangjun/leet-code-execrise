package com.xiaolang.leetcode.sort.primary;

/**
 * 初级排序指时间复杂度为 O(n^2) 的三种排序算法：
 *   - 选择排序（Selection Sort）
 *   - 插入排序（Insertion Sort）
 *   - 冒泡排序（Bubble Sort）
 *
 * 初级排序之 —— 选择排序：O(n^2)，不稳定：
 *   - 每次找最小值，然后放到待排序数组的起始位置
 *   - 参考文档：https://www.cnblogs.com/onepixel/p/7674659.html
 */
public class SelectionSort {

    public int[] selectionSort(int[] nums) {
        int minIndex, temp;
        for (int i = 0; i < nums.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                // 寻找最小的数
                if (nums[j] < nums[minIndex]) {
                    // 将最小数的索引保存
                    minIndex = j;
                }
                temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{15, 10, 13, 8, 4, 7, 2, 9};

        SelectionSort selectionSort = new SelectionSort();

        int[] results = selectionSort.selectionSort(nums);
        for (int result : results) {
            System.out.printf("%d\t", result);
        }
    }

}

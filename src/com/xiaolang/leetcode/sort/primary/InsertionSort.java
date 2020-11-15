package com.xiaolang.leetcode.sort.primary;

/**
 * 初级排序指时间复杂度为 O(n^2) 的三种排序算法：
 *   - 选择排序（Selection Sort）
 *   - 插入排序（Insertion Sort）
 *   - 冒泡排序（Bubble Sort）
 *
 * 初级排序之 —— 插入排序：O(n^2)，稳定排序：
 *   - 从前到后逐步构建有序序列；对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入
 *   - 参考文档：https://www.cnblogs.com/onepixel/p/7674659.html
 */
public class InsertionSort {

    public int[] insertionSort(int[] nums) {
        int temp, currentIndex;
        for (int i = 1; i < nums.length; i++) {
            // 保存每次需要插入的数
            temp = nums[i];
            currentIndex = i;
            // 把所有大于要插入数的数都向后移动，nums[currentIndex] 就是要插入的数需要待的位置
            while (currentIndex > 0 && nums[currentIndex - 1] > temp) {
                nums[currentIndex] = nums[currentIndex - 1];
                currentIndex--;
            }
            // 将需要插入的数，放置到正确的位置上
            nums[currentIndex] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{15, 10, 13, 8, 4, 7, 2, 9};

        InsertionSort insertionSort = new InsertionSort();

        int[] results = insertionSort.insertionSort(nums);
        for (int result : results) {
            System.out.printf("%d\t", result);
        }
    }

}

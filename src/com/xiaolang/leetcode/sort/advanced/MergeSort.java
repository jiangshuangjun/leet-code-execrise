package com.xiaolang.leetcode.sort.advanced;

/**
 * 高级排序指时间复杂度为 O(N*LogN) 的三种排序算法：
 *   - 快速排序（Quick Sort）
 *   - 归并排序（Merge Sort）
 *   - 堆排序（Heap Sort）
 *
 * 高级排序之 —— 归并排序：O(N*LogN)，稳定排序：
 *   1. 把长度为 n 的输入序列分成两个长度为 n/2 的子序列
 *   2. 对这两个子序列分别采用归并排序
 *   3. 将两个排序好的子序列合并成一个最终的排序序列
 *   - 参考文档：https://www.cnblogs.com/onepixel/p/7674659.html
 */
public class MergeSort {

    public void mergeSort(int[] nums, int left, int right) {
        if (right <= left) {
            return;
        }
        // (left + right) / 2
        int mid = (left + right) >> 1;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        // 中间数组
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            temp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <=right) {
            temp[k++] = nums[j++];
        }
        // 也可以用：System.arraycopy(temp, 0, nums, left, temp.length);
        for (int p = 0; p < temp.length; p++) {
            nums[left + p] = temp[p];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{15, 10, 13, 8, 4, 7, 2, 9};

        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(nums, 0, nums.length - 1);

        for (int num : nums) {
            System.out.printf("%d\t", num);
        }
    }

}

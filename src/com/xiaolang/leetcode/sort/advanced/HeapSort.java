package com.xiaolang.leetcode.sort.advanced;

/**
 * 高级排序指时间复杂度为 O(N*LogN) 的三种排序算法：
 *   - 快速排序（Quick Sort）
 *   - 归并排序（Merge Sort）
 *   - 堆排序（Heap Sort）
 *
 * 高级排序之 —— 堆排序：O(N*LogN)，不稳定排序：
 *   1. 数组元素依次建立小顶堆
 *   2. 依次取堆顶元素，并删除
 *   - 参考文档：https://www.cnblogs.com/onepixel/p/7674659.html
 */
public class HeapSort {

    public void heapSort(int[] nums) {
        if (nums == null) {
            return;
        }

        int length = nums.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(nums, length, i);
        }
        for (int i = length - 1; i >=0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            heapify(nums, i, 0);
        }
    }

    private void heapify(int[] nums, int length, int i) {
        // nums 表示一个二叉堆，数组从下标 0 开始，所以左孩子节点为：2i + 1, 右孩子为：2i + 2
        int left = 2 * i + 1, right = 2 * i + 2;
        int largest = i;

        if (left < length && nums[left] > nums[largest]) {
            largest = left;
        }
        if (right < length && nums[right] > nums[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = nums[i];
            nums[i] = nums[largest];
            nums[largest] = temp;
            heapify(nums, length, largest);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{15, 10, 13, 8, 4, 7, 2, 9};

        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(nums);

        for (int num : nums) {
            System.out.printf("%d\t", num);
        }
    }

}

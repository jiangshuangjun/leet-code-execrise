package com.xiaolang.leetcode.sort.advanced;

import java.util.PriorityQueue;

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
 *
 * 该类采用 jdk PriorityQueue 自带的小顶堆排序达到堆排序的目的
 */
public class HeapSort2 {

    public void heapSort(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer(num);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = queue.poll();
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{15, 10, 13, 8, 4, 7, 2, 9};

        HeapSort2 heapSort = new HeapSort2();
        heapSort.heapSort(nums);

        for (int num : nums) {
            System.out.printf("%d\t", num);
        }
    }

}

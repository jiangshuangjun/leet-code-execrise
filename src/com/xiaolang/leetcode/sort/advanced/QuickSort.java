package com.xiaolang.leetcode.sort.advanced;


/**
 * 高级排序指时间复杂度为 O(N*LogN) 的三种排序算法：
 *   - 快速排序（Quick Sort）
 *   - 归并排序（Merge Sort）
 *   - 堆排序（Bubble Sort）
 *
 * 高级排序之 —— 快速排序：O(N*LogN)，不稳定排序：
 *   - 数组取标杆 pivot，将小元素放 pivot 左边，大元素放右边，然后依次对左边和右边子数组继续快排，以达到整个序列有序
 *   - 注意：正常情况下数组的 prepend 操作的时间复杂度是 O(n)，但是可以进行特殊优化到 O(1)
 *          采用的方式是申请稍大一些的内存空间，然后在数组最开始预留一部分空间，然后 prepend 的操作则是把头下标前移一个位置即可
 *   - 参考文档：https://www.cnblogs.com/onepixel/p/7674659.html
 */
public class QuickSort {

    public int[] quickSort(int[] nums, int begin, int end) {
        if (end <= begin) {
            return nums;
        }
        int pivot = partition(nums, begin, end);
        quickSort(nums, begin, pivot - 1);
        quickSort(nums, pivot + 1, end);
        return nums;
    }

    // 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
    // 在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作
    private int partition(int[] nums, int begin, int end) {
        // 选择 nums[end] 作为比对参照（这个可任意指定），pivot 表示小于 nums[end] 值的元素个数
        int pivot = begin;
        for (int i = begin; i < end; i++) {
            if (nums[i] < nums[end]) {
                int temp = nums[pivot];
                nums[pivot] = nums[i];
                nums[i] = temp;
                pivot++;
            }
        }

        int temp = nums[end];
        nums[end] = nums[pivot];
        nums[pivot] = temp;
        return pivot;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{15, 10, 13, 8, 4, 7, 2, 9};

        QuickSort quickSort = new QuickSort();

        int[] results = quickSort.quickSort(nums, 0, nums.length -1);
        for (int result : results) {
            System.out.printf("%d\t", result);
        }
    }

}

package com.xiaolang.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 题号：24 号题
 * 国内站：https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * 国际站高票讨论区：https://leetcode.com/problems/swap-nodes-in-pairs/discuss/?currentPage=1&orderBy=most_votes&query=&tag=java
 *
 * 题目描述：两两交换链表中的节点
 *   给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *   你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *   输入：head = [1, 2, 3, 4]
 *   输出：[2, 1, 4, 3]
 *
 * 示例 2：
 *   输入：head = []
 *   输出：[]
 *
 * 示例 3：
 *   输入：head = [1]
 *   输出：[1]
 */
public class Num24 {

    public ListNode swapPairs1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 递归
        ListNode newHead = head.next;
        head.next = swapPairs1(newHead.next);
        newHead.next = head;
        return newHead;
    }

    public ListNode swapPairs2(ListNode head) {
        // 迭代
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;

            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        Num24 swapPairs = new Num24();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode temp = head;
        List<Integer> oldList = new ArrayList<>();
        while (temp != null) {
            oldList.add(temp.val);
            temp = temp.next;
        }
        System.out.printf("原始链表：%s\n", oldList);

//        ListNode newHead = swapPairs.swapPairs1(head);
        ListNode newHead = swapPairs.swapPairs2(head);
        List<Integer> newList = new ArrayList<>();
        temp = newHead;
        while (temp != null) {
            newList.add(temp.val);
            temp = temp.next;
        }
        System.out.printf("两两交换后链表：%s\n", newList);
    }

}
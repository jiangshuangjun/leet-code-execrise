package com.xiaolang.leetcode.problems;

/**
 * 题号：206 号题
 * 国内站：https://leetcode-cn.com/problems/reverse-linked-list/
 * 国际站高票讨论区：https://leetcode.com/problems/reverse-linked-list/discuss/?currentPage=1&orderBy=most_votes&query=&tag=java
 *
 * 题目描述：反转链表
 * 反转一个单链表。
 *
 * 示例:
 *   输入: 1->2->3->4->5->NULL
 *   输出: 5->4->3->2->1->NULL
 * 进阶:
 *   你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class Num206 {

    public ListNode reverseList1(ListNode head) {
        // 迭代
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    public ListNode reverseList2(ListNode head) {
        // 递归
        return reverseList2(head, null);
    }

    public ListNode reverseList2(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        return reverseList2(next, head);
    }

    public static void main(String[] args) {
        Num206 reverseList = new Num206();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        System.out.print("翻转前链表：\t");
        ListNode temp = head;
        while (temp != null) {
            System.out.printf("%d\t——>\t", temp.val);
            temp = temp.next;
        }
        System.out.print("Null\n");

        ListNode newHead = reverseList.reverseList1(head);
//        ListNode newHead = reverseList.reverseList2(head);
        System.out.print("翻转后链表：\t");
        while (newHead != null) {
            System.out.printf("%d\t——>\t", newHead.val);
            newHead = newHead.next;
        }
        System.out.print("Null\n");
    }

}
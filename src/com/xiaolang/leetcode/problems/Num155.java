package com.xiaolang.leetcode.problems;


/**
 * 题号：155 号题
 * 国内站：https://leetcode-cn.com/problems/min-stack/
 * 国际站高票讨论区：https://leetcode.com/problems/min-stack/discuss/?currentPage=1&orderBy=most_votes&query=&tag=java
 *
 * 题目描述：最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *   push(x) —— 将元素 x 推入栈中。
 *   pop() —— 删除栈顶的元素。
 *   top() —— 获取栈顶元素。
 *   getMin() —— 检索栈中的最小元素。
 */
public class Num155 {

    private Node head;

    /** initialize your data structure here. */
    public Num155() {

    }

    public void push(int x) {
        if (head == null) {
            head = new Node(x, x, null);
        } else {
            head = new Node(x, Math.min(x, head.min), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private class Node {
        private int val;
        private int min;
        private Node next;

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Num155 minStack = new Num155();
        minStack.push(-3);
        minStack.push(2);
        minStack.push(1);
        minStack.push(5);

        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
    }

}

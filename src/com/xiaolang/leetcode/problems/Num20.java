package com.xiaolang.leetcode.problems;

import java.util.Stack;

/**
 * 题号：20 号题
 * 国内站：https://leetcode-cn.com/problems/valid-parentheses/
 * 国际站高票讨论区：https://leetcode.com/problems/valid-parentheses/discuss/?currentPage=1&orderBy=most_votes&query=&tag=java
 * 算法思路：使用栈的 FILO 特性
 *
 * 题目描述：有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 *   - 左括号必须用相同类型的右括号闭合。
 *   - 左括号必须以正确的顺序闭合。
 *
 * 示例 1:
 *   输入: "()"
 *   输出: true
 * 示例 2:
 *   输入: "()[]{}"
 *   输出: true
 * 示例 3:
 *   输入: "(]"
 *   输出: false
 */
public class Num20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Num20 validParentheses = new Num20();
        String s = "([{()}])";
        System.out.println(validParentheses.isValid(s));
    }

}

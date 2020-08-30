package cn.blackme.leetcode;

import java.util.Stack;

/**
 * 用两个栈实现队列
 *
 *
 */
public class LeetCodeJZ09 {

    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

//    public CQueue() {
//
//    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        if (!s2.isEmpty())
            return s2.pop();
        else
            return -1;
    }

}

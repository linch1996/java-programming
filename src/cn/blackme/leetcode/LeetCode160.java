package cn.blackme.leetcode;

import cn.blackme.leetcode.definition.ListNode;

/**
 * 相交链表
 *
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class LeetCode160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2) {
            l1 = l1 != null ? l1.next : headB;
            l2 = l2 != null ? l2.next : headA;
        }
        return l1;
    }

}

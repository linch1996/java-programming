package cn.blackme.leetcode;

import cn.blackme.leetcode.definition.ListNode;

/**
 * 移除链表元素
 *
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class LeetCode203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode pre = node, cur = head;
        while (cur != null) {
            if (cur.val == val)
                pre.next = cur.next;
            else
                pre = cur;
            cur = cur.next;
        }
        return node.next;
    }

}

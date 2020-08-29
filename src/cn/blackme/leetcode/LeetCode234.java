package cn.blackme.leetcode;

import cn.blackme.leetcode.definition.ListNode;

import java.util.List;

/**
 * 回文链表
 *
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode234 {

    // 反转前半部分,这样把链表结构破坏了,最后边比较边反转回来
    public static boolean isPalindrome(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode fast = head;
        ListNode newPre;
        boolean res = true;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode tmp = cur.next;
            cur.next =pre;
            pre = cur;
            cur = tmp;
        }

        newPre = cur;

        if (fast != null)
            cur = cur.next;

        while (pre != null) {
            if (pre.val != cur.val)
                res = false;
            ListNode tmp = pre.next;
            pre.next = newPre;
            newPre = pre;
            pre = tmp;
            cur = cur.next;
        }

        return res;
    }

}

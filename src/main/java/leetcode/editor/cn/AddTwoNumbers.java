package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class AddTwoNumbers {

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            //解法：双指针，注意进位的处理

            // 在两条链表上的指针
            ListNode p1 = l1, p2 = l2;
            // 虚拟头结点（构建新链表时的常用技巧）
            ListNode dummy = new ListNode(-1);
            // 指针 p 负责构建新链表
            ListNode p = dummy;
            // 记录进位
            int carry = 0;
            // 开始执行加法，两条链表走完且没有进位时才能结束循环
            while (p1 != null || p2 != null || carry > 0) {
                // 先加上上次的进位
                int val = carry;
                if (p1 != null) {
                    val += p1.val;
                    p1 = p1.next;
                }
                if (p2 != null) {
                    val += p2.val;
                    p2 = p2.next;
                }
                // 处理进位情况
                carry = val / 10;
                val = val % 10;
                // 构建新节点
                p.next = new ListNode(val);
                p = p.next;
            }
            // 返回结果链表的头结点（去除虚拟头结点）
            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
        // put your test code here
        ListNode l1 = ListNode.createHead(new int[] {9, 9, 9, 9, 9, 9, 9});
        ListNode l2 = ListNode.createHead(new int[] {9, 9, 9, 9});
        ListNode listNode = solution.addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }
}
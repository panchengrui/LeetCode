package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ReverseLinkedListIi {

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
        public ListNode reverseBetween(ListNode head, int left, int right) {
            //思路：首先基于反转一个链表的前n个链表的算法思路
            //在此基础上就是先找到需要反转的链表的开始节点的前一个节点
            //把前一个节点的后继指向反转以后的链表的头结点

            if (left == 1) {
                return reverseN(head, right);
            }
            //先找到left节点的前一个节点
            ListNode pre = head;
            for (int i = 1; i < left - 1; i++) {
                pre = pre.next;
            }
            //从第left对应的那个节点开始反转链表
            pre.next = reverseN(pre.next, right - left + 1);
            return head;
        }

        /**
         * 这个方法是反转一个单链表的前n个节点
         * @param head
         * @param n
         * @return
         */
        ListNode reverseN(ListNode head, int n) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode pre = null, cur = head;
            while (n-- > 0) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            //此处cur已经是反转范围外的第一个节点了，head则是反转后的尾节点
            head.next = cur;
            //pre则是反转后的头结点
            return pre;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
        // put your test code here

        ListNode head = ListNode.createHead(new int[] {1, 2, 3, 4, 5});
        ListNode listNode = solution.reverseBetween(head, 2, 4);
        System.out.println(listNode);
    }
}
package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ReverseNodesInKGroup {

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
        public ListNode reverseKGroup(ListNode head, int k) {
            //思路：算法基础是依赖链表前n个节点反转的方法
            //主要是需要增加根据是否足够k个节点进行反转的判断逻辑，
            //以及需要进行递归反转后的链接逻辑

            if (head == null) {return null;}
            // 区间 [a, b) 包含 k 个待反转元素
            ListNode a, b;
            a = b = head;
            for (int i = 0; i < k; i++) {
                // 不足 k 个，不需要反转了
                if (b == null) {return head;}
                b = b.next;
            }
            //反转前 k 个元素，newHead在第一次进行反转后这个节点就确定了，
            //就是第一个进行反转的那个链表的头结点
            //并不会在后续迭代中改变，
            ListNode newHead = reverseN(a, k);
            // 此时 b 指向下一组待反转的头结点，a则是当前链表的尾节点
            // 递归反转后续链表并连接起来
            a.next = reverseKGroup(b, k);
            return newHead;

        }

        /**
         * 这个方法是反转一个单链表的前n个节点
         *
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
        Solution solution = new ReverseNodesInKGroup().new Solution();
        // put your test code here

    }
}
package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ReverseLinkedListIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (left == 1) {
                return reverseN(head, right);
            }
            ListNode pre = head;
            for (int i = 1; i < left - 1; i++) {
                pre = pre.next;
            }
            pre.next = reverseN(pre.next, right - left + 1);
            return head;
        }
    }

    public ListNode reverseN(ListNode head, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;
        while (n > 0) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
            n--;
        }
        head.next = cur;
        return pre;
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
        // put your test code here
        
    }
}
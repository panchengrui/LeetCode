package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class MiddleOfTheLinkedList {

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
        public ListNode middleNode(ListNode head) {
            //思路：快慢指针（双指针，慢指针一次走一步，快指针一次走两步）
            ListNode slow = head;
            ListNode fast = head;

            // 移动指针
            // 循环条件保证 fast 以及 fast.next 不为空，这样 fast.next.next 才不会出错
            while (fast != null && fast.next != null) {
                slow = slow.next;       // slow 移动一步
                fast = fast.next.next;  // fast 移动两步
            }

            // 返回 slow 指针
            // 当循环结束时:
            //   - 如果链表节点总数是奇数, fast 指向最后一个节点, slow 正好指向中间节点。
            //   - 如果链表节点总数是偶数, fast 指向 null, slow 正好指向第二个中间节点。
            // 这两种情况都符合题意要求。
            return slow;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new MiddleOfTheLinkedList().new Solution();
        // put your test code here

    }
}
package leetcode.editor.cn;

import leetcode.editor.common.*;

public class PalindromeLinkedList {

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
        // 从左向右移动的指针
        ListNode left;

        // 记录链表是否为回文
        boolean res = true;

        public boolean isPalindrome(ListNode head) {
            //思路：
            // 1、首先判断是否回文用两个指针从两边向中间相向而行
            // 2、单链表可以用栈同样实现逆序遍历

            left = head;
            traverse(head);
            return res;
        }

        private void traverse(ListNode right) {
            if (!res || right == null) {
                return;
            }
            traverse(right.next);
            if (left.val != right.val) {
                res = false;
                return;
            }
            left = left.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        // put your test code here

    }
}
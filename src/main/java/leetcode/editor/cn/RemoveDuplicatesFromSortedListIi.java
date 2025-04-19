package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class RemoveDuplicatesFromSortedListIi {

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
        public ListNode deleteDuplicates(ListNode head) {
            //总体思路：分解链表，遍历原链表时通过(cur.next != null && cur.val == cur.next.val)识别重复元素
            //将重复元素链接到重复元素链表中，非重复元素链接到非重复链表中
            ListNode dummyUniq = new ListNode(Integer.MIN_VALUE);
            ListNode dummyDup = new ListNode(Integer.MIN_VALUE);

            ListNode pUniq = dummyUniq, pDup = dummyDup;
            ListNode cur = head;

            while (cur != null) {
                //找到重复元素，接到重复链表后面
                //这里的这个判断：cur.next != null && cur.val == cur.next.val
                //很关键，这个判断的作用是合理安放重复序列的第一个元素，否则，只拿pDup和cur比较
                //那么重复元素的第一个元素就被放到非重复链表中去了
                if ((cur.next != null && cur.val == cur.next.val) || pDup.val == cur.val) {
                    pDup.next = cur;
                    pDup = pDup.next;
                } else {
                    //非重复元素，接到不重复链表后面
                    pUniq.next = cur;
                    pUniq = pUniq.next;
                }
                cur = cur.next;
                //将原链表和新链表断开
                pUniq.next = null;
                pDup.next = null;
            }
            return dummyUniq.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
        // put your test code here

        ListNode head = ListNode.createHead(new int[] {1, 2, 3, 3, 4, 4, 5});
        ListNode listNode = solution.deleteDuplicates(head);
        System.out.println(listNode);
    }
}
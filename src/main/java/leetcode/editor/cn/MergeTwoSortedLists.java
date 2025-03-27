package leetcode.editor.cn;

import leetcode.editor.common.ListNode;

public class MergeTwoSortedLists {

    // @lc code=start
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(-1);
            ListNode newList = dummy;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    newList.next = l1;
                    l1 = l1.next;
                } else {
                    newList.next = l2;
                    l2 = l2.next;
                }
                newList = newList.next;
            }
            newList.next = l1 != null ? l1 : l2;
            return dummy.next;
        }
    }
    // @lc code=end
    
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        // put your test code here
        ListNode l1 = ListNode.createHead(new int[]{1,2,4});
        ListNode l2 = ListNode.createHead(new int[]{1,3,4});

        ListNode res = solution.mergeTwoLists(l1, l2);
        ListNode.print(res);
    }
}



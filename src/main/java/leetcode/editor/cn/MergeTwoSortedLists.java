package leetcode.editor.cn;

import leetcode.editor.common.ListNode;

public class MergeTwoSortedLists {

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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummy = new ListNode(-1);
            ListNode newList = dummy;
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    newList.next = list1;
                    list1 = list1.next;
                } else {
                    newList.next = list2;
                    list2 = list2.next;
                }
                newList = newList.next;
            }
            newList.next = list1 != null ? list1 : list2;
            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        // put your test code here
        ListNode l1 = ListNode.createHead(new int[]{1,2,4});
        ListNode l2 = ListNode.createHead(new int[]{1,3,4});

        ListNode res = solution.mergeTwoLists(l1, l2);
        ListNode.print(res);
    }
}
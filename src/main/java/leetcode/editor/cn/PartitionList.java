package leetcode.editor.cn;

import leetcode.editor.common.ListNode;

public class PartitionList {

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
        public ListNode partition(ListNode head, int x) {
            //虚拟头结点的使用，方便后续链接链表
            ListNode dummy1 = new ListNode(-1);
            ListNode dummy2 = new ListNode(-1);
            ListNode p1 = dummy1, p2 = dummy2;
            ListNode cur = head;
            ListNode temp;
            while (cur != null) {
                if (cur.val < x) {
                    p1.next = cur;
                    p1 = cur;
                } else {
                    p2.next = cur;
                    p2 = cur;
                }
                //不能直接让 cur 往后走，否则链表中会出现环
                //cur = cur.next;
                // 正确的做法是断开原链表中的每个节点的 next 指针
                 temp = cur.next;
                 cur.next = null;
                 cur = temp;
            }
            //这里因为虚拟头结点，所以很好链接
            p1.next = dummy2.next;
            //虚拟头结点，这里返回也很好写
            return dummy1.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new PartitionList().new Solution();
        // put your test code here
        
    }
}
package leetcode.editor.cn;

import leetcode.editor.common.ListNode;

public class LinkedListCycleIi {

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            ////最简单暴力的想法就是用一个Set来判断
            //Set<ListNode> set = new HashSet<>();
            //ListNode p = head;
            //int i = 0;
            //while (p != null) {
            //    if (set.contains(p)) {
            //        return p;
            //    }
            //    set.add(p);
            //    p = p.next;
            //}
            //return null;

            //快慢指针：慢指针走一步，快指针走两步
            //快慢指针相遇时，不一定是环的入口，但是快指针一定比慢指针多走了整数倍的环长度
            //此时将快指针或慢指针重新回到头结点往后走，另一个指针同步每次一步往后走，两个指针一定会在环的入口处相遇
            if (head == null) {return null;}
            ListNode slow = head, fast = head.next;
            while (fast != null && fast.next != null) {
                if (slow == fast) {
                    //慢指针重新指向head的时候，快指针也需要同步走一步，
                    // 不然就不是同步地走k-m步了，就会无限循环了
                    slow = head;
                    fast = fast.next;
                    while (slow != fast) {
                        slow = slow.next;
                        fast = fast.next;
                    }
                    return slow;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return null;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new LinkedListCycleIi().new Solution();
        // put your test code here
        ListNode fourth = new ListNode(-4);
        ListNode third = new ListNode(0, fourth);
        ListNode second = new ListNode(2, third);
        ListNode first = new ListNode(3, second);
        fourth.next = second;
        ListNode listNode = solution.detectCycle(first);
        System.out.println(listNode);

    }
}
package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class IntersectionOfTwoLinkedLists {

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ////最初我自己的题解，就是用一个Set来保存A链表，然后来遍历B链表，
            //// 遇到第一个相同的节点就是公共节点
            //Set<ListNode> aListNodes = new HashSet<>();
            //while (headA != null) {
            //    aListNodes.add(headA);
            //    headA = headA.next;
            //}
            //while (headB != null) {
            //    if (aListNodes.contains(headB)) {
            //        break;
            //    } else {
            //        headB = headB.next;
            //    }
            //}
            //return headB;

            //更好的解法还是双指针，两个指针先分别遍历A和B链表
            //第一个指针遍历完第一个链表后遍历第二个链表，第二个链表遍历完第二个链表后遍历第一个链表
            //这样两个指针就可以同时进入公共节点
            ListNode p1 = headA, p2 = headB;
            //循环结束条件是p1!=p2即可，因为如果两个链表没有相交部分，两个指针会同时走到null
            while (p1 != p2) {
                // 如果 p1 到达末尾，则指向 B 的头节点，否则移动到下一个节点
                p1 = (p1 == null) ? headB : p1.next;
                // 如果 p2 到达末尾，则指向 A 的头节点，否则移动到下一个节点
                p2 = (p2 == null) ? headA : p2.next;
            }
            // 循环结束后，p1 (或 p2) 就是交点，或者如果没交点则为 null
            return p1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoLinkedLists().new Solution();
        // put your test code here

    }
}
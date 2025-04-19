package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class RemoveNthNodeFromEndOfList {

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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ////思路：还是双指针，快慢指针，让快指针先走n步，最后通过控制细节
            ////让慢指针最后停留在待删除节点的前一个节点上，进行删除操作
            //ListNode left = head, right = head;
            //while (n-- > 0) {
            //    right = right.next;
            //}
            ////这是我最开始的考虑，发现在测试用例如果是删除头结点的情况下，
            ////那么此时right也一定为null了，并且头结点是会变化的，所以此时直接返回头结点的下一个节点
            //if (right == null) {
            //    return left.next;
            //}
            //while (right.next != null) {
            //    left = left.next;
            //    right = right.next;
            //}
            //ListNode temp = left.next.next;
            //left.next.next = null;
            //left.next = temp;
            //return head;

            //下面这个总体思路是一样的，但因为上方方法在删除头结点的情况下需要特殊判断
            //当前此方法通过引入虚拟头结点使逻辑更统一无需特殊判断
            ListNode dummy = new ListNode(-1, head);
            ListNode left = dummy, right = dummy;
            while (n-- > 0) {
                right = right.next;
            }
            //该循环结束后，left节点就停留在了待删除节点的上一个节点
            while (right.next != null) {
                left = left.next;
                right = right.next;
            }
            //先保留待删除节点，执行完待删除节点前后节点的链接后，把待删除节点的next指针删除
            ListNode toBeDelede = left.next;
            left.next = left.next.next;
            toBeDelede.next = null;
            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
        // put your test code here

    }
}
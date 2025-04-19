package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class AddTwoNumbersIi {

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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            //思路；用栈先分别将两个两个链表的元素入栈，之后就是正向的逻辑了
            //注意下最后构建返回的链表的顺序也是要倒过来一下，因为节点是从低位开始构建的，
            //但链表返回时是高位指向低位的

            Stack<ListNode> stack1 = new Stack<>();
            Stack<ListNode> stack2 = new Stack<>();
            ListNode p1 = l1, p2 = l2;
            while (p1 != null) {
                stack1.add(p1);
                p1 = p1.next;
            }
            while (p2 != null) {
                stack2.add(p2);
                p2 = p2.next;
            }

            //下面就是正向的逻辑了
            int carry = 0;
            //newNode是每次循环时新构建出的节点
            ListNode newNode = null;
            //pre是上次循环构建出的节点
            ListNode pre = null;
            while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
                int val = carry;
                if (!stack1.isEmpty()) {
                    val += stack1.pop().val;
                }
                if (!stack2.isEmpty()) {
                    val += stack2.pop().val;
                }
                carry = val / 10;
                newNode = new ListNode(val % 10);

                //新节点指向上一个循环构建出来的节点，之后pre再指向本次循环新构建出的节点
                newNode.next = pre;
                pre = newNode;
            }
            return newNode;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new AddTwoNumbersIi().new Solution();
        // put your test code here

    }
}
package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class MergeKSortedLists {

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
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) {
                return null;
            }

            //解法1：暴力两两合并，关键在于节点访问次数的明显重复
            //ListNode mergedList = lists[0];
            //for (int i = 1; i < lists.length; i++) {
            //    mergedList = merge2List2(mergedList, lists[i]);
            //}
            //return mergedList;

            //解法2：分治思想
            //分治与两两排序，两种方法都需要进行K-1次的两两合并
            //关键区别在于节点的访问次数，例如8条有序链表的合并：
            //1、两两合并，第一条链表中的每个元素在后续的每次两两合并都参与比较，所以是7次
            //2、分治思想，第一条链表中的每个元素只参与1,2合并；1,2,3,4合并；1,2,3,4,5,6,7,8；这3次合并，每个元素被比较的次数从7次变为3次，节省的复杂度在这。
            //总结：分治法通过平衡每次合并的两个链表的规模，避免了让短链表反复与越来越长的链表合并，从而显著减少了节点的总访问次数。
            //算法可视化面板：https://labuladong.online/algo/essential-technique/divide-and-conquer/#div_merge-k-sorted-lists-devide2
            return mergeKLists(lists, 0, lists.length - 1);
        }

        public ListNode mergeKLists(ListNode[] lists, int start, int end) {
            if (start == end) {
                return lists[start];
            }
            int mid = start + (end - start) / 2;
            ListNode left = mergeKLists(lists, start, mid);
            ListNode right = mergeKLists(lists, mid + 1, end);

            ListNode listNode = merge2List2(left, right);
            return listNode;
        }

        /**
         * 双指针法对两个有序列表进行合并
         */
        private ListNode merge2List2(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(-1);
            ListNode curNode = dummy;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    curNode.next = l1;
                    l1 = l1.next;
                } else {
                    curNode.next = l2;
                    l2 = l2.next;
                }
                curNode = curNode.next;
            }
            curNode.next = l1 != null ? l1 : l2;
            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
        // put your test code here
        
    }
}
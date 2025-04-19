package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class KthSmallestElementInASortedMatrix {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            //核心思想就是，利用最小堆，把候选的最小元素依次加入最小堆中
            // i, j 记录当前元素的索引位置，用于生成下一个节点
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                // 按照元素大小升序排序
                return a[0] - b[0];
            });

            // 初始化优先级队列，把每一行的第一个元素装进去，第一小的元素一定是在第一列中
            for (int i = 0; i < matrix.length; i++) {
                pq.offer(new int[] {matrix[i][0], i, 0});
            }

            int res = -1;
            //每次循环，弹出的都是第x小的值，x=当前循环次数
            while (!pq.isEmpty() && k > 0) {
                int[] cur = pq.poll();
                res = cur[0];
                k--;
                // 链表中的下一个节点加入优先级队列
                //如果当前最小值的链表有后继节点，那么把这个后继节点加入最小堆，因为它可能是下一轮的最小值
                int i = cur[1], j = cur[2];
                if (j + 1 < matrix[i].length) {
                    pq.add(new int[] {matrix[i][j + 1], i, j + 1});
                }
            }
            return res;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new KthSmallestElementInASortedMatrix().new Solution();
        // put your test code here

    }
}
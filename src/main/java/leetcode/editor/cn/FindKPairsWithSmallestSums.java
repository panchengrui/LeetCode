package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class FindKPairsWithSmallestSums {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            //核心思想就是，nums1的每个元素作为固定序列的行，分别和nums2的每个元素组成二元组
            //序列1：nums1[0],nums2[0]   nums1[0],nums2[1]   ...  nums1[0] nums2[j]
            //序列2：nums1[1],nums2[0]   nums1[1],nums2[1]   ...  nums1[1] nums2[j]
            //序列x
            //因为nums2的有序性，每个序列的二元组一定也是有序的，所以也变成了利用最小堆找出K个最小的数

            // 存储三元组 (num1[i], nums2[j], j)
            // j 记录 nums2 元素的索引位置，用于生成下一个节点
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                // 按照数对的元素和升序排序
                return (a[0] + a[1]) - (b[0] + b[1]);
            });
            // 按照 23 题的逻辑初始化优先级队列
            for (int i = 0; i < nums1.length; i++) {
                pq.offer(new int[] {nums1[i], nums2[0], 0});
            }

            List<List<Integer>> res = new ArrayList<>();
            // 执行合并多个有序链表的逻辑
            while (!pq.isEmpty() && k-- > 0) {
                int[] cur = pq.poll();
                List<Integer> pair = new ArrayList<>();
                pair.add(cur[0]);
                pair.add(cur[1]);
                res.add(pair);

                // 链表中的下一个节点加入优先级队列
                int j = cur[2];
                if (j + 1 < nums2.length) {
                    //这里的i是隐含的，由cur[0]就得到了序列中的nums1的那个元素
                    pq.add(new int[] {cur[0], nums2[j + 1], j + 1});
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new FindKPairsWithSmallestSums().new Solution();
        // put your test code here

    }
}
package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class MergeSortedArray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            //双指针，但是不同于链表，如果数组从前往后会导致数字被覆盖，所以
            //转变一下思路，nums1末尾的元素都是0，将双指针初始化在数组的尾部，
            //然后从后向前进行合并，这样即便覆盖了 nums1 中的元素，这些元素也必然早就被用过了，不会影响答案的正确性。
            int i = m - 1, j = n - 1;

            int p = nums1.length - 1;

            while (i >= 0 && j >= 0) {
                if (nums1[i] > nums2[j]) {
                    nums1[p] = nums1[i];
                    i--;
                } else {
                    nums1[p] = nums2[j];
                    j--;
                }
                p--;
            }

            // 可能其中一个数组的指针走到尽头了，而另一个还没走完
            // 因为我们本身就是在往 nums1 中放元素，所以只需考虑 nums2 是否剩元素即可
            while (j >= 0) {
                nums1[p--] = nums2[j--];
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
        // put your test code here

    }
}
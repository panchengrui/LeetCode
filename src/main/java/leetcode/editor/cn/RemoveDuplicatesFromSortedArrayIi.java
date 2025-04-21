package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class RemoveDuplicatesFromSortedArrayIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            int slow = 0, fast = 0;
            // 记录一个元素重复的次数
            int count = 0;
            while (fast < nums.length) {
                if (nums[fast] != nums[slow]) {
                    // 此时，对于 nums[0..slow] 来说，nums[fast] 是一个新的元素，加进来
                    nums[++slow] = nums[fast];
                } else if (slow < fast && count < 2) {
                    // 此时，对于 nums[0..slow] 来说，nums[fast] 重复次数小于 2，也加进来
                    nums[++slow] = nums[fast];
                }
                fast++;
                count++;
                if (fast < nums.length && nums[fast] != nums[fast - 1]) {
                    // fast 遇到新的不同的元素时，重置 count
                    count = 0;
                }
            }
            // 数组长度为索引 + 1
            return slow + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedArrayIi().new Solution();
        // put your test code here
        int[] nums = new int[] {1, 1, 1, 1, 2, 2, 3};
        int i = solution.removeDuplicates(nums);
        System.out.println(i);
    }
}
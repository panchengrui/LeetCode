package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class TwoSumIiInputArrayIsSorted {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            //思路：双指针一左一右相向而行
            //因为是有序数组，所以如果两个指针对应的元素之和<target，则左指针向右一步
            //如果>target，则右指针向左一步

            int left = 0, right = numbers.length - 1;
            while (left < right) {
                int val = numbers[left] + numbers[right];
                if (val == target) {
                    return new int[] {left + 1, right + 1};
                } else if (val < target) {
                    left++;
                } else {
                    right--;
                }
            }
            return new int[] {-1, -1};
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new TwoSumIiInputArrayIsSorted().new Solution();
        // put your test code here

    }
}
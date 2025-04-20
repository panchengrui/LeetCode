package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class MoveZeroes {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            //思路：以删除有序数组中指定元素为基础，用双指针
            // 实现，把0元素从数组中删除。最后在数组末尾填充0

            int slow = 0, fast = 0;
            while (fast < nums.length) {
                if (nums[fast] != 0) {
                    nums[slow++] = nums[fast];
                }
                fast++;
            }
            while (slow < nums.length) {
                nums[slow++] = 0;
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
        // put your test code here

    }
}
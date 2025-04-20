package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class RemoveDuplicatesFromSortedArray {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeDuplicates(int[] nums) {
            //思路：快慢指针，快指针每次循环前进一步，慢指针在快指针和慢指针数字不同时才前进一步，
            //并将当前快指针的值赋值给慢指针。慢指针刚刚跳过的那个索引是某值第一次出现的位置，直接
            //跳过，不用赋值

            int slow = 0, fast = 0;
            while (fast < nums.length) {
                if (nums[fast] != nums[slow]) {
                    slow++;
                    nums[slow] = nums[fast];
                }
                fast++;
            }
            return slow + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedArray().new Solution();
        // put your test code here

        int[] ints = {1, 1, 2};
        int i = solution.removeDuplicates(ints);
        System.out.println(i);
    }
}
package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class RemoveElement {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int removeElement(int[] nums, int val) {
            //思路：快慢指针，快指针每次循环前进一步，慢指针指向的是当前
            // 待插入的索引位置，所以是在找到不删除的目标值的时候赋值给
            // 慢指针，接着慢指针前进一步

            int fast = 0, slow = 0;
            while (fast < nums.length) {
                if (nums[fast] != val) {
                    //注意这里和有序数组去重的细节差异，这里是先赋值
                    // 再给slow++，这样可以保证数组中不包含值为val
                    // 的元素，另外下方的slow就是数组的长度了，
                    // 而不是有序数组去重slow+1才是数组长度
                    nums[slow++] = nums[fast];
                }
                fast++;
            }
            //
            return slow;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new RemoveElement().new Solution();
        // put your test code here
        int[] nums = new int[] {3, 2, 2, 3};
        int i = solution.removeElement(nums, 3);
        System.out.println(i);
    }
}
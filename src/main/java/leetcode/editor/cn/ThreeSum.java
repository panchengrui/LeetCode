package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ThreeSum {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            //思路：基于两数之和的双指针（左右指针）算法，主方法里
            //穷举第一个数字，将待求目标传入两数之和的方法中
            //防止重复的逻辑分散在主方法和两数之和的方法中

            //一定要先排序
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();

            int n = nums.length;
            for (int i = 0; i < n; i++) {
                int num = nums[i];
                // 对 target - nums[i] 计算 twoSum
                List<List<Integer>> twoSumTarget = twoSumTarget(nums, i + 1, 0 - num);
                // 如果存在满足条件的二元组，再加上 nums[i] 就是结果三元组
                twoSumTarget.stream().forEach(list -> {
                    list.add(0, num);
                    res.add(list);
                });
                // 跳过第一个数字重复的情况，否则会出现重复结果
                while (i < n - 1 && nums[i] == nums[i + 1]) {i++;}
            }
            return res;
        }

        // 从 nums[start] 开始，计算有序数组 nums 中所有和为 target 的二元组
        private List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
            int lo = start, hi = nums.length - 1;
            List<List<Integer>> res = new ArrayList<>();
            while (lo < hi) {
                int left = nums[lo], right = nums[hi];
                int sum = left + right;
                if (sum < target) {
                    lo++;
                } else if (sum > target) {
                    hi--;
                } else {
                    res.add(new ArrayList<>() {{
                        add(left);
                        add(right);
                    }});
                    //跳过重复元素
                    while (lo < hi && nums[lo] == left) {lo++;}
                    while (lo < hi && nums[hi] == right) {hi--;}
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        // put your test code here
        int[] nums = new int[] {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = solution.threeSum(nums);
    }
}
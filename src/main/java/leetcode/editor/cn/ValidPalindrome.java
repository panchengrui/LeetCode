package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class ValidPalindrome {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(String s) {
            //思路：先将字母数字筛选出来
            //之后用左右指针相向移动来判断

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (Character.isLetterOrDigit(c)) {
                    sb.append(Character.toLowerCase(c));
                }
            }

            int lo = 0, hi = sb.length() - 1;
            while (lo < hi) {
                if (sb.charAt(lo) != sb.charAt(hi)) {
                    return false;
                }
                lo++;
                hi--;
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
        // put your test code here

    }
}
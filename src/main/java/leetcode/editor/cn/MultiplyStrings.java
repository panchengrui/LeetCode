package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class MultiplyStrings {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String multiply(String num1, String num2) {
            int length1 = num1.length(), length2 = num2.length();
            // 结果最多为 length1 + length2 位数
            int[] res = new int[length1 + length2];
            // 从个位数开始逐位相乘，外层循环固定第二个数字某一位
            for (int i = length2 - 1; i >= 0; i--) {
                int n2 = num2.charAt(i) - '0';
                for (int j = length1 - 1; j >= 0; j--) {
                    int mul = n2 * (num1.charAt(j) - '0');
                    // 乘积在 res 对应的索引位置
                    int p1 = i + j, p2 = i + j + 1;
                    // 叠加到 res 上，这里p2是在递增的，就像我们在手动计算时的进一位将结果相加
                    int sum = mul + res[p2];
                    res[p2] = sum % 10;
                    res[p1] += sum / 10;
                }
            }
            // 结果前缀可能存的 0（未使用的位）
            //因为开头初始化数组的时候初始化了length1+length2位数
            int i = 0;
            while (i < res.length && res[i] == 0) {i++;}
            // 将计算结果转化成字符串
            StringBuilder str = new StringBuilder();
            for (; i < res.length; i++) {str.append(res[i]);}

            return str.length() == 0 ? "0" : str.toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    public static void main(String[] args) {
        Solution solution = new MultiplyStrings().new Solution();
        // put your test code here
        String multiply = solution.multiply("123", "456");
        System.out.println(multiply);

    }
}
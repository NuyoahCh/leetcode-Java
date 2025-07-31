package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

public class UglyNumberIi {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthUglyNumber(int n) {
            int p2 = 1, p3 = 1, p5 = 1;
            int product2 = 1, product3 = 1, product5 = 1;
            int[] ugly = new int[n + 1];
            int p = 1;

            while (p <= n) {
                int min = Math.min(Math.min(product2, product3), product5);
                ugly[p] = min;
                p++;

                if (min == product2) {
                    product2 = 2 * ugly[p2];
                    p2++;
                }

                if (min == product3) {
                    product3 = 3 * ugly[p3];
                    p3++;
                }

                if (min == product5) {
                    product5 = 5 * ugly[p5];
                    p5++;
                }
            }
            return ugly[n];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new UglyNumberIi().new Solution();
        // put your test code here
        int n = 10;
        int result = solution.nthUglyNumber(n);
        System.out.println(result);
    }
}
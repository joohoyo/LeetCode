package joohoyo.leetcode.problems.medium;

// 29. Divide Two Integers
// https://leetcode.com/problems/divide-two-integers/
//

public class M29_3 {
    public static void main(String[] args) {
        new M29_3().test();
    }

    public void test() {
        M29_3.Solution s = new M29_3.Solution();

//        System.out.println(s.divide(10,20)); // 0
//        System.out.println(s.divide(1, 1)); // 1
//        System.out.println(s.divide(10, 3)); // 3
//        System.out.println(s.divide(7, -3)); // -2
//        System.out.println(s.divide(-10, 3)); // -3
//        System.out.println(s.divide(-10, -3)); // 3
//        System.out.println(s.divide(10, 1)); // 10
//        System.out.println(s.divide(-2147483648, -1)); // 2147483647
//        System.out.println(s.divide(2147483647, 2)); // 1,073,741,823
        System.out.println(s.divide(-2147483648, 2)); // -1,073,741,824
        System.out.println(s.divide(2147483647, -2147483648)); // 0

    }

    class Solution {
        public int divide(int dividend, int divisor) {
            if (dividend == Integer.MIN_VALUE && divisor == -1) {
                return Integer.MAX_VALUE;
            }

            int a = Math.abs(dividend);
            int b = Math.abs(divisor);
            int res = 0;
            int x = 0;
            while (a - b >= 0) {
                for (x = 0; a - (b << x << 1) >= 0; x++) ;
                res += 1 << x;
                a -= b << x;
            }
            return (dividend > 0) == (divisor > 0) ? res : -res;
        }
    }

}

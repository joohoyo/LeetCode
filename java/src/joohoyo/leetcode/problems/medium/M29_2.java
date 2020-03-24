package joohoyo.leetcode.problems.medium;

// 29. Divide Two Integers
// https://leetcode.com/problems/divide-two-integers/
// 14:45 ~ gg (min)


public class M29_2 {
    public static void main(String[] args) {
        new M29_2().test();
    }

    public void test() {
        M29_2.Solution s = new M29_2.Solution();

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
            //  [−2**31,  2**31 − 1]
            if (dividend == 0) return 0;

            if (divisor == 1) {
                return dividend;
            } else if (divisor == -1) {
                if (Integer.MIN_VALUE == dividend) {
                    return Integer.MAX_VALUE;
                }
                return 0 - dividend;
            }

            int c = 0;
            if (dividend > 0 && divisor < 0) {
                c = 1;
            } else if (dividend < 0 && divisor > 0) {
                c = 2;
            } else if (dividend < 0 && divisor < 0) {
                c = 3;
            }

            divisor = Math.abs(divisor);
            int n = divisor;
            int answer = 1;
            // step 1
            while (n < dividend) {
                if (n + n < 0) {
                    while (n < dividend) {
                        if (n + divisor < 0) {
                            break;
                        }
                        n = n + divisor;
                        answer++;
                    }
                    break;
                }
                n = n + n;
                answer = answer + answer;
            }

            // step 2
            while (n > dividend) {
                n = n - divisor;
                answer--;
            }

            if (c == 1 || c == 2) {
                if (answer == Integer.MAX_VALUE - 1) {
                    return Integer.MAX_VALUE;
                }
                return 0 - answer;
            }

            return answer;
        }
    }

}

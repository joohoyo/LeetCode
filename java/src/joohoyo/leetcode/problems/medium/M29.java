package joohoyo.leetcode.problems.medium;

// 29. Divide Two Integers
// https://leetcode.com/problems/divide-two-integers/
// 19:25 ~ 19:55 (30min) gg


public class M29 {
    public static void main(String[] args) {
        new M29().test();
    }

    public void test() {
        M29.Solution s = new M29.Solution();

        System.out.println(s.divide(1, 1)); // 1
        System.out.println(s.divide(10, 3)); // 3
        System.out.println(s.divide(7, -3)); // -2
        System.out.println(s.divide(-10, 3)); // -3
        System.out.println(s.divide(-10, -3)); // 3
        System.out.println(s.divide(10, 1)); // 10
        System.out.println(s.divide(-2147483648, -1)); // 2147483647
    }

    class Solution {
        public int divide(int dividend, int divisor) {
            if (dividend == 0) {
                return 0;
            }

            if (divisor == 1) {
                return dividend;
            } else if (divisor == -1) {
                return 0 - dividend;
            }

            int answer = 0;
            int c = 0;
            if (dividend > 0 && divisor < 0) {
                c = 1;
            } else if (dividend < 0 && divisor > 0) {
                c = 2;
            } else if (dividend < 0 && divisor < 0) {
                c = 3;
            }
            boolean overflow = false;

            while (true) {
                boolean shouldBreak = false;
                switch (c) {
                    case 0:
                        dividend -= divisor;
                        if (dividend <= 0) {
                            shouldBreak = true;
                        }
                        break;
                    case 1:
                        dividend += divisor;
                        if (dividend <= 0) {
                            shouldBreak = true;
                        }
                        break;
                    case 2:
                        dividend += divisor;
                        if (dividend >= 0) {
                            shouldBreak = true;
                        }
                        break;
                    case 3:
                        dividend -= divisor;
                        if (dividend >= 0) {
                            shouldBreak = true;
                        }
                        break;
                }

                if (shouldBreak) {
                    if (dividend == 0) {
                        if (answer == Integer.MAX_VALUE - 1) {
                            overflow = true;
                        } else {
                            answer++;
                        }
                    }
                    break;
                }

                if (answer == Integer.MAX_VALUE - 1) {
                    overflow = true;
                    break;
                } else {
                    answer++;
                }
            }

            if (overflow) {
                return Integer.MAX_VALUE;
            }

            if (c == 1 || c == 2) {
                return 0 - answer;
            }
            return answer;
        }
    }

}

package joohoyo.leetcode.problems.medium;

// 22. Generate Parentheses
// https://leetcode.com/problems/generate-parentheses/
// 16:15 ~ 17:00 (45min)

import java.util.ArrayList;
import java.util.List;

public class M22 {
    public static void main(String[] args) {
        new M22().test();
    }

    public void test() {
        M22.Solution s = new M22.Solution();
        int n = 0;
        //

        n = 1;
        // ()

        n = 2;
        // (())
        // ()()

        n = 3;
//        "((()))",
//        "(()())",
//        "(())()",
//        "()(())",
//        "()()()"

        n = 4;
        List<String> answer = s.generateParenthesis(n);
        for (String a : answer) {
            System.out.println(a);
        }
    }

    class Solution {
        private List<String> answer = new ArrayList<String>();

        private boolean isGoodParenthesis(String parenthesis) {
            int c = 0;
            for (int i = 0; i < parenthesis.length(); i++) {
                String p = parenthesis.substring(i, i + 1);
                if (p.equals("(")) {
                    c++;
                } else {
                    c--;
                }
                if (c < 0) {
                    return false;
                }
            }

            return c == 0;
        }

        private void parenthesis(String p, int n) {
            if (p.length() == n * 2) {
                if (isGoodParenthesis(p)) {
                    answer.add(p);
                }
                return;
            }

            parenthesis(p + "(", n);
            parenthesis(p + ")", n);
            return;
        }

        public List<String> generateParenthesis(int n) {
            parenthesis("", n);
            return answer;
        }
    }

}

package joohoyo.leetcode.problems.medium;

// 22. Generate Parentheses
// https://leetcode.com/problems/generate-parentheses/
//

import java.util.ArrayList;
import java.util.List;

public class M22_2 {
    public static void main(String[] args) {
        new M22_2().test();
    }

    public void test() {
        M22_2.Solution s = new M22_2.Solution();
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

//        n = 4;

        List<String> answer = s.generateParenthesis(n);
        for (String a : answer) {
            System.out.println(a);
        }
    }

    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList();
            if (n == 0) {
                ans.add("");
            } else {
                for (int c = 0; c < n; ++c)
                    for (String left : generateParenthesis(c))
                        for (String right : generateParenthesis(n - 1 - c))
                            ans.add("(" + left + ")" + right);
            }

            return ans;
        }
    }

}

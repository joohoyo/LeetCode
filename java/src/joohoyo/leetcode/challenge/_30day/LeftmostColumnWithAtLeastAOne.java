package joohoyo.leetcode.challenge._30day;

// Leftmost Column with at Least a One
// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3306/
// 11:16 ~ 11:35 (19min)

import java.util.List;

interface BinaryMatrix {
    public List<Integer> dimensions();

    public int get(int x, int y);
}

public class LeftmostColumnWithAtLeastAOne {
    class Solution {
        public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
            int n = binaryMatrix.dimensions().get(0);
            int m = binaryMatrix.dimensions().get(1);

            int x = n - 1;
            int y = m - 1;
            int index = Integer.MAX_VALUE;
            while (true) {
                if (binaryMatrix.get(x, y) == 1) {
                    index = Math.min(index, y);
                    y--;
                    if (y < 0) {
                        break;
                    }
                } else {
                    x--;
                    if (x < 0) {
                        break;
                    }
                }
            }

            return index == Integer.MAX_VALUE ? -1 : index;
        }
    }
};
